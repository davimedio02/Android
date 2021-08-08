package com.eric.conectandosaude.RecyclerView.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eric.conectandosaude.BancoDeDados.Model.HorarioModelo;
import com.eric.conectandosaude.R;

import java.util.List;

public class HorarioAdapter extends RecyclerView.Adapter<HorarioAdapter.MyViewHolder> {

    //Lista contendo Intervalo de Horários
    private List<HorarioModelo> listaHorario;

    public HorarioAdapter(List<HorarioModelo> listaHorario) {
        this.listaHorario = listaHorario;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflando Layout
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_horario_adapter, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Setando campos com item
        HorarioModelo horario = listaHorario.get(position);
        holder.horario.setText(horario.getHora() + ":" + horario.getMinuto());
    }

    @Override
    public int getItemCount() {
        return this.listaHorario.size();
    }

    //Criando ViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder{

        //Campos Layout_base
        TextView horario;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //Recuperando Layout_base
            horario = itemView.findViewById(R.id.txtHorario);
        }
    }
}
