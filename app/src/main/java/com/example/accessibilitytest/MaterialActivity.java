package com.example.accessibilitytest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;


public class MaterialActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);

        // Pikachu
        CardView pikachuCard = (CardView) findViewById(R.id.card_view_pikachu_on_click);
        pikachuCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MaterialActivity.this, "Yay Pikachu!", Toast.LENGTH_LONG).show();
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

        // Charmander
        CardView charmanderCard = (CardView) findViewById(R.id.card_view_charmander);
        charmanderCard.setContentDescription(getString(R.string.charmander_access_details));
        charmanderCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MaterialActivity.this, "Yay Charmander!", Toast.LENGTH_LONG).show();
            }
        });

        //Set Fab Sizes to Mini
        FloatingActionsMenu menu = (FloatingActionsMenu) findViewById(R.id.floating_action_menu);
        menu.getm
                ((FloatingActionButton) findViewById(R.id.action_a)).setSize(FloatingActionButton.SIZE_MINI);
        ((FloatingActionButton) findViewById(R.id.action_b)).setSize(FloatingActionButton.SIZE_MINI);
        ((FloatingActionButton) findViewById(R.id.action_c)).setSize(FloatingActionButton.SIZE_MINI);
    }

}
