package com.eric.conectandosaude.Activity.Main;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.eric.conectandosaude.Activity.Agendamento.PrimeiroEspActivity;
import com.eric.conectandosaude.Activity.MenuMain.DadosPacienteActivity;
import com.eric.conectandosaude.Activity.MenuMain.SobreAppActivity;
import com.eric.conectandosaude.BancoDeDados.DAO.ConsultaDAO;
import com.eric.conectandosaude.BancoDeDados.DAO.PacienteDAO;
import com.eric.conectandosaude.BancoDeDados.Model.ConsultaModelo;
import com.eric.conectandosaude.RecyclerView.Adapter.ConsultaAdapter;
import com.eric.conectandosaude.RecyclerView.RecyclerItemClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.eric.conectandosaude.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Toolbar (Config)
    private Toolbar toolbar;
    private String CPFPaciente;
    private String NomeCompletoPaciente;

    //RecyclerView (Config)
    private RecyclerView recyclerView;
    private ConsultaAdapter consultaAdapter;
    private List<ConsultaModelo> listaConsultas = new ArrayList<>();
    private ArrayList<String> NomeMedico = new ArrayList<>();
    private ArrayList<String> EnderecoMedico = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbarSegundo);
        //Configurando Toolbar
        CPFPaciente = (String) getIntent().getSerializableExtra("cpf");
        configuraToolbar();
        setSupportActionBar(toolbar);

        //Recuperando campos
        recyclerView = findViewById(R.id.recyclerviewProxConsultas);
        //Configurando ações no RecyclerView
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Iniciando nova Activity e mandando dados necessários
                        Intent intent = new Intent(getApplicationContext(), DetalhesConsultaActivity.class);
                        intent.putExtra("nomePaciente", NomeCompletoPaciente);
                        intent.putExtra("nomeMedico", NomeMedico.get(position));
                        intent.putExtra("endereco", EnderecoMedico.get(position));
                        intent.putExtra("objConsulta", listaConsultas.get(position));
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));

        FloatingActionButton fab = findViewById(R.id.fabAddConsulta);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Agendamentos
                Intent intent = new Intent(getApplicationContext(), PrimeiroEspActivity.class);
                intent.putExtra("cpfPaciente", CPFPaciente);
                startActivity(intent);

            }
        });

    }

    //Configuração da toolbar
    private void configuraToolbar(){
        //Setando icone (logo)
        //toolbar.setLogo(R.drawable.logo);

        //Recuperando primeiro nome do BD utilizando o CPF mandado pelo login/cadastro
        NomeCompletoPaciente = new PacienteDAO(getApplicationContext()).retornaNome(CPFPaciente);

        //Recuperando o primeiro nome (apenas)
        int iend = NomeCompletoPaciente.indexOf(" ");
        if(iend != -1){
            String PrimeiroNomePaciente = NomeCompletoPaciente.substring(0, iend);

            //Colocando no título (caso de erro, mostra o nome do app)
            toolbar.setTitle("Olá, " + PrimeiroNomePaciente);
        } else {
            toolbar.setTitle("Conectando Saúde");
        }

        toolbar.setTitleTextColor(Color.WHITE);

    }

    //Carregando a Lista de Consultas = Config do RecyclerView
    private void carregarListaConsultas(){
        //Configurando RecyclerView

        //List = Banco de Dados
        ConsultaDAO consultaDAO = new ConsultaDAO(getApplicationContext());
        listaConsultas = consultaDAO.listar(CPFPaciente);
        //Recuperando Nome e Endereço de Cada Consulta (respectivamente)
        NomeMedico = consultaDAO.retornaNomeMedico(CPFPaciente);
        EnderecoMedico = consultaDAO.retornaEnderecoMedico(CPFPaciente);

        //Adapter
        consultaAdapter = new ConsultaAdapter(listaConsultas, NomeMedico, EnderecoMedico);

        //RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(consultaAdapter);
    }

    //Configuração do Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Adicionando menu na Activity
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Recuperando ID do item do menu
        int id = item.getItemId();

        //Manipulando a opção
        Intent intent;
        switch (id){
            case R.id.dadosPaciente:
                intent = new Intent(getApplicationContext(), DadosPacienteActivity.class);
                intent.putExtra("cpf", CPFPaciente);
                startActivity(intent);
                //finish();
                break;
            case R.id.sobreApp:
                intent = new Intent(getApplicationContext(), SobreAppActivity.class);
                //intent.putExtra("cpf", CPFPaciente);
                startActivity(intent);
                //finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //Solicitando ao usuário se deseja voltar para tela de login
    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Sair do Aplicativo");
        dialog.setMessage("Deseja realmente sair do aplicativo?");
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.setNegativeButton("Não", null);
        dialog.create();
        dialog.show();
    }

    @Override
    protected void onStart() {
        //Carregando Lista de Consultas do Usuário Atual
        carregarListaConsultas();
        super.onStart();
    }
}
