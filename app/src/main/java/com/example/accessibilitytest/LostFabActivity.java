package com.example.accessibilitytest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LostFabActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_fab);

        ListView mPokemonList = (ListView) findViewById(R.id.list_pokemon);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, PokemonData.sPokemonStrings);
        mPokemonList.setAdapter(adapter);
    }

}
