package com.example.accessibilitytest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
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

        TextView clickTextView = (TextView) findViewById(R.id.text_view_clickable);
        clickTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "You clicked the TextView", Toast.LENGTH_SHORT).show();
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
