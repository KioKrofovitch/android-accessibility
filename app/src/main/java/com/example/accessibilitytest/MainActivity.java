package com.example.accessibilitytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private TextView mHiddenTextView;
    private LinearLayout mAndroidImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView clickTextView = (TextView) findViewById(R.id.text_view_clickable);
        clickTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You clicked the TextView", Toast.LENGTH_SHORT).show();
            }
        });

        Button clickButton = (Button) findViewById(R.id.button_clickable);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You clicked the Button", Toast.LENGTH_SHORT).show();
            }
        });

        mHiddenTextView = (TextView) findViewById(R.id.text_view_hidden);

        Button visibilityToggleButton = (Button) findViewById(R.id.button_toggle_visibility);
        visibilityToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mHiddenTextView.getVisibility() == View.VISIBLE){
                    mHiddenTextView.setVisibility(View.GONE);
                }
                else {
                    mHiddenTextView.setVisibility(View.VISIBLE);
                    mHiddenTextView.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
                }
            }
        });

        mAndroidImages = (LinearLayout) findViewById(R.id.layout_android_images_robots);

        ImageButton androidRobotsToggleButton = (ImageButton) findViewById(R.id.image_button_pokeball);
        androidRobotsToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAndroidImages.getVisibility() == View.VISIBLE){
                    mAndroidImages.setVisibility(View.GONE);
                }
                else {
                    mAndroidImages.setVisibility(View.VISIBLE);
                    mAndroidImages.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
                }
            }
        });

        // Make sure text is read on the *layout* for VI users, not on individual textViews
//        ViewCompat.setImportantForAccessibility(mTrueCostOfItem1, ViewCompat.IMPORTANT_FOR_ACCESSIBILITY_NO);
//        ViewCompat.setImportantForAccessibility(mTrueCostOfItem2, ViewCompat.IMPORTANT_FOR_ACCESSIBILITY_NO);
//        mTrueCostLayout.setContentDescription(trueCostString1 + trueCost);
//        mTrueCostLayout.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
