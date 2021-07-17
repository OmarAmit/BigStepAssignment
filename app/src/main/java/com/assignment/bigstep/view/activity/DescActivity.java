package com.assignment.bigstep.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.assignment.bigstep.R;
import com.assignment.bigstep.databinding.ActivityMusicDescBinding;
import com.assignment.bigstep.model.MusicDescDatabaseModel;
import com.assignment.bigstep.model.Video;
import com.assignment.bigstep.roomdatabase.DatabaseClient;

public class DescActivity extends AppCompatActivity {

    private Video music;
    private ActivityMusicDescBinding activityMusicDescBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_desc);

        activityMusicDescBinding = DataBindingUtil.setContentView(this, R.layout.activity_music_desc);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        if (intent.hasExtra("music")) {

            music = getIntent().getParcelableExtra("music");
            activityMusicDescBinding.setMusic(music);
            getSupportActionBar().setTitle(music.getTrackName());

        }
        insertDataIntoDatabase();
    }

    private void insertDataIntoDatabase() {
        //
        String imageUrl = music.getArtworkUrl100();
        String trackName = music.getTrackName();
        String artistName = music.getArtistName();
        Double price = music.getTrackPrice();
        String genere = music.getPrimaryGenreName();

        DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                .taskDao().insert(new MusicDescDatabaseModel(0, imageUrl, trackName, artistName, price, genere));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}