package com.eric.conectandosaude.BancoDeDados.Interface;

import com.eric.conectandosaude.BancoDeDados.Model.PacienteModelo;

public interface IPacienteDAO {

    public boolean salvar(PacienteModelo paciente);
    public PacienteModelo listar(String CPF);

}
