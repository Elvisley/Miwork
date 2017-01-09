package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red","weṭeṭṭi", R.raw.color_red , R.drawable.color_red));
        words.add(new Word("red","weṭeṭṭi", R.raw.color_black , R.drawable.color_black));
        words.add(new Word("red","weṭeṭṭi", R.raw.color_dusty_yellow , R.drawable.color_dusty_yellow));
        words.add(new Word("red","weṭeṭṭi", R.raw.color_red , R.drawable.color_red));
        words.add(new Word("red","weṭeṭṭi", R.raw.color_black , R.drawable.color_black));
        words.add(new Word("red","weṭeṭṭi", R.raw.color_dusty_yellow , R.drawable.color_dusty_yellow));
        words.add(new Word("red","weṭeṭṭi", R.raw.color_red , R.drawable.color_red));
        words.add(new Word("red","weṭeṭṭi", R.raw.color_black , R.drawable.color_black));
        words.add(new Word("red","weṭeṭṭi", R.raw.color_dusty_yellow , R.drawable.color_dusty_yellow));
        words.add(new Word("red","weṭeṭṭi", R.raw.color_red , R.drawable.color_red));
        words.add(new Word("red","weṭeṭṭi", R.raw.color_black , R.drawable.color_black));
        words.add(new Word("red","weṭeṭṭi", R.raw.color_dusty_yellow , R.drawable.color_dusty_yellow));
        words.add(new Word("red","weṭeṭṭi", R.raw.color_red , R.drawable.color_red));
        words.add(new Word("red","weṭeṭṭi", R.raw.color_black , R.drawable.color_black));
        words.add(new Word("red","weṭeṭṭi", R.raw.color_dusty_yellow , R.drawable.color_dusty_yellow));

        WordAdapter itemsAdapter = new WordAdapter(this, words , R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.activity_root_view);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                releaseMediaPlayer();

                int resourceSong = words.get(position).getSongResourceId();

                mMediaPlayer = MediaPlayer.create(ColorsActivity.this , resourceSong);
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(ColorsActivity.this, "Pronto" , Toast.LENGTH_SHORT).show();
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
