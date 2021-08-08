package com.davineves.transferenciadedadosentreactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private Button btEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btEnviar = findViewById(R.id.btEnviar);
        //Método de onClick para o Botão
        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), DadosActivity.class);

                //Passando dados
                intent.putExtra("Nome", "Davi");
                intent.putExtra("Idade", 19);

                //Passando objetos
                Usuario usuario = new Usuario("Davi", "davivirgula@gmail.com");
                intent.putExtra("Objeto", usuario);

                startActivity(intent);
            }
        });
    }
}
