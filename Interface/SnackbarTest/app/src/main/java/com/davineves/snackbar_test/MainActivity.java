package com.davineves.snackbar_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
/*
    Parâmetro View ->
 */

public class MainActivity extends AppCompatActivity {

    private Button btnAbrirSnackbar;
    private Button btnFecharSnackbar;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAbrirSnackbar = findViewById(R.id.btnAbrirSnackbar);
        btnAbrirSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Importar dependencias - lembra Toast
                //snackbar =
                Snackbar.make(
                        v,
                        "Botão pressionado!",
                        Snackbar.LENGTH_LONG
                ).setAction("Confirmar", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       btnAbrirSnackbar.setText("Botão Alterado!");
                    }
                }).setActionTextColor(getResources().getColor(R.color.colorPrimaryDark))
                        .show();

                //snackbar.show();
            }
        });

        //Normalmente não utilizado - por conta da Action do Snackbar
        /*btnFecharSnackbar = findViewById(R.id.btnFecharSnackbar);
        btnFecharSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                snackbar.dismiss();
            }
        });*/
    }
}
