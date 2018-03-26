package com.example.gb.a1100695733;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
/**
 * Nooran El-Sherif
 * Student ID 100695733
 * COMP 3074
 * CRN 14261
 * Assignment 1
 */
public class DishActivity extends Activity {

    public int numCheckBoxes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);
        //get restaurant sent as intent from last
        Restaurant restaurant = (Restaurant) getIntent().getSerializableExtra("EXTRA_RESTAURANT");

        addCheckButtons(restaurant);


    }

    public void buttonClickHandler(View view) {
        ArrayList<String> checked = new ArrayList<String>();
        for (int i = 0; i < numCheckBoxes; i++) {
            CheckBox cb = (CheckBox) findViewById(i + 100);
            //if checkbox is checked, add to array
            boolean isChecked = cb.isChecked();
            if (isChecked)
                checked.add(cb.getText().toString());
        }
        if (checked.size() > 0) {
            Intent intent = new Intent(this, CustomerActivity.class);
            Order order = createOrder(checked);
            intent.putExtra("EXTRA_ORDER", order);
            startActivity(intent);
        }
        else{
            CharSequence text = "Looks like you forgot to select some dishes!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        }


    }


    public void addCheckButtons(Restaurant r) {
        Dish[] dishes = r.getDishes();
        //checkbox array
        CheckBox[] checkBoxes = new CheckBox[dishes.length];

        TextView[] textViews = new TextView[dishes.length];
        //checkbox layout
        TableLayout table = (TableLayout) findViewById(R.id.tableLayout);


        for (int i = 0; i < dishes.length; i++) {
            //new row, checkbox, textview
            TableRow row = new TableRow(this);
            checkBoxes[i] = new CheckBox(this);
            textViews[i] = new TextView(this);
            //set text for dish name, dish price
            checkBoxes[i].setText(dishes[i].getName());
            textViews[i].setText(dishes[i].getPrice() + " credits");
            //set gravity of text view to -->
            textViews[i].setGravity(Gravity.CENTER_VERTICAL | Gravity.END);
            //set ids
            checkBoxes[i].setId(100 + i);
            textViews[i].setId(200 + i);
            //add checkboxes and textviews to rows
            row.addView(checkBoxes[i]);
            row.addView(textViews[i]);
            //add row to table
            table.addView(row);
            numCheckBoxes++;
        }

    }

    public Order createOrder(ArrayList<String> checked) {
        Restaurant restaurant = (Restaurant) getIntent().getSerializableExtra("EXTRA_RESTAURANT");
        Order order = new Order(restaurant);
        Dish[] dishes = restaurant.getDishes();
        for (String item : checked) {
            for (int i = 0; i < dishes.length; i++) {
                if (item.equals(dishes[i].toString())) {
                    order.addSelectedDish(dishes[i]);
                    i++;
                    break;
                }
            }
        }
        order.setTotalPrice(order.calculateTotal());
        return order;
    }
}
