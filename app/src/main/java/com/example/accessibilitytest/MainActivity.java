package com.example.accessibilitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bad Examples
        Button badExampleButton = (Button) findViewById(R.id.button_bad_example);
        badExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BadExampleActivity.class);
                startActivity(intent);
            }
        });

        // TextView Examples
        Button textExampleButton = (Button)findViewById(R.id.button_textview_example);
        textExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TextExampleActivity.class);
                startActivity(intent);
            }
        });

        // ImageView Examples
        Button imageExampleButton = (Button)findViewById(R.id.button_imageview_example);
        imageExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ImageExampleActivity.class);
                startActivity(intent);
            }
        });

        // Layout Examples
        Button layoutExampleButton = (Button)findViewById(R.id.button_layout_example);
        layoutExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LayoutExampleActivity.class);
                startActivity(intent);
            }
        });

        // Material Design Examples
        Button materialExampleButton = (Button) findViewById(R.id.button_material_example);
        materialExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MaterialActivity.class);
                startActivity(intent);
            }
        });

    }
}
