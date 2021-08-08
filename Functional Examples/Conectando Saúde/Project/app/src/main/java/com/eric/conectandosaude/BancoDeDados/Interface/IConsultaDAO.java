package com.eric.conectandosaude.BancoDeDados.Interface;

import com.eric.conectandosaude.BancoDeDados.Model.ConsultaModelo;

import java.util.List;

public interface IConsultaDAO {

    public boolean salvar(ConsultaModelo consulta);
    public boolean deletar(Long ID);
    public List<ConsultaModelo> listar(String CPF_Paciente);
}
