package com.example.accessibilitytest;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;


public class LayoutExampleActivity extends AppCompatActivity {

    private LinearLayout mLayoutAllText;
    private TextView mTextReadMe;
    private TextView mTextAsA;
    private TextView mTextSingle;
    private TextView mTextItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_example);

        if(getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mLayoutAllText = (LinearLayout)findViewById(R.id.layout_text_formats);
        mTextReadMe = (TextView) findViewById(R.id.text_view_read_me);
        mTextAsA = (TextView) findViewById(R.id.text_view_as_a);
        mTextSingle = (TextView) findViewById(R.id.text_view_single);
        mTextItem = (TextView) findViewById(R.id.text_view_item);

        setTextContentDescription();
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

    private void setTextContentDescription() {

        // Note you must include v4 to use this.
        // Make sure text is read on the *layout* for VI users, not on
        //    individual textViews
        ViewCompat.setImportantForAccessibility(
                mTextReadMe, ViewCompat.IMPORTANT_FOR_ACCESSIBILITY_NO);
        ViewCompat.setImportantForAccessibility(
                mTextAsA, ViewCompat.IMPORTANT_FOR_ACCESSIBILITY_NO);
        ViewCompat.setImportantForAccessibility(
                mTextSingle, ViewCompat.IMPORTANT_FOR_ACCESSIBILITY_NO);
        ViewCompat.setImportantForAccessibility(
                mTextItem, ViewCompat.IMPORTANT_FOR_ACCESSIBILITY_NO);

        mLayoutAllText.setContentDescription(
                mTextReadMe.getText().toString() + " " +
                        mTextAsA.getText().toString()    + " " +
                        mTextSingle.getText().toString() + " " +
                        mTextItem.getText().toString()   );
    }
}
