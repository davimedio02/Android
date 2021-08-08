package com.eric.conectandosaude.RecyclerView.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eric.conectandosaude.BancoDeDados.Model.ConsultaModelo;
import com.eric.conectandosaude.R;

import java.util.ArrayList;
import java.util.List;

public class ConsultaAdapter extends RecyclerView.Adapter<ConsultaAdapter.MyViewHolder> {

    //Lista de Consultas vinda da outra classe
    private List<ConsultaModelo> listaConsultas;

    //CRM do Médico
    private ArrayList<String> NomeMedico, EnderecoMedico;

    //Construtor: receber a lista de consultas
    public ConsultaAdapter(List<ConsultaModelo> listaConsultas, ArrayList<String> NomeMedico, ArrayList<String> EnderecoMedico) {
        this.listaConsultas = listaConsultas;
        this.NomeMedico = NomeMedico;
        this.EnderecoMedico = EnderecoMedico;
    }

    @NonNull
    @Override
    public ConsultaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Retornando item da lista (layout_base)
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.proximas_consultas_adapter, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsultaAdapter.MyViewHolder holder, int position) {
        //Recuperando dados e colocando no modelo layout_base
        ConsultaModelo consulta = listaConsultas.get(position);
        holder.especialização.setText(consulta.getTipoConsulta());
        holder.datahora.setText(consulta.getData() + " - " + consulta.getHora());
        holder.atendidopor.setText("Atendimento por: ");
        holder.nomeMedico.setText(NomeMedico.get(position));
        holder.endereco.setText(EnderecoMedico.get(position));
        holder.status.setText("AGENDADO");
        holder.aviso.setText("Aviso: cancele se não puder comparecer!");
        holder.detalhes.setText("Aperte para mais detalhes!");

        holder.detalhes.setEnabled(false); //Por enquanto nada
    }

    @Override
    public int getItemCount() {
        //Quantos itens serão exibidos no RecyclerView
        return this.listaConsultas.size();
    }


    //Criando ViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder {

        //Recuperando campos
        TextView especialização, datahora, atendidopor, nomeMedico;
        TextView endereco, status, aviso, detalhes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //Recuperando dados do layout_base
            especialização = itemView.findViewById(R.id.txtEspecial);
            datahora = itemView.findViewById(R.id.txtDataHora);
            atendidopor = itemView.findViewById(R.id.txtMedico);
            nomeMedico = itemView.findViewById(R.id.txtNomeMedicoCard);
            endereco = itemView.findViewById(R.id.txtEndereco);
            status = itemView.findViewById(R.id.txtEstadoMD);
            aviso = itemView.findViewById(R.id.txtAviso);
            detalhes = itemView.findViewById(R.id.txtDetalhes);
        }
    }
}
