package com.davineves.alcoolougasolina_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText etAlcool, etGasolina;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAlcool = findViewById(R.id.etAlcool);
        etGasolina = findViewById(R.id.etGasolina);
        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setVisibility(View.GONE);
    }



    public void calcularResultado(View view){

        //Recuperar valores digitados
        String alcool = etAlcool.getText().toString();
        String gasolina = etGasolina.getText().toString();


        //Validação dos campos digitados
        if(validarCampos(alcool, gasolina)){

            //Verificação de qual é maior
            this.calcularMelhorPreco(alcool, gasolina);

        }else{
            tvResultado.setText("Preencha os preços primeiro!");
        }

        tvResultado.setVisibility(View.VISIBLE);
    }

    public void calcularMelhorPreco(String alcool, String gasolina){

        //Conversão de String para Números
        Double precoAlcool = Double.parseDouble(alcool);
        Double precoGasolina = Double.parseDouble(gasolina);

        //Fórmula: Álcool/Gasolina.
        //Se o resultado for >= 0.7, utilizar gasolina
        Double resultado = (precoAlcool/precoGasolina)*1.0;

        if(resultado >= 0.7){
            tvResultado.setText("Melhor utilizar Gasolina!");
        } else{
            tvResultado.setText("Melhor utilizar Álcool!");
        }

    }

    public Boolean validarCampos(String alcool, String gasolina){

        if(alcool.isEmpty() || gasolina.isEmpty()) {
            return false;
        }

        return true;
    }
}
