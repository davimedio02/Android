package com.davineves.poodroidpractice;

public class Pessoa {

    private String nome;
    private int idade;

    //Sobrecarga de métodos: métodos com mesmo nome, porém com parâmetros diferentes
    public void exibirDados(String nome){
       System.out.println("Nome: " + nome);
    }

    public void exibirDados(int idade){
        System.out.println("Idade: " + idade);
    }
}
