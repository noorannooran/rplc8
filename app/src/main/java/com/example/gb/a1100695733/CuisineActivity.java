package com.example.gb.a1100695733;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
/**
 * Nooran El-Sherif
 * Student ID 100695733
 * COMP 3074
 * CRN 14261
 * Assignment 1
 */
public class CuisineActivity extends Activity {

    public String EXTRA_CUISINENO = "cuisineNo";
    public int cuisineId;
    public RadioGroup checkedGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine);

        addRadioButtons();

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioCuisine);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkedGroup = group;
                if (checkedId != -1) {
                    cuisineId = checkedId;
                }
            }
       });

    }

    public void addRadioButtons() {
        RadioButton[] radioButtons = new RadioButton[Cuisine.cuisines.length];
        RadioGroup radioCuisine = (RadioGroup) findViewById(R.id.radioCuisine);
        for (int i = 0; i < Cuisine.cuisines.length; i++) {
            radioButtons[i] = new RadioButton(this);
            radioButtons[i].setText(Cuisine.cuisines[i].getName());
            radioButtons[i].setId(i);

            radioCuisine.addView(radioButtons[i]);
        }

    }

    public void buttonClickHandler(View view) {
        if (checkedGroup.getCheckedRadioButtonId() != -1) {
            Intent intent = new Intent(this, RestaurantActivity.class);
            intent.putExtra(EXTRA_CUISINENO, cuisineId);
            startActivity(intent);

        }
        else{
            CharSequence text = "Looks like you forgot to select a restaurant!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        }
    }

}
