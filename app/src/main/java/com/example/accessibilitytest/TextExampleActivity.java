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


public class TextExampleActivity extends Activity {

    private TextView mHiddenTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_example);

        if(getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mHiddenTextView = (TextView) findViewById(R.id.text_view_hidden);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mHiddenTextView.setAccessibilityLiveRegion(View.ACCESSIBILITY_LIVE_REGION_POLITE);
        }

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
