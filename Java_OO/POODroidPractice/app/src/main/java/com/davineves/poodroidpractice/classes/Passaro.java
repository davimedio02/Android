package com.davineves.poodroidpractice.classes;

class Passaro extends Animal{

    void voar(){
        System.out.println("Voar = Pássaro");
    }

    //Sobrescrita de método (específico)
    void dormir(){
        super.dormir();
        System.out.println("Pássaro");
    }
    void correr(){
        super.correr(); //puxa o método da superclasse (classe pai)
        System.out.println("Pássaro");
    }
}
