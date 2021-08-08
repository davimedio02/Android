package com.eric.conectandosaude.RecyclerView.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eric.conectandosaude.BancoDeDados.Model.MedicoModelo;
import com.eric.conectandosaude.R;

import java.util.List;

public class MedicoAdapter extends RecyclerView.Adapter<MedicoAdapter.MyViewHolder> {

    //Lista de Médicos vinda da outra classe
    private List<MedicoModelo> listaMedicos;

    //Construtor: receber a lista de médicos
    public MedicoAdapter(List<MedicoModelo> listaConsultas) {
        this.listaMedicos = listaConsultas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Retornando layout_base
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_medicos_adapter, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Recuperando dados e colocando no modelo layout_base
        MedicoModelo medico = listaMedicos.get(position);
        holder.labelNome.setText("Nome");
        holder.Nome.setText(medico.getNome());
        holder.labelEstado.setText("Estado");
        holder.Estado.setText(medico.getEstado());
        holder.labelCidade.setText("Cidade");
        holder.Cidade.setText(medico.getCidade());
        holder.labelEndereco.setText("Endereço");
        holder.Endereco.setText(medico.getEndereco());
        holder.labelCEP.setText("CEP");
        holder.CEP.setText(medico.getCEP());
    }

    @Override
    public int getItemCount() {
        return this.listaMedicos.size();
    }


    //Criando a MyViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder {

        //Recuperando campos do layout_base
        TextView labelNome, Nome;
        TextView labelEstado, Estado;
        TextView labelCidade, Cidade;
        TextView labelEndereco, Endereco;
        TextView labelCEP, CEP;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //Recuperando campos do layout_base
            labelNome = itemView.findViewById(R.id.txtlabelNome);
            Nome = itemView.findViewById(R.id.txtNomeMedicoCard);
            labelEstado = itemView.findViewById(R.id.txtEstadoMD);
            Estado = itemView.findViewById(R.id.txtEstado);
            labelCidade = itemView.findViewById(R.id.txtlabelCidade);
            Cidade = itemView.findViewById(R.id.txtCidade);
            labelEndereco = itemView.findViewById(R.id.txtlabelEndereco);
            Endereco = itemView.findViewById(R.id.txtEndereco);
            labelCEP = itemView.findViewById(R.id.txtlabelCEP);
            CEP = itemView.findViewById(R.id.txtCEP);
        }
    }
}
