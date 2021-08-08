package com.eric.conectandosaude.BancoDeDados.Model;

import com.eric.conectandosaude.BancoDeDados.DAO.ConsultaDAO;

import java.io.Serializable;

public class ConsultaModelo implements Serializable {

    //Atributos
    private Long ID;
    private String CPF_Paciente;
    private String CRM_Medico;
    private String TipoConsulta;
    private String Data;
    private String Hora;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getCPF_Paciente() {
        return CPF_Paciente;
    }

    public void setCPF_Paciente(String CPF_Paciente) {
        this.CPF_Paciente = CPF_Paciente;
    }

    public String getCRM_Medico() {
        return CRM_Medico;
    }

    public void setCRM_Medico(String CRM_Medico) {
        this.CRM_Medico = CRM_Medico;
    }

    public String getTipoConsulta() {
        return TipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        TipoConsulta = tipoConsulta;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }


}
