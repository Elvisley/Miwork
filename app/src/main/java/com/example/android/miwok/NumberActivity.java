package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.*;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;


public class NumberActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one","lutti", R.raw.number_one , R.drawable.number_one));
        words.add(new Word("Two","lutti", R.raw.number_two , R.drawable.number_two));
        words.add(new Word("three","lutti", R.raw.number_three , R.drawable.number_three));
        words.add(new Word("four","lutti", R.raw.number_four , R.drawable.number_four));
        words.add(new Word("Five","lutti", R.raw.number_five, R.drawable.number_five));
        words.add(new Word("Sixe","lutti", R.raw.number_six , R.drawable.number_six));
        words.add(new Word("Seven","lutti", R.raw.number_seven , R.drawable.number_seven));
        words.add(new Word("Eight","lutti", R.raw.number_eight , R.drawable.number_eight));
        words.add(new Word("Nine","lutti", R.raw.number_nine , R.drawable.number_nine));
        words.add(new Word("Ten","lutti", R.raw.number_ten , R.drawable.number_ten));

        WordAdapter itemsAdapter = new WordAdapter(this, words , R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.activity_root_view);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                releaseMediaPlayer();

                int resourceSong = words.get(position).getSongResourceId();
                mMediaPlayer = MediaPlayer.create(NumberActivity.this , resourceSong);
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(NumberActivity.this, "Pronto" , Toast.LENGTH_SHORT).show();
                        releaseMediaPlayer();
                    }
                });
            }


        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }


}
