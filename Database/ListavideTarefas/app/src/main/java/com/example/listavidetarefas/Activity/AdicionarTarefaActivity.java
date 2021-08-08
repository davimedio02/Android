package com.example.listavidetarefas.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.listavidetarefas.BancoDeDados.TarefaDAO;
import com.example.listavidetarefas.RecyclerView.Model.TarefaModelo;
import com.example.listavidetarefas.R;
import com.google.android.material.textfield.TextInputEditText;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa;
    private TarefaModelo tarefaEdicao; //EDIÇÃO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        //Recuperando campo da tarefa
        editTarefa = findViewById(R.id.editAdicionaTarefa);

        //Recuperando objeto tarefa (EDIÇÃO)
        tarefaEdicao = (TarefaModelo) getIntent().getSerializableExtra("tarefaSelecionada");
        if(tarefaEdicao != null){
            editTarefa.setText(tarefaEdicao.getNomeTarefa());
        }
    }

    //Configurando Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Adicionando menu na Activity
        getMenuInflater().inflate(R.menu.menu_adicionartarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Recuperando ID do item do menu
        int id = item.getItemId();

        //Manipulando a opção
        switch (id){
            case R.id.salvarTarefa:
                //Salvar/Atualizar no banco de dados
                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
                String nomeTarefa;
                TarefaModelo tarefa;

                //Edição
                if(tarefaEdicao != null){
                    //Recuperando campo digitado pelo usuário
                    nomeTarefa = editTarefa.getText().toString();
                    if(!nomeTarefa.isEmpty()){
                        //Criando novo objeto do tipo "TarefaModelo"
                        tarefa = new TarefaModelo();
                        tarefa.setId(tarefaEdicao.getId());
                        tarefa.setNomeTarefa(nomeTarefa);

                        //Atualizando no Banco de Dados
                        if(tarefaDAO.atualizar(tarefa)){
                            Toast.makeText(getApplicationContext(), "Tarefa atualizada com sucesso!", Toast.LENGTH_SHORT).show();
                            //Fechar Activity
                            finish();
                        } else{
                            Toast.makeText(getApplicationContext(), "Erro ao atualizar tarefa. Tente novamente", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Tarefa não pode ser vazia!", Toast.LENGTH_SHORT).show();
                    }
                } else{ //Salvar
                    //Recuperando campo digitado pelo usuário
                    nomeTarefa = editTarefa.getText().toString();
                    if(!nomeTarefa.isEmpty()){
                        //Criando objeto do tipo "TarefaModelo"
                        tarefa = new TarefaModelo();
                        tarefa.setNomeTarefa(nomeTarefa);
                        //Salvando nome tarefa
                        if(tarefaDAO.salvar(tarefa)){
                            Toast.makeText(getApplicationContext(), "Tarefa salva com sucesso!", Toast.LENGTH_SHORT).show();
                            //Fechar Activity
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Erro ao salvar tarefa. Tente novamente", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Tarefa não pode ser vazia!", Toast.LENGTH_SHORT).show();
                    }

                }
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
