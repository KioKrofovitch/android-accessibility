package com.example.accessibilitytest;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class TextExampleActivity extends Activity {

    private TextView mHiddenTextView;
    private TextView mNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_example);

        if(getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mHiddenTextView = (TextView) findViewById(R.id.text_view_hidden);

        Button clickTextView = (Button) findViewById(R.id.button_show_toast);
        clickTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), getString(R.string.toast_button_clicked), Toast.LENGTH_SHORT).show();
            }
        });

        Button visibilityToggleButton = (Button) findViewById(R.id.button_toggle_visibility);
        visibilityToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mHiddenTextView.getVisibility() == View.VISIBLE) {
                    mHiddenTextView.setVisibility(View.GONE);
                } else {
                    mHiddenTextView.setVisibility(View.VISIBLE);
                    mHiddenTextView.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
                }
            }
        });

        mNumberTextView = (TextView) findViewById(R.id.text_view_numbers);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mNumberTextView.setAccessibilityLiveRegion(View.ACCESSIBILITY_LIVE_REGION_POLITE);
        }

        Button numberUpdateButton = (Button) findViewById(R.id.button_change_number);
        numberUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int randomNum = rand.nextInt(25);
                String numString = String.valueOf(randomNum);

                mNumberTextView.setText(numString);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
