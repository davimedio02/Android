package com.davineves.alertdialogmessageconfirmation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirAlerta(View view){

        //Criação do AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this); //contexto da própria classe MainActivity

        //Configurações do título e mensagem
        dialog.setTitle("Título do Alerta");
        dialog.setMessage("Mensagem do Alerta");

        //Bloquear a saída/cancelamento do AlertDialog (false - não sai)
        dialog.setCancelable(false);

        //Configurando ícone
        dialog.setIcon(android.R.drawable.ic_delete);

        //Configurações das ações
            //'new' em Interface é criado uma classe anônima por trás que implementa a interface (não instancia)
        dialog.setPositiveButton("Concordo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Concordo apertado!", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("Discordo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Discordo apertado!", Toast.LENGTH_SHORT).show();
            }
        });

        //Criar e Exibir o AlertDialog
        dialog.create();
        dialog.show();
        
    }

}
