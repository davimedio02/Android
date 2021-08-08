package com.eric.conectandosaude.BancoDeDados.Model;

import java.io.Serializable;

public class PacienteModelo implements Serializable {

    //Atributos
    private String CPF;
    private String Nome;
    private String Telefone;
    private String Estado;
    private String Cidade;
    private String SenhaApp;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getSenhaApp() {
        return SenhaApp;
    }

    public void setSenhaApp(String senhaApp) {
        SenhaApp = senhaApp;
    }
}
