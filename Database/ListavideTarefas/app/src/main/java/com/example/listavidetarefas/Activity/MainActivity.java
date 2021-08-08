package com.example.listavidetarefas.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.listavidetarefas.RecyclerView.Adapter.TarefaAdapter;
import com.example.listavidetarefas.BancoDeDados.TarefaDAO;
import com.example.listavidetarefas.RecyclerView.Model.TarefaModelo;
import com.example.listavidetarefas.RecyclerView.RecyclerItemClickListener;
import com.example.listavidetarefas.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //RecyclerView config
    private RecyclerView recyclerView;
    private TarefaAdapter tarefaAdapter;
    private List<TarefaModelo> listaTarefas = new ArrayList<>(); //Objetos Tarefas
    private TarefaModelo tarefaSelecionada; //Editar e Excluir

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Configurando RecyclerView
        recyclerView = findViewById(R.id.recyclerListaTarefas);

        /*
        ---EXEMPLO---

        //Criação do Banco de Dados (DBHelper)
        DBHelper db = new DBHelper(getApplicationContext());
        //Salvando valores
        ContentValues tarefas = new ContentValues();
        tarefas.put("nome", "Valor_Campo");
        //Salvando no banco de dados
        db.getWritableDatabase().insert("tarefa",
                null,
                tarefas); //Escrever no banco de dados
        //db.getReadableDatabase(); //Ler o banco de dados

        ---FIM EXEMPLO---
        */

        //Adicionando evento de clique
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {

                    //Edição do objeto
                    @Override
                    public void onItemClick(View view, int position) {
                        //Recuperando tarefa
                        tarefaSelecionada = listaTarefas.get(position);

                        //Enviando tarefa para outra Activity
                        Intent intent = new Intent(MainActivity.this, AdicionarTarefaActivity.class);
                        intent.putExtra("tarefaSelecionada", tarefaSelecionada);

                        //Iniciando Activity
                        startActivity(intent);
                    }

                    //Deletar o objeto
                    @Override
                    public void onLongItemClick(View view, int position) {
                        //Recuperando tarefa
                        tarefaSelecionada = listaTarefas.get(position);

                        //Perguntando se quer realmente excluir
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        //Configurando título e mensagem do AlertDialog
                        dialog.setTitle("Confirmar Exclusão");
                        dialog.setMessage("Deseja excluir a tarefa: " + tarefaSelecionada.getNomeTarefa() + " ?");
                        //Configurando botões
                        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Excluindo tarefa
                                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
                                if(tarefaDAO.deletar(tarefaSelecionada)){
                                    carregarListaTarefas(); //Recarregar a lista de tarefas
                                    Toast.makeText(getApplicationContext(), "Tarefa deletada com sucesso!", Toast.LENGTH_SHORT).show();
                                } else{
                                    Toast.makeText(getApplicationContext(), "Erro ao deletar tarefa. Tente novamente.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        dialog.setNegativeButton("Não", null);

                        //Criando e Exibindo Dialog
                        dialog.create();
                        dialog.show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Abrindo nova Activity
                Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
                startActivity(intent);
            }
        });
    }

    //Configurando RecyclerView = montando a lista de tarefas
    public void carregarListaTarefas(){

        //Configurando lista tarefas (banco de dados)
        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
        listaTarefas = tarefaDAO.listar();

        //Exibindo lista de tarefas no RecyclerView: Adapter e LayoutManager
        //Configurando Adapter
        tarefaAdapter = new TarefaAdapter(listaTarefas);

        //Configurando RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(tarefaAdapter);

    }

    //Ciclo vida Activity
    @Override
    protected void onStart() {
        carregarListaTarefas();
        super.onStart();
    }

}
