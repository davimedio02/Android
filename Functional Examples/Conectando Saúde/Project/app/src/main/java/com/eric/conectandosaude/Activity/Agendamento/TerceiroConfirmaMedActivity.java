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
import android.widget.TextView;

import com.eric.conectandosaude.BancoDeDados.Model.MedicoModelo;
import com.eric.conectandosaude.R;

public class TerceiroConfirmaMedActivity extends AppCompatActivity {

    //Recuperando CPF_Paciente e Objeto Médico
    private String CPFPaciente;
    private MedicoModelo MedicoDesejado;

    //Campos Médico
    private TextView NomeMed, CRMMed, EspMed;
    private TextView EnderecoMed, CEPMed, EstadoMed, CidadeMed;

    //Confirmação do Médico
    private Button btnConfirmaMedico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceiro_confirma_med);
        //Toolbar (config)
        Toolbar toolbar = findViewById(R.id.toolbarTerceiro);
        toolbar.setTitle("CONFIRMAÇÃO DO MÉDICO");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        //Recuperando CPF_Paciente e Objeto Médico
        CPFPaciente = (String) getIntent().getSerializableExtra("cpfPaciente");
        MedicoDesejado = (MedicoModelo) getIntent().getSerializableExtra("objMedico");

        //Recuperando campos do Médico e colocando com base no objeto
        NomeMed = findViewById(R.id.txtNomeMedicoAgenda);
        CRMMed = findViewById(R.id.txtCRMMedicoAgenda);
        EspMed = findViewById(R.id.txtEspMedicoAgenda);
        EnderecoMed = findViewById(R.id.txtEnderecoMedicoAgenda);
        CEPMed = findViewById(R.id.txtCEPMedicoAgenda);
        EstadoMed = findViewById(R.id.txtEstadoMedicoAgenda);
        CidadeMed = findViewById(R.id.txtCidadeMedicoAgenda);
        //Setando com dados do objeto
        NomeMed.setText(MedicoDesejado.getNome());
        CRMMed.setText(MedicoDesejado.getCRM());
        EspMed.setText(MedicoDesejado.getEspecialidade());
        EnderecoMed.setText(MedicoDesejado.getEndereco());
        CEPMed.setText(MedicoDesejado.getCEP());
        EstadoMed.setText(MedicoDesejado.getEstado());
        CidadeMed.setText(MedicoDesejado.getCidade());

        //Confirmação do Médico
        btnConfirmaMedico = findViewById(R.id.btnConfirmaMedico);

        //Ação do Botão
        btnConfirmaMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Perguntar se deseja, de fato, escolher o Médico
                AlertDialog.Builder dialog = new AlertDialog.Builder(TerceiroConfirmaMedActivity.this);
                dialog.setTitle("Confirmação de Escolha do Médico");
                dialog.setMessage("Deseja realmente escolher esse médico?\nAtenção: não será possível mudar isso depois!");
                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Avançar para a tela de seleção da data/horário
                        Intent intent = new Intent(getApplicationContext(), QuartoDataHoraAgendarActivity.class);
                        intent.putExtra("cpfPaciente", CPFPaciente);
                        intent.putExtra("crmMedico", MedicoDesejado.getCRM());
                        intent.putExtra("especialidade", MedicoDesejado.getEspecialidade());
                        startActivity(intent);
                        finish();
                    }
                });
                dialog.setNegativeButton("Não", null);
                dialog.create();
                dialog.show();

            }
        });

    }



    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(TerceiroConfirmaMedActivity.this);
        dialog.setTitle("Retornar à Seleção de Médicos");
        dialog.setMessage("Deseja realmente retornar à seleção de medicos?");
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), SegundoListMedActivity.class);
                intent.putExtra("cpfPaciente", CPFPaciente);
                intent.putExtra("especialidade", MedicoDesejado.getEspecialidade());
                startActivity(intent);
                finish();
            }
        });
        dialog.setNegativeButton("Não", null);
        dialog.create();
        dialog.show();

        //super.onBackPressed();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
