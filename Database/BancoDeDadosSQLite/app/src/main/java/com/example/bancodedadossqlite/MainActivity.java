package com.example.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final String NOME_BANCO_DADOS = "teste";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            //Criando Banco de Dados
            SQLiteDatabase bancoDados = openOrCreateDatabase(NOME_BANCO_DADOS, MODE_PRIVATE, null);

            //Criando Tabela (SOMENTE SE EXISTE)
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(50) NOT NULL, idade INT(3) NOT NULL);");

            //Inserindo alguns campos (estático)
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Davizaum', 20)");
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Luish', 30)");
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Mario', 22)");

            //Atualizando e removendo dados/tabela
            //bancoDados.execSQL("UPDATE pessoas SET idade = 80 WHERE nome = 'Luish'"); //Atualizando
            //bancoDados.execSQL("DELETE FROM pessoas WHERE nome = 'Teste1'");
            //bancoDados.execSQL("DROP TABLE pessoas");

            //Recuperando dados (rawQuery) = como se fosse array (necessário Cursor para percorrer dados)
            String consulta = "SELECT * FROM pessoas";
            String consultaFiltrada = "SELECT * FROM pessoas " +
                    "WHERE nome = 'Davizaum' OR idade >= '30'";
            String consultaFiltrada2 = "SELECT * FROM pessoas " +
                    "WHERE nome IN('Davizaum', 'Plus Detonator')";  //IN = Dentro de um conjunto de dados
            String consultaFiltrada3 = "SELECT * FROM pessoas " +
                    "WHERE idade BETWEEN 20 AND 30";                //BETWEEN = Entre um intervalo
            String consultaFiltrada4 = "SELECT * FROM pessoas " +
                    "WHERE nome LIKE '%u%'";                        //LIKE = Como
            String consultaFiltrada5 = "SELECT * FROM pessoas " +
                    "WHERE idade >= 20 ORDER BY idade DESC LIMIT 1";//ORDER BY = Ordenação (ASC -> menor/maior; DESC -> maior/menor) -> LIMIT = limite para mostrar após ordenação

            Cursor cursor = bancoDados.rawQuery(consulta, null);

            //Recuperando índices da tabela
            int indiceID = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst(); //Voltando os dados para início após recuperar índices

            //Mostrando dados
            while(cursor != null){
                String id = cursor.getString(indiceID);
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);

                Log.i("RESULTADO -> ID",id + " | Nome: " + nome + " | Idade: " + idade);

                //Andando a linha
                cursor.moveToNext();
            }


        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
