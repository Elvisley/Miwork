package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one","lutti", R.drawable.number_one));
        words.add(new Word("one","lutti", R.drawable.number_one));
        words.add(new Word("one","lutti", R.drawable.number_one));
        words.add(new Word("one","lutti", R.drawable.number_one));
        words.add(new Word("one","lutti", R.drawable.number_one));
        words.add(new Word("one","lutti", R.drawable.number_one));

        WordAdapter itemsAdapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.activity_root_view);

        listView.setAdapter(itemsAdapter);

    }
}
