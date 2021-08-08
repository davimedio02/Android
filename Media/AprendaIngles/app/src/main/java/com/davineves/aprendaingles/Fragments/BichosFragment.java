package com.davineves.aprendaingles.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.davineves.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BichosFragment extends Fragment implements View.OnClickListener{

    private ImageButton imgCao, imgGato, imgLeao, imgMacaco, imgOvelha, imgVaca;
    private MediaPlayer mediaPlayer;

    public BichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        //Configurando a classe
        imgCao = view.findViewById(R.id.imgCao);
        imgGato = view.findViewById(R.id.imgGato);
        imgLeao = view.findViewById(R.id.imgLeao);
        imgMacaco = view.findViewById(R.id.imgMacaco);
        imgOvelha = view.findViewById(R.id.imgOvelha);
        imgVaca = view.findViewById(R.id.imgVaca);

        //Realizando Método de ClickListener
        imgCao.setOnClickListener(this);
        imgGato.setOnClickListener(this);
        imgLeao.setOnClickListener(this);
        imgMacaco.setOnClickListener(this);
        imgOvelha.setOnClickListener(this);
        imgVaca.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.imgCao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                break;
            case R.id.imgGato:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                break;
            case R.id.imgLeao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                break;
            case R.id.imgMacaco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                break;
            case R.id.imgOvelha:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                break;
            case R.id.imgVaca:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                break;
        }
        tocarSom();
    }

    public void tocarSom(){
        if(mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    //Quando o som finalizar sua execução
                    mediaPlayer.release(); //Liberar recursos
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
