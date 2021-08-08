package com.example.listavidetarefas.RecyclerView.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listavidetarefas.RecyclerView.Model.TarefaModelo;
import com.example.listavidetarefas.R;

import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MyViewHolder> {

    //Lista de Tarefas vinda da outra classe
    private List<TarefaModelo> listaTarefas;

    //Construtor: receber lista de tarefas
    public TarefaAdapter(List<TarefaModelo> list) {
        this.listaTarefas = list; //Para utilizar nessa classe (modo seguro)
    }

    //Métodos
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Retornar item de lista (layout_base)

        View itemLista = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.lista_tarefa_adapter, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Recuperando dados e colocando no modelo layout_base
        TarefaModelo tarefa = listaTarefas.get(position);
        holder.nomeTarefa.setText(tarefa.getNomeTarefa());
    }

    @Override
    public int getItemCount() {
        //Quantos itens serão exibidos no RecyclerView
        return this.listaTarefas.size();
    }

    //Criando ViewHolder
    public class MyViewHolder extends  RecyclerView.ViewHolder{

        //Recuperando texto
        TextView nomeTarefa;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //Recuperando dados do layout_base
            nomeTarefa = itemView.findViewById(R.id.txtNomeTarefa);
        }
    }
}
