package com.eric.conectandosaude.Activity.Agendamento;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.eric.conectandosaude.R;

public class PrimeiroEspActivity extends AppCompatActivity {

    //Recuperando CPF (para novo agendamento)
    private String CPFPaciente;

    //Recuperando Botões
    private Button btnCardiologia, btnClinicoGeral, btnOrtopedia, btnPediatria;

    //Função para Botões
    private View.OnClickListener desejoNovoAgendamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeiro_esp);
        //Toolbar (config)
        Toolbar toolbar = findViewById(R.id.toolbarPrimeiro);
        toolbar.setTitle("NOVO AGENDAMENTO");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        //Recuperando CPF
        CPFPaciente = (String) getIntent().getSerializableExtra("cpfPaciente");

        //Recuperando Campos
        btnCardiologia = findViewById(R.id.btnCardiologia);
        btnClinicoGeral = findViewById(R.id.btnClinicoGeral);
        btnOrtopedia = findViewById(R.id.btnOrtopedia);
        btnPediatria = findViewById(R.id.btnPediatria);

        //Função para botões
        desejoNovoAgendamento = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Especialidade = "";
                switch (v.getId()){
                    case R.id.btnCardiologia:
                        Especialidade = "Cardiologia";
                        break;
                    case R.id.btnClinicoGeral:
                        Especialidade = "Clínico Geral";
                        break;
                    case R.id.btnOrtopedia:
                        Especialidade = "Ortopedia";
                        break;
                    case R.id.btnPediatria:
                        Especialidade = "Pediatria";
                        break;
                }
                chamarProximaActivity(Especialidade);
            }
        };

        //Inserindo a função nos botões
        btnCardiologia.setOnClickListener(desejoNovoAgendamento);
        btnClinicoGeral.setOnClickListener(desejoNovoAgendamento);
        btnPediatria.setOnClickListener(desejoNovoAgendamento);
        btnOrtopedia.setOnClickListener(desejoNovoAgendamento);
    }

    public void chamarProximaActivity(String Especialidade){
        Intent intent = new Intent(getApplicationContext(), SegundoListMedActivity.class);
        intent.putExtra("especialidade", Especialidade);
        intent.putExtra("cpfPaciente", CPFPaciente);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(PrimeiroEspActivity.this);
        dialog.setTitle("Cancelar Novo Agendamento");
        dialog.setMessage("Deseja realmente cancelar o novo agendamento?");
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.setNegativeButton("Não", null);
        dialog.create();
        dialog.show();

        //super.onBackPressed();
    }
}
