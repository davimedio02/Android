package com.davineves.poodroidpractice;

import androidx.appcompat.app.AppCompatActivity;
import com.davineves.poodroidpractice.classes.Animal;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState); //'super' vem de superclasse
            setContentView(R.layout.activity_main);

            //Instanciar a Classe (em um Objeto)

            /*Casa minhaCasa = new Casa();
            minhaCasa.cor = "Azul";
            System.out.println(minhaCasa.cor);
            minhaCasa.abrirPorta();

            Funcionario corno = new Funcionario();
            corno.nome = "Davi";
            corno.salario = 150.00;
            double bonus = 1000.00;
            double salarioRecuperado = corno.recuperaSalario(bonus);
            System.out.println("Nome do Corno: " + corno.nome);
            System.out.println("R$" + salarioRecuperado);*/


            //Herança (uso do extends nas subclasses)

            /*Cao cao = new Cao();
            cao.latir();

            Passaro passaro = new Passaro();
            passaro.voar();*/

            //Uso do Getter e Setter (métodos seguros e para validação)
            /*cao.setCor("Preto");
            System.out.println(cao.getCor());*/
            //RECOMENDAÇÃO: utilizar o setVar e getVar para manipulação de propriedades das classes


            //Sobrescrita de método = utilizar 'super.' nas subclasses
            /*cao.dormir();
            passaro.dormir();
            cao.correr();
            passaro.correr();*/


            /*Modificadores de Acesso (Classes):
            //
            // 1) public = todas as classes terão acesso
            // 2) private = apenas pode ser acessado dentro da classe
            // 3) protected = pode ser acessado estando dentro do mesmo PACOTE e/ou subclasses
            // 4) default = sem modificador, acesso dentro do pacote
            // * abstract (não utilizado no curso)

            Utilizados para definir o que é visível ou não (p/usuário) no projeto
             */

            /*Conta conta = new Conta();
            conta.setSaldo(2500);
            conta.depositar(100);
            System.out.println("Saldo: " + conta.getSaldo());
            conta.sacar(1000);
            System.out.println("Saldo novo: " + conta.getSaldo());*/


            //Sobrecarga de Métodos (Classe: Pessoa)
                //Utilizar o mesmo nome de um método, mas com parâmetros diferentes

            /*Pessoa pessoa = new Pessoa();
            pessoa.exibirDados("Cornovi");
            pessoa.exibirDados(19);*/


            //Métodos Construtores (Constructs) (Classe: Conta Bancária)
                //Utilizado para configurações no objeto antes da manipulação (chamar métodos/mudar propriedades)

            //ContaBancaria contabancaria = new ContaBancaria(12890);


            /*Interface
            * A grosso modo: interface é um contrato que,
            * quando assumido por uma classe, deve ser implementado.
            *
            * Interface é utilizada quando há muitas objetos (classes)
            * que podem possuir a mesma ação (métodos), porém podem ser executá-das
            * de maneiras DIFERENTES*/
            //Classes: Cornovi e Obama (classes filhos) - Cidadao (classe pai)
            //Interface: Presidente

            //Uso do comando implements na classe (semelhante ao extends)

            Obama obama = new Obama();
            obama.ganharEleicao();
            Cornovi cornovi = new Cornovi();
            cornovi.ganharEleicao();


    }


}
