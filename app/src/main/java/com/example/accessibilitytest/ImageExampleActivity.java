package com.example.accessibilitytest;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ImageExampleActivity extends AppCompatActivity {

    private Button mRevealAnswerButton;
    private TextView mQuizAnswer;

    private ImageButton mPokemonToggleButton;
    private LinearLayout mAllPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_example);

        if(getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mQuizAnswer = (TextView) findViewById(R.id.text_quiz_answer);
        mRevealAnswerButton = (Button) findViewById(R.id.button_reveal_answer);
        mRevealAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mQuizAnswer.getVisibility() == View.VISIBLE){
                    mQuizAnswer.setVisibility(View.INVISIBLE);
                    mRevealAnswerButton.setText(R.string.reveal_answer);
                }
                else {
                    mQuizAnswer.setVisibility(View.VISIBLE);
                    mRevealAnswerButton.setText(R.string.hide_answer);
                }
            }
        });

        mAllPokemon = (LinearLayout) findViewById(R.id.layout_all_pokemon);
        mPokemonToggleButton = (ImageButton) findViewById(R.id.image_button_pokeball);
        mPokemonToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAllPokemon.getVisibility() == View.VISIBLE){
                    mAllPokemon.setVisibility(View.GONE);
                    mPokemonToggleButton.setImageResource(R.drawable.pokeball_closed);
                    mPokemonToggleButton.setContentDescription(getString(R.string.show_pokemon));
                }
                else {
                    mAllPokemon.setVisibility(View.VISIBLE);
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mAllPokemon.announceForAccessibility(getString(R.string.now_showing_pokemon));
                    }
                    else{
                        mAllPokemon.setContentDescription(getString(R.string.now_showing_pokemon));
                        mAllPokemon.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
                    }
                    mPokemonToggleButton.setImageResource(R.drawable.pokeball_open);
                    mPokemonToggleButton.setContentDescription(getString(R.string.hide_pokemon));
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
