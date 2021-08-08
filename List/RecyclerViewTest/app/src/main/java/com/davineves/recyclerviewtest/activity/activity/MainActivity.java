package com.davineves.recyclerviewtest.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.davineves.recyclerviewtest.R;
import com.davineves.recyclerviewtest.activity.RecyclerItemClickListener;
import com.davineves.recyclerviewtest.activity.adapter.AdapterFilmes;
import com.davineves.recyclerviewtest.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //RecyclerView é a listagem de itens recomendada pela Google

    private RecyclerView recyclerFilmes;
    private List<Filme> listaFilmes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerFilmes = findViewById(R.id.recyclerFilmes);

        //Listagem de Itens
        this.criarFilmes();

        //Configurar o Adapter (Adaptador das Informações para o Layout)
        AdapterFilmes adapterFilmes = new AdapterFilmes(listaFilmes);

        //Configurar o RecyclerView
        RecyclerView.LayoutManager layoutRecycler = new LinearLayoutManager(getApplicationContext());
        recyclerFilmes.setLayoutManager(layoutRecycler);
        recyclerFilmes.setHasFixedSize(true); //Otimizar o RecyclerView com tamanho fixo
        recyclerFilmes.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL)); //Criar divisor na vertical
        recyclerFilmes.setAdapter(adapterFilmes);

        //Bônus: Evento de Clique (Longo e Curto) - recomendado pela Google (uso da classe de ClickListener)
        recyclerFilmes.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerFilmes,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        filme.getTituloFilme() + " foi selecionado!",
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(
                                        getApplicationContext(),
                                        filme.getTituloFilme() + ": clique longo!",
                                        Toast.LENGTH_LONG
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

    }

    public void criarFilmes(){

        /*Filme filme = new Filme("Título", "Gênero", "Ano");
        this.listaFilmes.add(filme); //Adiciona no Array*/

        Filme filme = new Filme("Homem Aranha - De Volta ao Lar", "Aventura", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Mulher Maravilha", "Fantasia", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça", "Ficção", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Capitão América - Guerra Civil", "Aventura/Ficção", "2016");
        listaFilmes.add(filme);

        filme = new Filme("It: A Coisa", "Drama/Terror", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Pica-Pau: O Filme", "Comédia/Animação", "2017");
        listaFilmes.add(filme);

        filme = new Filme("A Múmia", "Terror", "2017");
        listaFilmes.add(filme);

        filme = new Filme("A Bela e a Fera", "Romance", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Meu Malvado Favorito 3", "Comédia", "2017");
        listaFilmes.add(filme);

        filme = new Filme("Carros 3", "Comédia", "2017");
        listaFilmes.add(filme);
    }
}
