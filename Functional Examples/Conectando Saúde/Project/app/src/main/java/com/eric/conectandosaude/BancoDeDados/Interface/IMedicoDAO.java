package com.eric.conectandosaude.BancoDeDados.Interface;

import com.eric.conectandosaude.BancoDeDados.Model.*;

import java.util.List;

public interface IMedicoDAO {

    //public List<MedicoModelo> listar(String CRM);
    public List<MedicoModelo> listarEspecialidade(String Especialidade);
}
