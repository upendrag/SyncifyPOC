package com.upendra.poc.youtubeplayer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class PlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String YOUTUBE_API_KEY = "AIzaSyAxJDtneemNcnCT75LcE0v986IYBlixBkc";

    private YouTubePlayerView playerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        playerView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        playerView.initialize(YOUTUBE_API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer youTubePlayer, boolean restored) {
        if (!restored) {
            youTubePlayer.loadVideo(getIntent().getStringExtra(MainActivity.MESSAGE_VIDEO_URL));
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "YouTube player initialization failed", Toast.LENGTH_LONG).show();
    }
}
