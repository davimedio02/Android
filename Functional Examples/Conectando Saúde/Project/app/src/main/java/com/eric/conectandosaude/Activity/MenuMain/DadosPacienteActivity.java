package com.eric.conectandosaude.Activity.MenuMain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.eric.conectandosaude.BancoDeDados.DAO.PacienteDAO;
import com.eric.conectandosaude.BancoDeDados.Model.PacienteModelo;
import com.eric.conectandosaude.R;

public class DadosPacienteActivity extends AppCompatActivity {

    //Layout
    private TextView Nome, CPF, Estado, Cidade, Telefone;

    //CPF Paciente
    private String CPFPaciente;
    //Verificação com Banco de Dados
    private PacienteDAO dadosPacienteBD;
    //Dados
    private PacienteModelo dadosPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_paciente);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        toolbar.setTitle("Meus Dados");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        //Recuperando layout
        Nome = findViewById(R.id.txtNomeMedicoCard);
        CPF = findViewById(R.id.txtCPF);
        Estado = findViewById(R.id.txtEstado);
        Cidade = findViewById(R.id.txtCidade);
        Telefone = findViewById(R.id.txtTelefone);

        //Recuperando CPF do Paciente
        CPFPaciente = (String) getIntent().getSerializableExtra("cpf");
        //Recuperando todos os dados do Paciente
        dadosPacienteBD = new PacienteDAO(getApplicationContext());
        dadosPaciente = new PacienteModelo();
        dadosPaciente = dadosPacienteBD.listar(CPFPaciente);

        //Colocando os dados no texto
        Nome.setText(dadosPaciente.getNome());
        CPF.setText(dadosPaciente.getCPF());
        Estado.setText(dadosPaciente.getEstado());
        Cidade.setText(dadosPaciente.getCidade());
        Telefone.setText(dadosPaciente.getTelefone());
    }

    @Override
    public void onBackPressed() {
        //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        //intent.putExtra("cpf", CPFPaciente);
        //startActivity(intent);
        finish();
    }
}
