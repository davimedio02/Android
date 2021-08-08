package com.example.anotacaododavizaum;

//Classe para gerenciar e salvar os dados do usuário (SharedPreferences)

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {

    //Necessário Contexto da aplicação
    private Context contexto;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String NOME_ARQUIVO = "anotacao.preferencias";
    private final String NOME_CHAVE = "anotacao";

    //Construtor passando contexto da aplicação
    public AnotacaoPreferencias(Context contexto) {
        this.contexto = contexto;
        preferences = contexto.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = preferences.edit();
    }

    //Salvar anotação
    public void salvarAnotacao(String editTexto){
        editor.putString(NOME_CHAVE, editTexto);
        editor.commit();
    }

    //Recuperar anotação
    public String recuperaAnotacao(String editTexto){
        return preferences.getString(NOME_CHAVE, "");
    }

}
