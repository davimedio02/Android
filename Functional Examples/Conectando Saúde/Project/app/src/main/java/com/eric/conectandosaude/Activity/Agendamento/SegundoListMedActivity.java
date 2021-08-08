package com.eric.conectandosaude.Activity.Agendamento;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.eric.conectandosaude.BancoDeDados.DAO.MedicoDAO;
import com.eric.conectandosaude.BancoDeDados.Model.MedicoModelo;
import com.eric.conectandosaude.RecyclerView.Adapter.MedicoAdapter;
import com.eric.conectandosaude.RecyclerView.RecyclerItemClickListener;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.eric.conectandosaude.R;

import java.util.ArrayList;
import java.util.List;

public class SegundoListMedActivity extends AppCompatActivity {

    //Toolbar (config)
    private String tituloToolbar;

    //Recuperando especialidade e CPF
    private String CPFPaciente, EspecialidadeMed;

    //RecyclerView Especi. (config)
    private RecyclerView recyclerView;
    private MedicoAdapter medicoAdapter;
    private List<MedicoModelo> listaMedico = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_list_med);
        Toolbar toolbar = findViewById(R.id.toolbarSegundo);
        tituloToolbar = (String) getIntent().getSerializableExtra("especialidade");
        toolbar.setTitle(tituloToolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        //Recuperando dados
        CPFPaciente = (String) getIntent().getSerializableExtra("cpfPaciente");
        EspecialidadeMed = (String) getIntent().getSerializableExtra("especialidade");

        //Recuperando campos
        recyclerView = findViewById(R.id.recyclerViewListaEsp);
        //Config ações
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //Ir para Datas/Horários disponíveis
                        Intent intent =  new Intent(getApplicationContext(), TerceiroConfirmaMedActivity.class);
                        //Mandando dados para agendamento...
                        intent.putExtra("cpfPaciente", CPFPaciente);
                        intent.putExtra("objMedico", listaMedico.get(position));
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));
    }

    private void carregaListaMedico(){
        //Configurando RecyclerView

        //List (Médicos) = BD
        MedicoDAO medicoDAO = new MedicoDAO(getApplicationContext());
        listaMedico = medicoDAO.listarEspecialidade(EspecialidadeMed);

        //Adapter
        medicoAdapter = new MedicoAdapter(listaMedico);

        //RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(medicoAdapter);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(SegundoListMedActivity.this);
        dialog.setTitle("Retornar à Seleção de Especialidades");
        dialog.setMessage("Deseja realmente retornar à seleção de especialidades?");
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), PrimeiroEspActivity.class);
                intent.putExtra("cpfPaciente", CPFPaciente);
                startActivity(intent);
                finish();
            }
        });
        dialog.setNegativeButton("Não", null);
        dialog.create();
        dialog.show();

        //super.onBackPressed();
    }

    @Override
    protected void onStart() {
        carregaListaMedico();
        super.onStart();
    }
}
