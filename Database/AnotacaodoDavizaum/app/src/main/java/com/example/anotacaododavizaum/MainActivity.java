package com.example.anotacaododavizaum;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias preferencias;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperando componente do Editor de Texto
        editAnotacao = findViewById(R.id.editCaixaTexto);

        //Recuperando contexto e passando para a classe AnotacaoPreferencias
        preferencias = new AnotacaoPreferencias(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Validando campo de texto
                String recuperaTexto = editAnotacao.getText().toString();
                if(!recuperaTexto.isEmpty()) {
                    preferencias.salvarAnotacao(recuperaTexto);
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(view, "Preencha alguma anotação!", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        //Recuperando texto das anotações
        String recuperaAnotacao = preferencias.recuperaAnotacao("");
        if(recuperaAnotacao.isEmpty() == false){
            editAnotacao.setText(recuperaAnotacao);
            Toast.makeText(this, "Anotação recuperada com sucesso!", Toast.LENGTH_SHORT).show();
        }
    }

}
