package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class FinalPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);

        VideoView videoView1 = findViewById(R.id.video1);
        VideoView videoView2 = findViewById(R.id.videoView2);

        String path1 = "android.resource://" + getPackageName() + "/" + R.raw.justinbieber; // For local raw resource
        videoView1.setVideoURI(Uri.parse(path1));

        String path2 = "android.resource://" + getPackageName() + "/" + R.raw.chistmas; // For local raw resource
        videoView2.setVideoURI(Uri.parse(path2));

        videoView1.start();
        videoView2.start();
    }
}