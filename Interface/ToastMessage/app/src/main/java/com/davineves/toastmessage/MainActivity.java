package com.davineves.toastmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirToast(View view){

        //Criação do Toast (por meio da classe Toast)

        //poderia usar o 'this' para o contexto (neste caso, o MainActivity)
        //Toast.makeText(getApplicationContext(), "Davizaum é o nome dele", Toast.LENGTH_LONG).show();


        //Toast Customizado

        /*ImageView imagem = new ImageView(getApplicationContext());
        imagem.setImageResource(R.drawable.ic_launcher_background);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(imagem);
        toast.show();*/
    }
}
