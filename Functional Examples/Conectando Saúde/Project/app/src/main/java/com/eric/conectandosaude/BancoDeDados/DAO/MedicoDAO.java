package com.eric.conectandosaude.BancoDeDados.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.eric.conectandosaude.BancoDeDados.DBHelper;
import com.eric.conectandosaude.BancoDeDados.Interface.IMedicoDAO;
import com.eric.conectandosaude.BancoDeDados.Model.MedicoModelo;

import java.util.ArrayList;
import java.util.List;

public class MedicoDAO implements IMedicoDAO {

    //Escrever e Ler o BD
    private SQLiteDatabase leitura;

    //Acesso ao DBHelper
    public MedicoDAO(Context context) {
        DBHelper db = new DBHelper(context);
        this.leitura = db.getReadableDatabase();
    }


    /*
    @Override
    public List<MedicoModelo> listar(String CRM) {
        //Recuperando do BD
        List<MedicoModelo> medicos = new ArrayList<>();
        String sql = "SELECT * FROM " + DBHelper.TABELA_MEDICOS + ";";
        Cursor cursor = leitura.rawQuery(sql, null);

        //Salvando na lista
        while(cursor.moveToNext()){
            //Criando objeto do tipo MédicoModelo
            MedicoModelo medico = new MedicoModelo();

            //Recuperando campos e salvando na lista
            medico.setCRM(cursor.getString(cursor.getColumnIndex("crm")));
            medico.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            medico.setEspecialidade(cursor.getString(cursor.getColumnIndex("especialidade")));
            medico.setEstado(cursor.getString(cursor.getColumnIndex("estado")));
            medico.setCidade(cursor.getString(cursor.getColumnIndex("cidade")));
            medico.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            medico.setCEP(cursor.getString(cursor.getColumnIndex("cep")));

            //Salvando na lista
            medicos.add(medico);
        }

        return medicos;
    }*/

    @Override
    public List<MedicoModelo> listarEspecialidade(String Especialidade) {
        //Recuperando do BD
        List<MedicoModelo> medicos = new ArrayList<>();
        String sql = "SELECT * FROM " + DBHelper.TABELA_MEDICOS +
                " WHERE especialidade = '" + Especialidade + "';";
        Cursor cursor = leitura.rawQuery(sql, null);

        //Salvando na lista
        while(cursor.moveToNext()){
            //Criando objeto do tipo MédicoModelo
            MedicoModelo medico = new MedicoModelo();

            //Recuperando campos e salvando na lista
            medico.setCRM(cursor.getString(cursor.getColumnIndex("crm")));
            medico.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            medico.setEspecialidade(cursor.getString(cursor.getColumnIndex("especialidade")));
            medico.setEstado(cursor.getString(cursor.getColumnIndex("estado")));
            medico.setCidade(cursor.getString(cursor.getColumnIndex("cidade")));
            medico.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            medico.setCEP(cursor.getString(cursor.getColumnIndex("cep")));

            //Salvando na lista
            medicos.add(medico);
        }

        return medicos;
    }


}
