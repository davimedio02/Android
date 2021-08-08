package com.davineves.cardviewtest.model;

public class Postagem {

    private String nome;
    private String hora_postagem;
    private String descricao;
    private int imagem;

    public Postagem(){}

    public Postagem(String nome, String hora_postagem, String descricao, int imagem) {
        this.nome = nome;
        this.hora_postagem = hora_postagem;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHora_postagem() {
        return hora_postagem;
    }

    public void setHora_postagem(String hora_postagem) {
        this.hora_postagem = hora_postagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
