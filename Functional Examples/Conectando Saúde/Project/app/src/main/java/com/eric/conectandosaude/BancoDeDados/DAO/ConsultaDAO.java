package com.eric.conectandosaude.BancoDeDados.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.eric.conectandosaude.BancoDeDados.DBHelper;
import com.eric.conectandosaude.BancoDeDados.Interface.IConsultaDAO;
import com.eric.conectandosaude.BancoDeDados.Model.ConsultaModelo;
import com.eric.conectandosaude.BancoDeDados.Model.MedicoModelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO implements IConsultaDAO {

    //Escrita/Leitura BD
    private SQLiteDatabase escrita, leitura;

    public ConsultaDAO(Context context) {
        DBHelper db = new DBHelper(context);
        this.escrita = db.getWritableDatabase();
        this.leitura = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(ConsultaModelo consulta) {
        //Valores
        ContentValues valores = new ContentValues();
        valores.put("cpf_paciente", consulta.getCPF_Paciente());
        valores.put("crm_medico", consulta.getCRM_Medico());
        valores.put("tipo", consulta.getTipoConsulta());
        valores.put("data", consulta.getData());
        valores.put("hora", consulta.getHora());

        try{
            escrita.insert(DBHelper.TABELA_CONSULTA, null, valores);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean deletar(Long ID) {
        try{
            String[] whereargs = {ID.toString()};
            escrita.delete(DBHelper.TABELA_CONSULTA, "id = ?", whereargs);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public List<ConsultaModelo> listar(String CPF_Paciente) {
        //Recuperando Consultas do BD
        List<ConsultaModelo> consultas = new ArrayList<>();
        String sql = "SELECT * FROM " + DBHelper.TABELA_CONSULTA +
                " WHERE " + "cpf_paciente = '" + CPF_Paciente + "'" +
                "ORDER BY id ASC;";

        Cursor cursor = leitura.rawQuery(sql, null);

        //Salvando na Lista
        while(cursor.moveToNext()){
            //Criando objeto "ConsultaModelo"
            ConsultaModelo consulta = new ConsultaModelo();
            //Recuperando campos
            consulta.setID(cursor.getLong(cursor.getColumnIndex("id")));
            consulta.setCPF_Paciente(cursor.getString(cursor.getColumnIndex("cpf_paciente")));
            consulta.setCRM_Medico(cursor.getString(cursor.getColumnIndex("crm_medico")));
            consulta.setTipoConsulta(cursor.getString(cursor.getColumnIndex("tipo")));
            consulta.setData(cursor.getString(cursor.getColumnIndex("data")));
            consulta.setHora(cursor.getString(cursor.getColumnIndex("hora")));

            //Adicionando na lista
            consultas.add(consulta);
        }

        return consultas;
    }

    //Funções de Verificação: Nome e Endereço do Médico (mostrar Consulta)
    //Analisando pelo CRM (Chave Estrangeira)
    public ArrayList<String> retornaNomeMedico(String CPF){
        ArrayList<String> NomeCompleto = new ArrayList<>();

        //Recuperando do BD
        String sql = "SELECT " + DBHelper.TABELA_CONSULTA + ".cpf_paciente, " + DBHelper.TABELA_CONSULTA + ".crm_medico, " + DBHelper.TABELA_PACIENTE + ".cpf, " + DBHelper.TABELA_MEDICOS + ".crm, " + DBHelper.TABELA_MEDICOS + ".nome" +
                " FROM " +
                DBHelper.TABELA_CONSULTA + ", " + DBHelper.TABELA_MEDICOS + ", " + DBHelper.TABELA_PACIENTE +
                " WHERE " + DBHelper.TABELA_CONSULTA + ".cpf_paciente = " + DBHelper.TABELA_PACIENTE + ".cpf AND " + DBHelper.TABELA_CONSULTA + ".crm_medico = " + DBHelper.TABELA_MEDICOS + ".crm";

        Cursor cursor = leitura.rawQuery(sql, null);
        while (cursor.moveToNext()){
            String nome = cursor.getString(cursor.getColumnIndex(DBHelper.TABELA_MEDICOS + ".nome"));
            NomeCompleto.add(nome);
        }

        return NomeCompleto;
    }
    public ArrayList<String> retornaEnderecoMedico(String CPF){
        ArrayList<String> Endereco = new ArrayList<>();

        String sql = "SELECT " + DBHelper.TABELA_CONSULTA + ".cpf_paciente, " + DBHelper.TABELA_CONSULTA + ".crm_medico, " + DBHelper.TABELA_PACIENTE + ".cpf, " +
                DBHelper.TABELA_MEDICOS + ".crm, " + DBHelper.TABELA_MEDICOS + ".endereco, " + DBHelper.TABELA_MEDICOS + ".cep, " + DBHelper.TABELA_MEDICOS + ".estado, " + DBHelper.TABELA_MEDICOS + ".cidade" +
                " FROM " +
                DBHelper.TABELA_CONSULTA + ", " + DBHelper.TABELA_MEDICOS + ", " + DBHelper.TABELA_PACIENTE +
                " WHERE " + DBHelper.TABELA_CONSULTA + ".cpf_paciente = " + DBHelper.TABELA_PACIENTE + ".cpf AND " + DBHelper.TABELA_CONSULTA + ".crm_medico = " + DBHelper.TABELA_MEDICOS + ".crm";


        Cursor cursor = leitura.rawQuery(sql, null);
        while(cursor.moveToNext()){
            String estado = cursor.getString(cursor.getColumnIndex(DBHelper.TABELA_MEDICOS + ".estado"));
            String cidade = cursor.getString(cursor.getColumnIndex(DBHelper.TABELA_MEDICOS + ".cidade"));
            String endereco = cursor.getString(cursor.getColumnIndex(DBHelper.TABELA_MEDICOS + ".endereco"));
            String cep = cursor.getString(cursor.getColumnIndex(DBHelper.TABELA_MEDICOS + ".cep"));

            Endereco.add(endereco + "\nCEP: " + cep + "\n" + cidade + " - " + estado);
        }

        return Endereco;
    }

    //Verificação de Data e Horário disponíveis com CRM do Médico
    public boolean DataHoraDisponiveis(String CRM, String Data, String Hora){

        String sql = "SELECT " + DBHelper.TABELA_CONSULTA + ".crm_medico, " + DBHelper.TABELA_CONSULTA + ".data, " + DBHelper.TABELA_CONSULTA + ".hora, " + DBHelper.TABELA_MEDICOS + ".crm" +
                " FROM " + DBHelper.TABELA_CONSULTA + ", " + DBHelper.TABELA_MEDICOS +
                " WHERE " + DBHelper.TABELA_CONSULTA + ".crm_medico = " + DBHelper.TABELA_MEDICOS + ".crm" +
                " AND " + DBHelper.TABELA_CONSULTA + ".data = '" + Data + "'" +
                " AND " + DBHelper.TABELA_CONSULTA + ".hora = '" + Hora + "';";

        Cursor cursor = leitura.rawQuery(sql, null);
        if(cursor.getCount() > 0)
        {
            return false;
        }
        return true;
    }

}