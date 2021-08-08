package com.davineves.aprendaingles.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.davineves.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener{

    private ImageButton btnUm, btnDois, btnTres, btnQuatro, btnCinco, btnSeis;
    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        //Configurando a classe
        btnUm = view.findViewById(R.id.imgUm);
        btnDois = view.findViewById(R.id.imgDois);
        btnTres = view.findViewById(R.id.imgTres);
        btnQuatro = view.findViewById(R.id.imgQuatro);
        btnCinco = view.findViewById(R.id.imgCinco);
        btnSeis = view.findViewById(R.id.imgSeis);

        //Realizando Método de ClickListener
        btnUm.setOnClickListener(this);
        btnDois.setOnClickListener(this);
        btnTres.setOnClickListener(this);
        btnQuatro.setOnClickListener(this);
        btnCinco.setOnClickListener(this);
        btnSeis.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgUm:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                break;
            case R.id.imgDois:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                break;
            case R.id.imgTres:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                break;
            case R.id.imgQuatro:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                break;
            case R.id.imgCinco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                break;
            case R.id.imgSeis:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
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
