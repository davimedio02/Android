package com.eric.conectandosaude.Activity.MenuMain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.eric.conectandosaude.Activity.Main.MainActivity;
import com.eric.conectandosaude.R;

public class SobreAppActivity extends AppCompatActivity {

    //CPF Paciente
    //private String CPFPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_app);
        Toolbar toolbar = findViewById(R.id.toolbar3);
        toolbar.setTitle("Sobre o Aplicativo");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        //Recuperando CPF do Paciente
        //CPFPaciente = (String) getIntent().getSerializableExtra("cpf");

    }

    @Override
    public void onBackPressed() {
        //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        //intent.putExtra("cpf", CPFPaciente);
        //startActivity(intent);
        finish();
    }
}
