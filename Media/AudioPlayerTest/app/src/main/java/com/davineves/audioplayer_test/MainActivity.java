package com.davineves.audioplayer_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Carregar música automaticamente quando o app é carregado
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.thetrooper);


        //Controlar volume da música
        iniciarSeekBar();
    }

    //Configurar SeekBar de Volume
    private void iniciarSeekBar() {
        SeekBar seekVolume;
        seekVolume = findViewById(R.id.seekVolume);

        //Configurar o Áudio Manager (Vol atual, max e min)
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //Recuperar Valores Máx/Atual de Volume
        int volumeMaximo = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumeAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //Configurar valores maximos para a SeekBar
        seekVolume.setMax(volumeMaximo);
        //Configurar valores atuais para a SeekBar
        seekVolume.setProgress(volumeAtual);

        //Configurando mov. do SeekBar
        seekVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
                //audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, AudioManager.FLAG_SHOW_UI);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void executarSom(View view) {
        if (mediaPlayer != null) {
            //Se a música n existir, não abrirá
            mediaPlayer.start();
        }
    }

    public void pausarSom(View view) {
        if (mediaPlayer.isPlaying()) {
            //Se a música estiver sendo executada
            mediaPlayer.pause();
        }
    }

    public void pararSom(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop(); //Quando a música é parada, necessário criar dnv
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.thetrooper);
        }
    }

    //Bonus: parando a musica ao sair do app (onStop)
    /*@Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer.isPlaying()) {
            //Se a música estiver sendo executada
            mediaPlayer.pause();
        }
    }*/
    //Economizar recursos ao fechar app e musica parada
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release(); //Liberar memória celular
        }
    }
}
