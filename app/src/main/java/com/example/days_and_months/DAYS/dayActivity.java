package com.example.days_and_months.DAYS;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.days_and_months.R;

import java.util.ArrayList;

public class dayActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    /**
     * This listener gets triggered when the {@link android.media.MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        final ArrayList<Day> days = new ArrayList<Day>();
        days.add(new Day("SUNDAY", R.raw.sunday));
        days.add(new Day("MONDAY", R.raw.monday));
        days.add(new Day("TUESDAY", R.raw.tuesday));
        days.add(new Day("WEDNESDAY", R.raw.wednesday));
        days.add(new Day("THURSDAY", R.raw.thursday));
        days.add(new Day("FRIDAY", R.raw.friday));
        days.add(new Day("SATURDAY", R.raw.saturday));

        DayAdpater adapter = new DayAdpater(this, days);
        ListView listView = (ListView) findViewById(R.id.day_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                Day day = days.get(position);
                mediaPlayer = MediaPlayer.create(dayActivity.this, day.getMaudioResourceId());
                mediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}