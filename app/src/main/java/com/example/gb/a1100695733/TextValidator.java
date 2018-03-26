package com.example.gb.a1100695733;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
/**
 * Nooran El-Sherif
 * Student ID 100695733
 * COMP 3074
 * CRN 14261
 * Assignment 1
 */

public abstract class TextValidator implements TextWatcher {
    private final TextView textView;

    public TextValidator(TextView textView){
        this.textView = textView;
    }
    public abstract void validate(TextView textView, String text);

    @Override
    final public void afterTextChanged(Editable s)
    {
        String text = textView.getText().toString();
        validate(textView, text);
    }
    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after){

    }
    @Override
    final public void onTextChanged(CharSequence s, int start, int count, int after){

    }

}
