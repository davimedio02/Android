package com.davineves.poodroidpractice.classes;

class Cao extends Animal { //'extends' puxa a superclasse para a subclasse

    void latir(){
        System.out.println("Latir = Cão");
    }

    //Sobrescrita de método (específico)
    void dormir(){
        super.dormir();
        System.out.println("Cão");
    }
    void correr(){
        super.correr(); //puxa o método da superclasse (classe pai)
        System.out.println("Cão");
    }

}
