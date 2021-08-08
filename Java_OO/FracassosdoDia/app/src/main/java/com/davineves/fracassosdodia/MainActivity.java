package com.davineves.fracassosdodia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarNovaFrase(View view){ //View chama componente a partir da interface

        //String[] frases = new String[10];
        String[] frases = {
                "Nunca deixe ninguém dizer que você não consegue. Diga você mesmo: eu NÃO consigo!",
                "Lute como NUNCA! Perca como SEMPRE!",
                "Nunca foi azar. Sempre foi INCOMPETÊNCIA",
                "Enquanto houver esperança, NÃO haverá solução.",
                "Nunca é tarde demais para errar tudo de novo.",
                "O caminho é longo, mas a derrota é certa.",
                "A prática leva à frustação.",
                "Enquanto houver a vontade de lutar, haverá a certeza de perder.",
                "É errando que se aprende a errar.",
                "O esforço de hoje é o fracasso de amanhã."

        };

        int num_frase = new Random().nextInt(frases.length);
        TextView texto_fracasso = (TextView)findViewById(R.id.fracasso_txt);
        texto_fracasso.setText(frases[num_frase]);

    }

}
