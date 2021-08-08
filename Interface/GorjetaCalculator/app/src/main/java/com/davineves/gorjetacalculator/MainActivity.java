package com.davineves.gorjetacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private SeekBar seekGorjeta;
    private TextView tvPorcentagem, tvGorjeta, tvTotal;

    private double porcentagem = 0.0; //Porcentagem inicial da Gorjeta

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        seekGorjeta = findViewById(R.id.seekGorjeta);
        tvPorcentagem = findViewById(R.id.tvValorPorcentagem);
        tvGorjeta = findViewById(R.id.tvGorjeta);
        tvTotal = findViewById(R.id.tvTotal);

        //Controlar SeekBar
        seekGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = seekBar.getProgress();
                tvPorcentagem.setText(Math.round(porcentagem) + "%"); //Arredondar
                calculoGorjeta();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calculoGorjeta(){

        //Recuperar valor digitado
        double valorDigitado = Double.parseDouble(editValor.getText().toString());

        //Calculo da Gorjeta Total
        double gorjeta = valorDigitado * (porcentagem/100);
        double total = gorjeta + valorDigitado;

        //Exibir a Gorjeta Total
        tvGorjeta.setText("R$ " + Math.round(gorjeta));
        tvTotal.setText("R$ " + total);
    }

}
