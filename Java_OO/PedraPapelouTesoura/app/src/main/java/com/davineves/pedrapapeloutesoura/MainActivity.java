package com.davineves.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    TextView textoUser;
    public void resetaCorUser(){
        textoUser = findViewById(R.id.pedra_txt);
        textoUser.setTextColor(0XFA070001);
        textoUser = findViewById(R.id.papel_txt);
        textoUser.setTextColor(0XFA070001);
        textoUser = findViewById(R.id.tesoura_txt);
        textoUser.setTextColor(0XFA070001);
    }
    public void selecionarPedra(View view){
        resetaCorUser();
        textoUser = findViewById(R.id.pedra_txt);
        this.opcaoSelecionada("Pedra");
    }
    public void selecionarPapel(View view){
        resetaCorUser();
        textoUser = findViewById(R.id.papel_txt);
        this.opcaoSelecionada("Papel");
    }
    public void selecionarTesoura(View view){
        resetaCorUser();
        textoUser = findViewById(R.id.tesoura_txt);
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoUser){

        textoUser.setTextColor(0XFA2944B8);

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        ImageView imagemApp = findViewById(R.id.ia_img); //Casting (TextView) antes do findViewById

        //Gerar opção aleatória para o App
        int gera_num = new Random().nextInt(3);
        String opcaoApp = opcoes[gera_num];

        //Colocando a imagem do App no aplicativo
        switch(opcaoApp){

            case "Pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }

        //Comparações para o resultado final
        resultadoFinal(opcaoUser, opcaoApp);

    }

    public void resultadoFinal(String opcaoUser, String opcaoApp){

        TextView textoResultado = findViewById(R.id.resultado_txt);

        if(     (opcaoApp == "Pedra" && opcaoUser == "Tesoura") ||
                (opcaoApp == "Papel" && opcaoUser == "Pedra") ||
                (opcaoApp == "Tesoura" && opcaoUser == "Papel")
          ){ //App ganhador

            textoResultado.setText("Você perdeu :(");
            textoResultado.setTextColor(0XFAB91125);
        }else if(   (opcaoUser == "Pedra" && opcaoApp == "Tesoura") ||
                    (opcaoUser == "Papel" && opcaoApp == "Pedra") ||
                    (opcaoUser == "Tesoura" && opcaoApp == "Papel")
                ){ //User ganhador

            textoResultado.setText("Você ganhou :)");
            textoResultado.setTextColor(0XFA2944B8);
        }else{ //Empate
            textoResultado.setText("Empate.");
            textoResultado.setTextColor(0XFA070001);
        }

        textoResultado.setVisibility(View.VISIBLE);
    }



}
