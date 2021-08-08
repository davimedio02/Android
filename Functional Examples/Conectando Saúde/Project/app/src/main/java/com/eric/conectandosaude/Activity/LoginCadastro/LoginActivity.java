package com.eric.conectandosaude.Activity.LoginCadastro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.eric.conectandosaude.Activity.Main.MainActivity;
import com.eric.conectandosaude.BancoDeDados.DAO.PacienteDAO;
import com.eric.conectandosaude.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    //Estado de Registro
    private static final int SOLICITAR_REGISTRO = 0;

    //Campos: CPF e Senha
    private TextInputEditText txtCPF, txtSenha;
    //Botão: Login
    private Button btnLogin;
    //ProgressBar
    private ProgressBar progressLogin;
    //Criar Conta
    private TextView txtTelaCadastro;

    //Verificação com Banco de Dados
    private PacienteDAO verifica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        //Recuperando campos
        txtCPF = findViewById(R.id.etxtCPF);
        txtSenha = findViewById(R.id.etxtSenha);
        btnLogin = findViewById(R.id.btnLogin);
        progressLogin = findViewById(R.id.progressLogin);
        txtTelaCadastro = findViewById(R.id.txtTelaCadastro);

        //BD
        verifica = new PacienteDAO(getApplicationContext());

        //ProgressBar: desativando
        progressLogin.setVisibility(View.GONE);
        progressLogin.setEnabled(false);

        //Tratamento do botão de login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        //Tratamento de Criar Conta
        txtTelaCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Iniciando Activity
                Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
                startActivityForResult(intent, SOLICITAR_REGISTRO);
            }
        });

    }

    //Método para Logar
    private void login(){
        //Validação dos Campos do Login
        if(!validaLogin()){
            falhaLogin();
            return;
        }

        //Mostrando ProgressBar e logando..
        progressLogin.setEnabled(true);
        progressLogin.setVisibility(View.VISIBLE);


        //Acrescentando Delay no Login após sucesso com DB
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Logando pelo Banco de Dados
                //Validação no Banco de Dados
                if(!validaLoginDB()){
                    falhaLogin();
                    progressLogin.setVisibility(View.GONE);
                    progressLogin.setEnabled(false);
                    return;
                } else {
                    sucessoLogin();
                }
            }
        }, 3000); //3s de delay

    }
    private boolean validaLogin(){
        boolean valida = true;
        //Recuperando CPF e Senha
        String CPF = txtCPF.getText().toString();
        String Senha = txtSenha.getText().toString();

        //Verificando...
        //CPF
        if(CPF.isEmpty() || CPF.length() < 11){
            txtCPF.setError("Entre com um CPF válido!");
            valida = false;
        } else{
            txtCPF.setError(null);
        }

        //Senha
        if(Senha.isEmpty() || Senha.length() < 4 || Senha.length() > 10){
            txtSenha.setError("Entre 4 e 10 caracteres alfanuméricos!");
            valida = false;
        } else{
            txtSenha.setError(null);
        }

        return valida;
    }
    private boolean validaLoginDB(){

        //Verificação do CPF/Senha
        if(verifica.verificaCPFBD(txtCPF.getText().toString()) &&
                verifica.verificaSenhaBD(txtSenha.getText().toString())){
            return true;
        } else{
            return false;
        }

    }


    //Verificação de Sucesso/Falha de Login
    private void sucessoLogin(){
        //Encerrando Activity e entrando na Tela_Inicial_Consulta
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("cpf", txtCPF.getText().toString()); //Mandando dados para outra Activity
        startActivity(intent);
        finish();
    }
    private void falhaLogin(){
        Toast.makeText(getApplicationContext(), "Erro de Autenticação", Toast.LENGTH_LONG).show();
    }

    //Caso o cadastro seja sucesso -> onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SOLICITAR_REGISTRO) {
            if (resultCode == RESULT_OK) {
                //Encerrando Activity e entrando na Tela_Inicial_Consulta
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("cpf", data.getStringExtra("cpf")); //Mandando dados para outra Activity
                startActivity(intent);
                this.finish();
            }
        }
    }

    //Solicitando ao usuário se deseja sair do app
    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
        dialog.setTitle("Sair do Aplicativo");
        dialog.setMessage("Deseja realmente sair do aplicativo?");
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.setNegativeButton("Não", null);
        dialog.create();
        dialog.show();
    }
}
