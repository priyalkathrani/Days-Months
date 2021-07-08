package com.example.days_and_months.COLOR;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.days_and_months.DAYS.Day;
import com.example.days_and_months.DAYS.DayAdpater;
import com.example.days_and_months.DAYS.dayActivity;
import com.example.days_and_months.R;

import java.util.ArrayList;

public class colorActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_color);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(android.graphics.Color.parseColor("#FB7602"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(android.graphics.Color.parseColor("#B35300"));
        }

        final ArrayList<Color> colors = new ArrayList<Color>();
        colors.add(new Color("RED", R.raw.red));
        colors.add(new Color("ORANGE", R.raw.orange));
        colors.add(new Color("YELLOW", R.raw.yellow));
        colors.add(new Color("GREEN", R.raw.green));
        colors.add(new Color("BLUE", R.raw.blue));
        colors.add(new Color("INDIGO", R.raw.indigo));
        colors.add(new Color("VIOLET", R.raw.violet));

        ColorAdapter adapter = new ColorAdapter(this, colors);
        ListView listView = (ListView) findViewById(R.id.color_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                Color color = colors.get(position);
                mediaPlayer = MediaPlayer.create(colorActivity.this, color.getMaudioResourceId());
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