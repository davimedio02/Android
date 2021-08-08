package com.davineves.poodroidpractice;

public class Conta {

    protected int num_conta;
    private double saldo = 100; //Propriedades com private e utilizar métodos públicos para manipulação e verificação

    public int getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(int num_conta) {
        this.num_conta = num_conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }



    public void depositar(double valorDeposito){
        if(valorDeposito > 0)
            this.saldo += valorDeposito;
        else
            System.out.println("Depósito incorreto. BURRO!");
    }
    public void sacar(double valorSaque){
        this.saldo -= valorSaque;
    }

}
