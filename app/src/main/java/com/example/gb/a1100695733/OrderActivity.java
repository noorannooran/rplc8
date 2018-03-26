package com.example.gb.a1100695733;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
/**
 * Nooran El-Sherif
 * Student ID 100695733
 * COMP 3074
 * CRN 14261
 * Assignment 1
 */
public class OrderActivity extends Activity {

    //displays order information to customer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //get order from intent, display to textview
        Order order = (Order)getIntent().getSerializableExtra("EXTRA_ORDER");
        TextView textView = (TextView)findViewById(R.id.textOrder);
        textView.setText(order.toString());
    }
}
