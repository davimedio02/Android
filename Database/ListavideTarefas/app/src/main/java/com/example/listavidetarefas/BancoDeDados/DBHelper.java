package com.example.listavidetarefas.BancoDeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    //public static int OLD_VERSION = 0; //Versão antiga do app
    public static int CURRENT_VERSION = 1; //Versão atual do app
    public static String NOME_DB = "DB_TAREFAS"; //Nome Banco de Dados
    public static String TABELA_TAREFA = "tarefa";

    public DBHelper(@Nullable Context context) {
        super(context, NOME_DB, null, CURRENT_VERSION);
    }

    //Criação do Banco de Dados (chamado uma vez durante a instalação)
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Criação da Tabela
        String sqlTable = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFA +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "  nome TEXT NOT NULL); ";
        db.execSQL(sqlTable);

    }
    //Atualização do Banco de Dados (versões novas)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        
    }
}
