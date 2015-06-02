package com.example.accessibilitytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class BadExampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_example);

        TextView moreOptionsText = (TextView) findViewById(R.id.text_view_clickable);
        moreOptionsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), getString(R.string.toast_button_clicked), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
