package com.example.menutest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Criação dos Menus
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Configurando os Menus
            //Inflar = converter XML para View
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Tramento de Evento de Clique dos Menus
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //Recuperando itens
        switch (item.getItemId()){
            case R.id.itemSalvar:
                Toast.makeText(MainActivity.this, "Item Salvar Funcionando!", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
