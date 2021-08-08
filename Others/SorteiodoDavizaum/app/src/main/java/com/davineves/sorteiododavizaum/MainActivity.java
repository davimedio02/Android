package com.davineves.sorteiododavizaum;

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

    public void SortearNum(View view){

        TextView texto_resultado = (TextView)findViewById(R.id.sorteio_textview);
        int numero = new Random().nextInt(11);
        texto_resultado.setText("O número sorteado é: " + numero);
    }

}
