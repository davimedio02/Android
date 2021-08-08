package com.example.preferenciasdousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    //Componentes
    private Button btnSalvar;
    private TextInputEditText inputNome;
    private TextView txtResultado;
    private static final String ARQUIVO_PREFERENCIA = "PreferenciasUsuario"; //String com o nome_arquvio de preferências

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperando campos
        btnSalvar = findViewById(R.id.btnSalvar);
        inputNome = findViewById(R.id.inputNome);
        txtResultado = findViewById(R.id.txtResultado);

        //Setando o Click do Botão
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Salvar nas preferências do Usuário = SharedPreferences (XML criado para pequenos dados)
                    //Não é Banco de Dados, mas um XML com poucas informações e config. do usuário
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0); //Modo 0: privado (só esse app pode ler e salvar esse arquivo)
                SharedPreferences.Editor editorPreferencias = preferences.edit();

                //Validação do Nome
                if(inputNome.getText().toString().isEmpty() == false) {
                    //Salvando os dados
                    String nome = inputNome.getText().toString();
                    editorPreferencias.putString("nome", nome); //Criação de Chave no XML
                    editorPreferencias.commit(); //Salva o XML (Dados)

                } else {
                    Toast.makeText(getApplicationContext(), "Preencha o Nome!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Recuperando dados salvos (*não precisa repetir)
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);

        //Valida se existe o campo "nome" no arquivo XML (Validação)
        if(preferences.contains("nome")){
            //Recuperando chave
            String nome = preferences.getString("nome", "usuário não definido");
            txtResultado.setText("Olá, " + nome + "!");
        } else {
            txtResultado.setText("Olá, usuário não definido!");
        }

    }
}
