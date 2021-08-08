package com.davineves.recyclerviewtest.activity.model;

//Classe de modelo com informações dos objetos

public class Filme {

    private String tituloFilme;
    private String generoFilme;
    private String anoFilme;

    //Uma utilizando o Getter/Setter
    public Filme(){

    }

    //E/ou utilizando construtor
    public Filme(String tituloFilme, String generoFilme, String anoFilme) {
        this.tituloFilme = tituloFilme;
        this.generoFilme = generoFilme;
        this.anoFilme = anoFilme;
    }


    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public String getGeneroFilme() {
        return generoFilme;
    }

    public void setGeneroFilme(String generoFilme) {
        this.generoFilme = generoFilme;
    }

    public String getAnoFilme() {
        return anoFilme;
    }

    public void setAnoFilme(String anoFilme) {
        this.anoFilme = anoFilme;
    }
}
