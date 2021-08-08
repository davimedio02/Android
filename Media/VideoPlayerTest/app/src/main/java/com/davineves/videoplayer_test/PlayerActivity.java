package com.davineves.videoplayer_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        //Modo Full-Screen

        //Escondendo a StatusBar e Barra de Navegação
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        //Escondendo a ActionBar
        getSupportActionBar().hide();


        //Executando o vídeo
        videoView = findViewById(R.id.videoView);
            //Cotroladores do vídeo (padrão Android)
        videoView.setMediaController(new MediaController(this));
            //Setando o vídeo
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.start();
    }
}
