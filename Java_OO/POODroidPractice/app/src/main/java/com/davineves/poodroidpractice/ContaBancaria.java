package com.davineves.poodroidpractice;

public class ContaBancaria {

    private int numeroConta;
    private double saldo;

    //Construtor: mesmo nome da classe (método do tipo ContaBancaria)
    public ContaBancaria(){
        System.out.println("Construtor chamado");
    }

    //Sobrecarga de Construtores
    public ContaBancaria(int numConta){
        this.numeroConta = numConta;
        System.out.println("Sobrecarga de Construtor: " + this.numeroConta);
    }


}
