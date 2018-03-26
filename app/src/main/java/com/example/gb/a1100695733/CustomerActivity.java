package com.example.gb.a1100695733;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Nooran El-Sherif
 * Student ID 100695733
 * COMP 3074
 * CRN 14261
 * Assignment 1
 */

public class CustomerActivity extends Activity {

    //activity that lets customer enter their information
    //on the enter button of this
    //validate customer info
    //if valid info == take intent extras (items-> dish) (restaurant-> Restaurant)
    //create a new Order()
    //set dishes, calculate total price, generate order id
    //send order in intent to OrderActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        //set spinner adapter
        Spinner foodRestrict = (Spinner)findViewById(R.id.spinnerFoodRestrictions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.food_restrictions, R.layout.spinner_item);
        foodRestrict.setAdapter(adapter);


        //add on text changed listeners
        addListeners();
    }

    public void buttonClickHandler(View view) {
        //get Views
        EditText firstName = (EditText) findViewById(R.id.firstName);
        EditText lastName = (EditText) findViewById(R.id.lastName);
        EditText address = (EditText) findViewById(R.id.address);
        EditText creditCard = (EditText) findViewById(R.id.creditCard);
        EditText favouriteCuisine = (EditText) findViewById(R.id.favouriteCuisine);
        EditText favouriteFood = (EditText) findViewById(R.id.favouriteFood);
        Spinner spinner = (Spinner) findViewById(R.id.spinnerFoodRestrictions);

        //check if empty values
        if (isValid(stringVal(firstName)) && isValid(stringVal(lastName))
                && isValid(stringVal(address)) && isValid(stringVal(creditCard))) {
            //check if current errors on values
            if (firstName.getError() == null && lastName.getError() == null &&
                    address.getError() == null && creditCard.getError() == null) {
                //create customer from View text
                Customer customer = newCustomer(firstName, lastName, address, creditCard,
                        favouriteCuisine, favouriteFood, spinner);
                //get order from dish activity, set customer
                Order order = (Order) getIntent().getSerializableExtra("EXTRA_ORDER");
                order.setCustomer(customer);

                //init intent, put order object as extra, start activity
                Intent intent = new Intent(this, OrderActivity.class);
                intent.putExtra("EXTRA_ORDER", order);
                startActivity(intent);

            }
        }
        else{
            CharSequence text = "Looks like you forgot to enter some information!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        }

    }

    public Customer newCustomer(EditText first, EditText last, EditText add,
                                EditText credit, EditText cuisine, EditText food,
                                Spinner spinner) {
        String cuisineStr;
        String foodStr;
        //if fields are empty, set to default
        if (!isValid(stringVal(cuisine)))
            cuisineStr = "None";
        else
            cuisineStr = stringVal(cuisine);
        if (!isValid(stringVal(food)))
            foodStr = "None";
        else
            foodStr = stringVal(food);
        //get string values of views
        String firstName = stringVal(first);
        String lastName = stringVal(last);
        String address = stringVal(add);
        String creditCard = stringVal(credit);
        String spinnerStr = spinner.getSelectedItem().toString();

        //construct and return new Customer object from input values
        Customer customer = new Customer(firstName, lastName, address,
                creditCard, foodStr, cuisineStr, spinnerStr);
        return customer;
    }

    public String stringVal(EditText editText) {
        return editText.getText().toString();
    }

    public void addListeners() {
        //adds text changed listeners to editText views
        //find views
        EditText firstName = (EditText) findViewById(R.id.firstName);
        EditText lastName = (EditText) findViewById(R.id.lastName);
        EditText address = (EditText) findViewById(R.id.address);
        EditText creditCard = (EditText) findViewById(R.id.creditCard);

        firstName.addTextChangedListener(new TextValidator(firstName) {
            @Override
            public void validate(TextView textView, String s) {
                if (s.trim().length() == 0)
                    textView.setError("First Name is required"); //error message
                else
                    textView.setError(null);
            }
        });
        lastName.addTextChangedListener(new TextValidator(lastName) {
            @Override
            public void validate(TextView textView, String s) {
                if (!isValid(s))
                    textView.setError("Last Name is required."); //error message
                else
                    textView.setError(null);
            }
        });
        address.addTextChangedListener(new TextValidator(address) {
            @Override
            public void validate(TextView textView, String s) {
                if (!isValidAddress(s))
                    textView.setError("Invalid address. Correct format: 123 Fake St or 1234 Fake Street"); //error message
                else
                    textView.setError(null);
            }
        });
        creditCard.addTextChangedListener(new TextValidator(creditCard) {
            @Override
            public void validate(TextView textView, String s) {
                if (!(isValidCreditNumber(s)))
                    textView.setError("Invalid credit card number."); //error message
                else
                    textView.setError(null);
            }
        });


    }

    public boolean isValid(String s)
    //if string s length is 0 return false
    {
        s = s.trim();
        if (s.length() == 0)
            return false;
        return true;
    }

    public boolean isValidCreditNumber(String s) {
        if (!isValid(s))
            return false;

        else
            return true;
    }

    public boolean isValidAddress(String s) {
        //returns true if address matches format "123 Fake St/Ave || 123 Fake Street/Avenue"
        if (!isValid(s))
            return false;
        String regex = "\\d+\\s+(([a-zA-Z])+|([a-zA-Z]+\\s+[a-zA-Z]+))\\s+[a-zA-Z]*";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(s);
        if (matcher.matches())
            return true;
        return false;
    }


}
