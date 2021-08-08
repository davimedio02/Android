package com.davineves.fragments_test.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.davineves.fragments_test.R;
import com.davineves.fragments_test.fragment.ContatosFragment;
import com.davineves.fragments_test.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button btnConversa, btnContato;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Remover sombra da ActionBar
        getSupportActionBar().setElevation(0);

        //Instanciando um fragmento
            //conversasFragment = new ConversasFragment();
            //contatosFragment = new ContatosFragment();


        //Configurando o objeto para o Fragmento
            //FragmentTransaction transaction = getSupportFragmentManager().beginTransaction(); //Começa as config de fragmentos
            //transaction.add(R.id.frameConteudo, conversasFragment); //Definir os Fragmentos
            //transaction.add(R.id.frameConteudo, contatosFragment);
            //transaction.commit(); //Finalizar a transição


        btnConversa = findViewById(R.id.btnConversa);
        btnContato = findViewById(R.id.btnContatos);

        btnConversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                conversasFragment = new ConversasFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, conversasFragment);
                transaction.commit();
            }
        });

        btnContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contatosFragment = new ContatosFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, contatosFragment);
                transaction.commit();
            }
        });

    }
}
