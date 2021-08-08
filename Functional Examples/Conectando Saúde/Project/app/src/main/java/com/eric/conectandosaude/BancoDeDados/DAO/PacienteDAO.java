package com.eric.conectandosaude.BancoDeDados.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.eric.conectandosaude.BancoDeDados.DBHelper;
import com.eric.conectandosaude.BancoDeDados.Interface.IPacienteDAO;
import com.eric.conectandosaude.BancoDeDados.Model.PacienteModelo;

public class PacienteDAO implements IPacienteDAO {

    //Escrita/Leitura BD
    private SQLiteDatabase escrita, leitura;

    public PacienteDAO(Context context) {
        DBHelper db = new DBHelper(context);
        this.escrita = db.getWritableDatabase();
        this.leitura = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(PacienteModelo paciente) {
        //Recuperando Campos para Cadastro
        ContentValues values = new ContentValues();
        values.put("nome", paciente.getNome());
        values.put("cpf", paciente.getCPF());
        values.put("estado", paciente.getEstado());
        values.put("cidade", paciente.getCidade());
        values.put("telefone", paciente.getTelefone());
        values.put("senha", paciente.getSenhaApp());

        //Salvando no Banco de Dados
        try{
            escrita.insert(DBHelper.TABELA_PACIENTE, null, values);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;

    }

    @Override
    public PacienteModelo listar(String CPF) {
        //Recuperando dados
        PacienteModelo paciente = new PacienteModelo();
        String sql = "SELECT * FROM " + DBHelper.TABELA_PACIENTE +
                " WHERE cpf = '" + CPF + "';";
        Cursor cursor = leitura.rawQuery(sql, null);

        //Salvando no paciente
        if(cursor.moveToNext()){
            paciente.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            paciente.setCPF(cursor.getString(cursor.getColumnIndex("cpf")));
            paciente.setEstado(cursor.getString(cursor.getColumnIndex("estado")));
            paciente.setCidade(cursor.getString(cursor.getColumnIndex("cidade")));
            paciente.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
        }

        return paciente;
    }

    public boolean verificaCPFBD(String CPF) {
        try{
            String sql = "SELECT cpf FROM " + DBHelper.TABELA_PACIENTE +
                    " WHERE cpf = '" + CPF + "';";
            Cursor cursor = leitura.rawQuery(sql, null);
            if(cursor.getCount() > 0){
                return true;
            }
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean verificaSenhaBD(String Senha) {
        try{
            String sql = "SELECT senha FROM " + DBHelper.TABELA_PACIENTE +
                    " WHERE senha = '" + Senha + "';";
            Cursor cursor = leitura.rawQuery(sql, null);
            if(cursor.getCount() > 0){
                return true;
            }
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    //Retornando Nome na MainActivity
    public String retornaNome(String CPF) {
        String Nome = "";
        try{
            String sql = "SELECT cpf, nome FROM " + DBHelper.TABELA_PACIENTE +
                    " WHERE cpf = '" + CPF + "';";
            Cursor cursor = leitura.rawQuery(sql, null);
            if(cursor.moveToNext()){
                Nome = cursor.getString(cursor.getColumnIndex("nome"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        return Nome;

    }

}
