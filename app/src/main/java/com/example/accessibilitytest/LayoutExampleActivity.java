package com.example.accessibilitytest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;


public class LayoutExampleActivity extends Activity {

    private LinearLayout mLayoutAllText;
    private TextView mTextReadMe;
    private TextView mTextAsA;
    private TextView mTextSingle;
    private TextView mTextItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_example);

        mLayoutAllText = (LinearLayout)findViewById(R.id.layout_text_formats);
        mTextReadMe = (TextView) findViewById(R.id.text_view_read_me);
        mTextAsA = (TextView) findViewById(R.id.text_view_as_a);
        mTextSingle = (TextView) findViewById(R.id.text_view_single);
        mTextItem = (TextView) findViewById(R.id.text_view_item);

        // Note you must include v4 to use this.
        // Make sure text is read on the *layout* for VI users, not on individual textViews
        ViewCompat.setImportantForAccessibility(mTextReadMe, ViewCompat.IMPORTANT_FOR_ACCESSIBILITY_NO);
        ViewCompat.setImportantForAccessibility(mTextAsA, ViewCompat.IMPORTANT_FOR_ACCESSIBILITY_NO);
        ViewCompat.setImportantForAccessibility(mTextSingle, ViewCompat.IMPORTANT_FOR_ACCESSIBILITY_NO);
        ViewCompat.setImportantForAccessibility(mTextItem, ViewCompat.IMPORTANT_FOR_ACCESSIBILITY_NO);

        mLayoutAllText.setContentDescription(
                mTextReadMe.getText().toString() + " " +
                mTextAsA.getText().toString()    + " " +
                mTextSingle.getText().toString() + " " +
                mTextItem.getText().toString()   );
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
