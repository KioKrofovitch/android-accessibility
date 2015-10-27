package com.example.accessibilitytest;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MaterialActivity extends AppCompatActivity {

    RelativeLayout mParentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);

        if(getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Set Traversal Order for Accessibility so FAB isn't hard to access
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floating_action_button);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            fab.setAccessibilityTraversalBefore(R.id.scroll_cards);
        }

        // Fab
        mParentLayout = (RelativeLayout) findViewById(R.id.layout_material_examples);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), getString(R.string.toast_button_clicked), Toast.LENGTH_SHORT)
                        .show();
            }
        });

        // Pikachu
        CardView pikachuCard = (CardView) findViewById(R.id.card_view_pikachu_on_click);
        pikachuCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MaterialActivity.this, "Yay Pikachu!", Toast.LENGTH_LONG).show();
            }
        });

        // Charmander
        CardView charmanderCard = (CardView) findViewById(R.id.card_view_charmander);
        charmanderCard.setContentDescription(getString(R.string.charmander_access_details));
        charmanderCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MaterialActivity.this, "Yay Charmander!", Toast.LENGTH_LONG).show();
            }
        });

        // Jigglypuff
        CardView jigglyPuffCard = (CardView) findViewById(R.id.card_view_jigglypuff);
        jigglyPuffCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MaterialActivity.this, "Yay Jigglypuff!", Toast.LENGTH_LONG).show();
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
