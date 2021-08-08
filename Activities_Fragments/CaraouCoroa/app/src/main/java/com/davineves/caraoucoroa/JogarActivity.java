package com.davineves.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class JogarActivity extends AppCompatActivity {

    private ImageView imgResultado;
    private Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogar);

        imgResultado = findViewById(R.id.imgResultado);
        btVoltar = findViewById(R.id.btVoltar);

        //Recuperando Número Aleatório
        Bundle dados = getIntent().getExtras();
        int numero = dados.getInt("Numero");
        if(numero == 0){
            imgResultado.setImageResource(R.drawable.moeda_cara);
        }
        else if(numero == 1){
            imgResultado.setImageResource(R.drawable.moeda_coroa);
        }

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

                /*Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                onStop();*/
            }
        });
    }

    /*@Override
    protected void onStop() {
        super.onStop();
    }*/
}
