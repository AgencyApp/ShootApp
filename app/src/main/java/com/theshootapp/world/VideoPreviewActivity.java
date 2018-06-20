package com.theshootapp.world;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_preview);
        Intent i=getIntent();
        String path=i.getStringExtra("videoPath");
        VideoView videoView = (VideoView)findViewById(R.id.videoPreviewView);
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);

        videoView.setVideoURI(Uri.parse(path));

        videoView.requestFocus();
        videoView.start();
    }
}
