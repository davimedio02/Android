package com.davineves.atmconsultoria.ui.sobre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.davineves.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sobre);

        String descricao = "A ATM Consultoria tem como missão apoiar as organizações que " +
                "desejam alcançar o sucesso através da excelência em " +
                "gestão e da busca pela qualidade!\n\n" +
                "Nosso trabalho é dar suporte às empresas que desejam se certificar em " +
                "padrões de qualidade ou investimento de desenvolvimento e evolução de sua gestão, por" +
                "meio da otimização dos processos e da disseminação dos Fundamentos e Critérios de Excelência.";

        //Utilizando a biblioteca do GitHub
        View sobre = new AboutPage(this)
                .setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Fale Conosco")
                .addEmail("admconsultoria@gmail.com", "Envie um e-mail")
                .addWebsite("http://google.com.br", "Acesse nosso site")
                .addGroup("Acesse nossas Redes Sociais!")
                .addFacebook("Teste", "Facebook")
                .addTwitter("Teste", "Twitter")
                .addInstagram("Teste", "Instagram")
                .addYoutube("Teste", "Youtube")
                .addPlayStore("com.davineves.applixo", "PlayStore")
                .addGitHub("Teste", "GitHub")
                .create();

        setContentView(sobre);
    }
}
