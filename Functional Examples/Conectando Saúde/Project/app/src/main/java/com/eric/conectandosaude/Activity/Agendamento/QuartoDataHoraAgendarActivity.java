package com.eric.conectandosaude.Activity.Agendamento;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eric.conectandosaude.BancoDeDados.DAO.ConsultaDAO;
import com.eric.conectandosaude.BancoDeDados.Model.ConsultaModelo;
import com.eric.conectandosaude.BancoDeDados.Model.HorarioModelo;
import com.eric.conectandosaude.R;
import com.eric.conectandosaude.RecyclerView.Adapter.HorarioAdapter;
import com.eric.conectandosaude.RecyclerView.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class QuartoDataHoraAgendarActivity extends AppCompatActivity {

    //RecyclerView (config)
    private RecyclerView recyclerView;
    private HorarioAdapter horarioAdapter;
    private List<HorarioModelo> listaHorario = new ArrayList<>();

    //Recuperar CPF_Paciente; CRM_Medico e sua Especialidade
    private String CPF_Paciente;
    private String CRM_Medico, Especialidade_Medico;

    //Data (Calendário)
    private Button btnEscolheData;
    private TextView txtDataFinal;
    private Integer dia, mes, ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarto_data_hora_agendar);
        //Toolbar (config)
        Toolbar toolbar = findViewById(R.id.toolbarQuarto);
        toolbar.setTitle("DATA E HORÁRIO");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        //Recuperar CPF_Paciente; CRM_Medico e sua Especialidade
        CPF_Paciente = (String) getIntent().getSerializableExtra("cpfPaciente");
        CRM_Medico = (String) getIntent().getSerializableExtra("crmMedico");
        Especialidade_Medico = (String) getIntent().getSerializableExtra("especialidade");

        //Calendário
        btnEscolheData = findViewById(R.id.btnEscolheData);
        txtDataFinal = findViewById(R.id.txtDataFinal);
        //Ação do Botão: escolher Data
        btnEscolheData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Selecionando a Data
                final Calendar c = Calendar.getInstance();
                dia = c.get(Calendar.DAY_OF_MONTH);
                mes = c.get(Calendar.MONTH);
                ano = c.get(Calendar.YEAR);

                //Criando PickerDialog de Data
                DatePickerDialog datePickerDialog = new DatePickerDialog(QuartoDataHoraAgendarActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                dia = dayOfMonth;
                                mes = month + 1;
                                ano = year;

                                txtDataFinal.setText(dia.toString() + "/" + mes.toString() + "/" + ano.toString());
                                recyclerView.setVisibility(View.VISIBLE);
                                carregaListaHorario();
                            }
                        }, ano, mes, dia);
                c.add(Calendar.DATE, 1);
                datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
                datePickerDialog.show();
            }
        });

        //Gerando Lista de Horários
        geraHorarios();

        //RecyclerView: recuperando campos e ClickListener
        recyclerView = findViewById(R.id.recyclerviewHorario);
        recyclerView.setVisibility(View.GONE);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // Verificar e Adicionar no BD
                        ConsultaDAO consultaDAO = new ConsultaDAO(getApplicationContext());
                        String data = txtDataFinal.getText().toString();
                        String horario = listaHorario.get(position).getHora() + ":" + listaHorario.get(position).getMinuto();

                        if(consultaDAO.DataHoraDisponiveis(CRM_Medico, data, horario)){
                            //Se não obtiver conflito, adicionar
                            ConsultaModelo consulta = new ConsultaModelo();
                            //Setando campos
                            consulta.setCPF_Paciente(CPF_Paciente);
                            consulta.setCRM_Medico(CRM_Medico);
                            consulta.setTipoConsulta(Especialidade_Medico);
                            consulta.setData(data);
                            consulta.setHora(horario);

                            //Adicionando no BD
                            if(consultaDAO.salvar(consulta)){
                                //Mostrando sucesso
                                AlertDialog.Builder dialog = new AlertDialog.Builder(QuartoDataHoraAgendarActivity.this);
                                dialog.setTitle("SUCESSO!");
                                dialog.setMessage("Consulta agendada com sucesso!");
                                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                });
                                dialog.create();
                                dialog.show();
                            } else{
                                //Mostrando falha
                                AlertDialog.Builder dialog = new AlertDialog.Builder(QuartoDataHoraAgendarActivity.this);
                                dialog.setTitle("FALHA");
                                dialog.setMessage("Erro interno. Não foi possível agendar a nova Consulta. Tente novamente.");
                                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                });
                                dialog.create();
                                dialog.show();
                            }

                        } else {
                            //Mostrando falha
                            AlertDialog.Builder dialog = new AlertDialog.Builder(QuartoDataHoraAgendarActivity.this);
                            dialog.setTitle("FALHA");
                            dialog.setMessage("Não foi possível agendar a nova Consulta. Tente novamente com outra Data/Horário.");
                            dialog.setPositiveButton("Ok", null);
                            dialog.create();
                            dialog.show();
                        }
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

    private void carregaListaHorario(){
        //Config RecyclerView
        //Adapter
        horarioAdapter = new HorarioAdapter(listaHorario);

        //RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(horarioAdapter);
    }

    private void geraHorarios(){
        //Objeto do Horário
        HorarioModelo horario;

        //Gerando: 08:00 até 18:00 (intervalos de 30min)
        for(Integer h0 = 0; h0 <= 1; h0++)
        {
            for (Integer h1 = 0; h1 <= 9; h1++)
            {
                //08 até 09
                if(h0 == 0 && h1 == 0){
                    h1 = 8;
                }
                if(h0 == 1 && h1 == 9) {
                    break;
                }
                //Minutos
                for(Integer m0 = 0; m0 <= 3; m0 += 3)
                {
                    if(h0 == 1 && h1 == 8 && m0 == 3){
                        break;
                    }
                    horario = new HorarioModelo();
                    horario.setHora(h0.toString() + h1.toString());
                    horario.setMinuto(m0.toString() + "0");
                    listaHorario.add(horario);
                }
            }
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(QuartoDataHoraAgendarActivity.this);
        dialog.setTitle("Sair do Novo Agendamento");
        dialog.setMessage("Deseja realmente cancelar o Novo Agendamento?");
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.setNegativeButton("Não", null);
        dialog.create();
        dialog.show();

        //super.onBackPressed();
    }

}
