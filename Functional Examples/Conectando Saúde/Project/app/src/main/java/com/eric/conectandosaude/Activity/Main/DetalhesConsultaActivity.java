package com.eric.conectandosaude.Activity.Main;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eric.conectandosaude.BancoDeDados.DAO.ConsultaDAO;
import com.eric.conectandosaude.BancoDeDados.Model.ConsultaModelo;
import com.eric.conectandosaude.R;

public class DetalhesConsultaActivity extends AppCompatActivity{

    //Dados da MainActivity
    private String NomeCompleto_Paciente, NomeMedico, EnderecoMedico;
    private ConsultaModelo objConsulta;

    //Layout
    private TextView txtDataDetalhes, txtHorarioDetalhes;
    private TextView txtEndDetalhes, txtTipoConsultaDetalhes;
    private TextView txtNomePaciente, txtNomeMedico;

    //Deletar Consulta
    private Button btnDeletaConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_consulta);
        Toolbar toolbar = findViewById(R.id.toolbarDetalhes);
        toolbar.setTitle("Detalhes do Agendamento");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        //Recuperando dados da MainActivity
        NomeCompleto_Paciente = (String) getIntent().getSerializableExtra("nomePaciente");
        NomeMedico = (String) getIntent().getSerializableExtra("nomeMedico");
        EnderecoMedico = (String) getIntent().getSerializableExtra("endereco");
        objConsulta = (ConsultaModelo) getIntent().getSerializableExtra("objConsulta");

        //Recuperando campos layout
        txtDataDetalhes = findViewById(R.id.txtDataDetalhes);
        txtHorarioDetalhes = findViewById(R.id.txtHoraDetalhes);
        txtEndDetalhes = findViewById(R.id.txtEnderecoDetalhes);
        txtTipoConsultaDetalhes = findViewById(R.id.txtTipoConsultaDetalhes);
        txtNomePaciente = findViewById(R.id.txtNomePacienteDetalhes);
        txtNomeMedico = findViewById(R.id.txtNomeMedicoDetalhes);

        //Setando com valores
        txtDataDetalhes.setText(objConsulta.getData());
        txtHorarioDetalhes.setText(objConsulta.getHora());
        txtEndDetalhes.setText(EnderecoMedico);
        txtTipoConsultaDetalhes.setText(objConsulta.getTipoConsulta());
        txtNomePaciente.setText(NomeCompleto_Paciente);
        txtNomeMedico.setText(NomeMedico);

        //Configurando botão
        btnDeletaConsulta = findViewById(R.id.btnCancelaConsulta);
        btnDeletaConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(DetalhesConsultaActivity.this);
                dialog.setTitle("Desmarcar Consulta");
                dialog.setMessage("Deseja realmente cancelar a consulta?");
                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Deletar com base na ID da Consulta, mostrar msg, e encerrar a Activity
                        ConsultaDAO consultaDAO = new ConsultaDAO(getApplicationContext());
                        if(consultaDAO.deletar(objConsulta.getID())){
                            //Mostrando sucesso
                            AlertDialog.Builder dialog2 = new AlertDialog.Builder(DetalhesConsultaActivity.this);
                            dialog2.setTitle("SUCESSO!");
                            dialog2.setMessage("Consulta cancelada com sucesso!");
                            dialog2.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                            dialog2.create();
                            dialog2.show();
                        } else{
                            //Mostrando falha
                            AlertDialog.Builder dialog2 = new AlertDialog.Builder(DetalhesConsultaActivity.this);
                            dialog2.setTitle("FALHA");
                            dialog2.setMessage("Erro interno. Não foi possível cancelar a Consulta. Tente novamente.");
                            dialog2.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                            dialog2.create();
                            dialog2.show();
                        }
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
        finish();
        //super.onBackPressed();
    }
}
