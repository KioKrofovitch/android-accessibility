package com.example.accessibilitytest;

import android.app.Activity;
import android.os.Bundle;


public class BadExampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_example);
    }

}
