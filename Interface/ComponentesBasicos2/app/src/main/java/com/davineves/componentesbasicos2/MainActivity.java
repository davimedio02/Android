package com.davineves.componentesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Switch swLembraSenha;
    private ToggleButton tgOnOff;
    private CheckBox cbLembraSenha;
    private Button btEnviar;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swLembraSenha = findViewById(R.id.swLembraSenha);
        tgOnOff = findViewById(R.id.tbOnOff);
        cbLembraSenha = findViewById(R.id.cbLembraSenha);
        btEnviar = findViewById(R.id.btEnviar);
        tvResultado = findViewById(R.id.tvResultado);

        tvResultado.setVisibility(View.GONE);
    }

    public void enviar(View view){

        //Verificação se cada componentes estão checados (mesma maneira para os três)

        if(tgOnOff.isChecked()){
            tvResultado.setText("Toggle ligado!");
        }
        else{
            tvResultado.setText("Toggle desligado.");
        }

        /*if(swLembraSenha.isChecked()){
            tvResultado.setText("Switch ligado!");
        }
        else{
            tvResultado.setText("Switch desligado.");
        }

        if(cbLembraSenha.isChecked()){
            tvResultado.setText("CheckBox ligado!");
        }
        else{
            tvResultado.setText("CheckBox desligado.");
        }*/

        tvResultado.setVisibility(View.VISIBLE);
    }

}
