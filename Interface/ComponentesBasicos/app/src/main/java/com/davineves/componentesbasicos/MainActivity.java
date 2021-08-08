package com.davineves.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etNomeProduto;
    private TextView tvResultado;

    private CheckBox cbBranco, cbVerde, cbVermelho;
    List<String> check = new ArrayList<String>(); //Array com elementos de lista do tipo String

    private RadioGroup rgEstoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNomeProduto = findViewById(R.id.etNomeProduto);
        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setVisibility(View.INVISIBLE);

        cbBranco = findViewById(R.id.cbBranco);
        cbVerde = findViewById(R.id.cbVerde);
        cbVermelho = findViewById(R.id.cbVermelho);

        rgEstoque = findViewById(R.id.rgEstoque);
        verificaRadioButton();
    }

    public void verificaCheck(){

        check.clear();

        if(cbBranco.isChecked()){
            check.add(cbBranco.getText().toString());
        }
        if(cbVerde.isChecked()){
            check.add(cbVerde.getText().toString());
        }
        if(cbVermelho.isChecked()){
            check.add(cbVermelho.getText().toString());
        }

        /*if(!check.isEmpty())
            tvResultado.setText(check.toString());*/
    }

    public void verificaRadioButton(){

        rgEstoque.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbSim){ //checkedId retorna o número que identifica componente selecionado na tela; R.id.rbSim retorna um número
                    tvResultado.setText("Sim");
                }
                else if(checkedId == R.id.rbNao){
                    tvResultado.setText("Não");
                }
            }
        });
    }

    public void btEnviar(View view){

        /*//Texto do EditText

        String nomeProduto = etNomeProduto.getText().toString();
        if(nomeProduto.isEmpty() == false){
            tvResultado.setVisibility(View.VISIBLE);
            tvResultado.setText(nomeProduto);
        }*/

        /*//Texto para os CheckBox

        verificaCheck();
        tvResultado.setVisibility(View.VISIBLE);*/

        verificaRadioButton();
        tvResultado.setVisibility(View.VISIBLE);
    }
}
