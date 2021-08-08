package com.davineves.recyclerviewtest.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.davineves.recyclerviewtest.R;
import com.davineves.recyclerviewtest.activity.model.Filme;

import java.util.List;

//ViewHolder (classe que guarda as informações para a lista em objetos)
//A limitação na Main serve para otimizar a listagem com relação ao carregamento (ex - de 10 em 10 itens exibidos) - "Reciclagem"

public class AdapterFilmes extends RecyclerView.Adapter<AdapterFilmes.MyViewHolder> {

    //Passando a Lista de Itens
    private List<Filme> lista;
    public AdapterFilmes(List<Filme> listaFilmes) {
        this.lista = listaFilmes;
    }


    @NonNull
    @Override //Criação do Objeto View com o Layout (XML)
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Converter o XML do adapter_filmes para um objeto do tipo View
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_filmes, parent, false);

        //Passa o Layout de visualização pro ViewHolder configurar com os valores
        return new MyViewHolder(itemLista);
    }

    @Override //Exibição dos Itens
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Filme filme = lista.get(position);

        holder.titulo.setText(filme.getTituloFilme());
        holder.ano.setText(filme.getAnoFilme());
        holder.genero.setText(filme.getGeneroFilme());
    }

    @Override //Quantidade de Itens Exibidos
    public int getItemCount() {
        return lista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        //Atributos
        private TextView titulo, ano, genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);

        }
    }
}
