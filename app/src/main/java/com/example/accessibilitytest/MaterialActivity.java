package com.example.accessibilitytest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;


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
    }

}
