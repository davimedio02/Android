package com.davineves.poodroidpractice;

//Uso do comando implements para implementar a Interface
//Então, implementar o método com Override

public class Obama extends Cidadao implements Presidente{

    @Override
    public void ganharEleicao() {
        System.out.println("Ganhou a eleição dos EUA!");
    }
}
