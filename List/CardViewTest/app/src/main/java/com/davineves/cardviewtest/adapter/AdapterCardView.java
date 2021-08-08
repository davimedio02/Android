package com.davineves.cardviewtest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.davineves.cardviewtest.R;
import com.davineves.cardviewtest.model.Postagem;

import java.util.List;

public class AdapterCardView extends RecyclerView.Adapter<AdapterCardView.MyViewHolder> {

    private List<Postagem> postagem;
    public AdapterCardView(List<Postagem> listaPostagem) {
        this.postagem = listaPostagem;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Convertendo XML para um objeto do tipo View e passando a visualização por item
        View itemCardView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_cardview, parent, false);

        return new MyViewHolder(itemCardView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Postagem postagens = postagem.get(position);
        holder.textNome.setText(postagens.getNome());
        holder.textHoraPostagem.setText(postagens.getHora_postagem());
        holder.textPostagem.setText(postagens.getDescricao());
        holder.imagePostagem.setImageResource(postagens.getImagem());

    }

    @Override
    public int getItemCount() {
        return postagem.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        //Atributos
        private TextView textNome;
        private TextView textHoraPostagem;
        private ImageView imagePostagem;
        private TextView textPostagem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textNome = itemView.findViewById(R.id.textNome);
            textHoraPostagem = itemView.findViewById(R.id.textHoraPostagem);
            imagePostagem = itemView.findViewById(R.id.imagePostagem);
            textPostagem = itemView.findViewById(R.id.textDescricao);
        }

    }

}
