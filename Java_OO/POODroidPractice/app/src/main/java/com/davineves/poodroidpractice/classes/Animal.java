package com.davineves.poodroidpractice.classes;

public class Animal {

    protected int tamanho; //Herança: uso do protected
    protected double peso;
    protected String cor;

    //Getter e Setter (métodos para validações)
    //(recuperar valor e configurar valor de propriedades)

    //1° Forma: definir um método para void setVar(tipo_var) e outro para tipo_var getVar
    void setCor(String cor){
        //Formatação ou Validação Aqui
        this.cor = cor;
    }
    String getCor(){
        return this.cor;
    }

    //2° Forma: selecionar automáticamente pelo ALT+INSERT
    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }



    void dormir(){
        System.out.print("Dormir = ");
    }
    void correr(){
        System.out.print("Correr = ");
    }

}
