package com.davineves.cardviewtest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.davineves.cardviewtest.R;
import com.davineves.cardviewtest.adapter.AdapterCardView;
import com.davineves.cardviewtest.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //Definir Layout

        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPostagem.setLayoutManager(layoutManager);

        //Definir Adapter
        this.carregarPostagens();

        AdapterCardView adapterCardView = new AdapterCardView(postagens);
        recyclerPostagem.setHasFixedSize(true);
        recyclerPostagem.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerPostagem.setAdapter(adapterCardView);
    }

    public void carregarPostagens(){

        Postagem p = new Postagem("Davi Augusto", "Agora há pouco","Pinto de Ouro XD", R.drawable.imagem1);
        this.postagens.add(p);

        p = new Postagem("Fumantes Cancerígenos", "04:20", "Smoke Weed Averidey :P", R.drawable.imagem2);
        this.postagens.add(p);

        p = new Postagem("Viajante Aleatório", "12:24","#ParisCorno", R.drawable.imagem3);
        this.postagens.add(p);

        p = new Postagem("Marido da Mulher da Foto", "Antes de Se Foder","Que foto cagada!", R.drawable.imagem4);
        this.postagens.add(p);
    }
}
