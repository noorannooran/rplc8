package com.example.gb.a1100695733;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;
/**
 * Nooran El-Sherif
 * Student ID 100695733
 * COMP 3074
 * CRN 14261
 * Assignment 1
 */
public class RestaurantActivity extends Activity {

    private Restaurant restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        int cuisineNo = getIntent().getIntExtra("cuisineNo", -1);
        Spinner spinner = (Spinner) findViewById(R.id.spinnerRestaurants);
        if (cuisineNo != -1) {
            ArrayAdapter<Restaurant> adapter = setArrayAdapter(cuisineNo);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent,
                                           View selectedItemView, int position, long id) {
                    Spinner spin = (Spinner) findViewById(R.id.spinnerRestaurants);
                    Restaurant r = (Restaurant) spin.getSelectedItem();
                    ImageView imageView = (ImageView) findViewById(R.id.restaurantLogo);
                    imageView.setImageResource(r.getImageResourceId());

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    ImageView imageView = (ImageView) findViewById(R.id.restaurantLogo);
                    imageView.setImageResource(0);
                }
            });
        }
        else{
            CharSequence text = "Looks like you forgot to select a cuisine!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        }

    }

    public void buttonClickHandler(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.spinnerRestaurants);
        if (spinner.getSelectedItem() != null) {

            restaurant = (Restaurant) spinner.getSelectedItem();

            Intent intent = new Intent(this, DishActivity.class);
            intent.putExtra("EXTRA_RESTAURANT", restaurant);
            startActivity(intent);
        }
    }

    public ArrayAdapter<Restaurant> setArrayAdapter(int cuisineNo) {
        Restaurant[] restaurants = new Restaurant[1];
        switch (cuisineNo) {

            case 0:
                restaurants = Restaurant.bajoranRestaurants;
                break;
            case 1:
                restaurants = Restaurant.cardassianRestaurants;
                break;
            case 2:
                restaurants = Restaurant.ferengiRestaurants;
                break;
            case 3:
                restaurants = Restaurant.humanRestaurants;
                break;
            case 4:
                restaurants = Restaurant.klingonRestaurants;
                break;
            case 5:
                restaurants = Restaurant.vulcanRestaurants;
                break;
        }
        ArrayAdapter<Restaurant> adapter = new ArrayAdapter<Restaurant>(this, R.layout.spinner_item, restaurants);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;

    }
}
