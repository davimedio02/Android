package com.davineves.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listLocais; //Variável do tipo ListView que vai abrigar todo componente de layout mostrado no xml
    private String[] itens ={ //Exemplo de itens (usar Banco de Dados)
      "Argentina", "Brasil", "Costa Rica", "China", "Chile",
            "Cuba", "Inglaterra", "Rússia", "Sudão", "Tailândia", "Zâmbia"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperando o componente do tipo ListView
        listLocais = findViewById(R.id.listLocais);

        //Criar um adaptador para a lista (adaptar a String para ListView)
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(), //Contexto da Aplicação (o "this" também é válido)
                android.R.layout.simple_list_item_1, //Tipo de Layout da ListView
                android.R.id.text1, //Lugar do Layout para Exibir Itens
                itens //Variável com os itens (ArrayList serve para Banco de Dados...)
        );

        //Adicionar adaptador para a lista
        listLocais.setAdapter(adaptador);

        //Selecionando e Recuperando o Click (para aparecer a mensagem embaixo, mas aqui pode ficar abrir outra janela...)
        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //String valorSelecionado = listLocais.getItemAtPosition(position).toString();
                //Toast.makeText(getApplicationContext(), valorSelecionado, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), listLocais.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
