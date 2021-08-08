package com.example.listavidetarefas.BancoDeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.listavidetarefas.RecyclerView.Model.TarefaModelo;

import java.util.ArrayList;
import java.util.List;

//Recomendado pela Google: Data Access Object (Salvar dados)
public class TarefaDAO implements ITarefaDAO{

    //Escrever e Ler o Banco de Dados
    private SQLiteDatabase escrever;
    private SQLiteDatabase leitura;

    //Acessar o DBHelper.class (Construtor)
    public TarefaDAO(Context context) {
        DBHelper db = new DBHelper(context);
        this.escrever = db.getWritableDatabase();
        this.leitura = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(TarefaModelo tarefa) {
        //Valores
        ContentValues valores = new ContentValues();
        valores.put("nome", tarefa.getNomeTarefa());

        try{
            escrever.insert(DBHelper.TABELA_TAREFA, null, valores);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(TarefaModelo tarefa) {
        //Valores
        ContentValues valores = new ContentValues();
        valores.put("nome", tarefa.getNomeTarefa());

        try{
            String[] whereargs = {tarefa.getId().toString()};
            escrever.update(DBHelper.TABELA_TAREFA, valores, "id = ?", whereargs);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean deletar(TarefaModelo tarefa) {
        try{
            String[] whereargs = {tarefa.getId().toString()};
            escrever.delete(DBHelper.TABELA_TAREFA, "id = ?", whereargs);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public List<TarefaModelo> listar() {

        //Recuperando tarefas do DB
        List<TarefaModelo> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM " + DBHelper.TABELA_TAREFA + " ;";
        Cursor cursor = leitura.rawQuery(sql, null);

        //Salvando na lista
        while(cursor.moveToNext()){
            //Criando objeto "TarefaModelo"
            TarefaModelo tarefa = new TarefaModelo();
            //Recuperando campos
            Long id = cursor.getLong(cursor.getColumnIndex("id"));
            String nomeTarefa = cursor.getString(cursor.getColumnIndex("nome"));
            //Salvando no objeto
            tarefa.setId(id);
            tarefa.setNomeTarefa(nomeTarefa);

            //Salvando na lista
            tarefas.add(tarefa);
        }

        return tarefas;
    }
}
