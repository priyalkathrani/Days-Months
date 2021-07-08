package com.example.days_and_months.MONTH;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.days_and_months.R;

import java.util.ArrayList;

public class monthActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
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
        setContentView(R.layout.activity_month);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FE309A"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#CD016A"));
        }

        final ArrayList<Month> months = new ArrayList<Month>();
        months.add(new Month("JANUARY", "31 Days", R.raw.january));
        months.add(new Month("FEBRUARY", "28/29 Days", R.raw.february));
        months.add(new Month("MARCH", "31 Days", R.raw.march));
        months.add(new Month("APRIL", "30 Days", R.raw.april));
        months.add(new Month("MAY", "31 Days", R.raw.may));
        months.add(new Month("JUNE","30 Days", R.raw.june));
        months.add(new Month("JULY", "31 Days", R.raw.july));
        months.add(new Month("AUGUST", "31 Days", R.raw.august));
        months.add(new Month("SEPTEMBER", "30 Days", R.raw.september));
        months.add(new Month("OCTOBER", "31 Days", R.raw.october));
        months.add(new Month("NOVEMBER", "30 Days", R.raw.november));
        months.add(new Month("DECEMBER", "31 Days", R.raw.december));

        MonthAdapter adapter = new MonthAdapter(this, months);
        ListView listView = (ListView) findViewById(R.id.month_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                Month month = months.get(position);
                mediaPlayer = MediaPlayer.create(monthActivity.this, month.getMaudioResourceId());
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