package com.example.listavidetarefas.BancoDeDados;

import com.example.listavidetarefas.RecyclerView.Model.TarefaModelo;

import java.util.List;

//Criação dos métodos
public interface ITarefaDAO {

    public boolean salvar(TarefaModelo tarefa);
    public boolean atualizar(TarefaModelo tarefa);
    public boolean deletar(TarefaModelo tarefa);
    public List<TarefaModelo> listar();

}
