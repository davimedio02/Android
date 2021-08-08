package com.davineves.poodroidpractice;

class Funcionario {

    //Propriedades
    String nome;
    double salario;

    //Métodos

    /*void recuperaSalario(){ //Método sem retorno = void

        this.salario = this.salario - (this.salario * 0.1);
        System.out.println(this.salario); //this faz referência a variáveis dentro da própria classe
    }*/

    double recuperaSalario(double bonus){ //Método com retorno

        this.salario -= (this.salario * 0.1);
        return this.salario + bonus;
    }
}
