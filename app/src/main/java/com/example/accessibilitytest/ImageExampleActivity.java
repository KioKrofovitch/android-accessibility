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


public class ImageExampleActivity extends Activity {

    private Button mRevealAnswerButton;
    private TextView mQuizAnswer;

    private ImageButton mPokemonToggleButton;
    private LinearLayout mAllPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_example);

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
                    mAllPokemon.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
                    mPokemonToggleButton.setImageResource(R.drawable.pokeball_open);
                    mPokemonToggleButton.setContentDescription(getString(R.string.hide_pokemon));
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
