package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red","weṭeṭṭi", R.drawable.color_red));
        words.add(new Word("red","weṭeṭṭi", R.drawable.color_red));
        words.add(new Word("red","weṭeṭṭi", R.drawable.color_red));
        words.add(new Word("red","weṭeṭṭi", R.drawable.color_red));
        words.add(new Word("red","weṭeṭṭi", R.drawable.color_red));
        words.add(new Word("red","weṭeṭṭi", R.drawable.color_red));
        words.add(new Word("red","weṭeṭṭi", R.drawable.color_red));
        words.add(new Word("red","weṭeṭṭi", R.drawable.color_red));



        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.activity_root_view);

        listView.setAdapter(itemsAdapter);
    }
}
