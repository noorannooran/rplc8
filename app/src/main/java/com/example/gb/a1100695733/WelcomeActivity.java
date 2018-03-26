package com.example.gb.a1100695733;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * Nooran El-Sherif
 * Student ID 100695733
 * COMP 3074
 * CRN 14261
 * Assignment 1
 */
public class WelcomeActivity extends Activity {

    //welcome activity for app
    //displays logo and enter button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button myButton = (Button)findViewById(R.id.buttonEnter);
        myButton.setTransformationMethod(null);
    }

    //on enter button click, starts new activity: order activity
    public void buttonClickHandler(View view){
        //new intent -> cuisineActivity
        Intent intent = new Intent(this, CuisineActivity.class);
        //call start activity
        startActivity(intent);
    }
}
