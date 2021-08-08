package com.eric.conectandosaude.BancoDeDados.Model;

import java.io.Serializable;

public class HorarioModelo implements Serializable {

    //Atributos
    private String Hora;
    private String Minuto;

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public String getMinuto() {
        return Minuto;
    }

    public void setMinuto(String minuto) {
        Minuto = minuto;
    }
}
