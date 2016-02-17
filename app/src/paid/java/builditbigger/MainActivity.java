package com.udacity.gradle.builditbigger;

import android.os.Bundle;


public class MainActivity extends MainActivityBase {

    private final static String TAG = "Paid_MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
