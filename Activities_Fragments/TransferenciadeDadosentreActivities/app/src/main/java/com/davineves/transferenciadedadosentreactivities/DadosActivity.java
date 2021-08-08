package com.davineves.transferenciadedadosentreactivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;

import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class DadosActivity extends AppCompatActivity {

    private TextView txtNome, txtNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        txtNome = findViewById(R.id.textNome);
        txtNumero = findViewById(R.id.textNumero);

        //Recuperando os dados
        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("Nome");
        int numero = dados.getInt("Idade");
        Usuario usuario = (Usuario)dados.getSerializable("Objeto");

        txtNome.setText(usuario.getEmail());
        txtNumero.setText(String.valueOf(numero)); //Conversão do Valor para String
    }


}
