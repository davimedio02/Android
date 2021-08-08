package com.example.listavidetarefas.RecyclerView.Model;

import java.io.Serializable; //Recuperar dados entre Activity's

public class TarefaModelo implements Serializable {

    //Identificadores do Objeto Tarefa
    private Long id;
    private String nomeTarefa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

}
