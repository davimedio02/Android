package com.eric.conectandosaude.Activity.LoginCadastro;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.eric.conectandosaude.BancoDeDados.DAO.PacienteDAO;
import com.eric.conectandosaude.R;
import com.eric.conectandosaude.BancoDeDados.Model.PacienteModelo;
import com.google.android.material.textfield.TextInputEditText;

import java.util.InputMismatchException;

public class CadastroActivity extends AppCompatActivity {

    //Campos
    private TextInputEditText etxtNome, etxtSobrenome, etxtCPF, etxtEstado;
    private TextInputEditText etxtCidade, etxtTelefone, etxtSenha;
    //Botão
    private Button btnCadastrar;
    //ProgressBar
    private ProgressBar progressCadastro;
    //TextView = Login
    private TextView txtTelaLogin;

    //Verificação de CPF
    private PacienteDAO pacienteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        setTitle("Cadastro");


        //Recuperando campos
        etxtNome = findViewById(R.id.etxtNome);
        etxtSobrenome = findViewById(R.id.etxtSobrenome);
        etxtCPF = findViewById(R.id.etxtCPF);
        etxtEstado = findViewById(R.id.etxtEstado);
        etxtCidade = findViewById(R.id.etxtCidade);
        etxtTelefone = findViewById(R.id.etxtTelefone);
        etxtSenha = findViewById(R.id.etxtSenha);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        progressCadastro = findViewById(R.id.progressCadastro);
        txtTelaLogin = findViewById(R.id.txtTelaLogin);

        //BD
        pacienteDAO = new PacienteDAO(getApplicationContext());

        //ProgressBar
        progressCadastro.setVisibility(View.GONE);
        progressCadastro.setEnabled(false);

        //Ação do Botão = Cadastrar
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cadastrar
                cadastrar();
            }
        });

        //Apertar o texto de Tela_Login
        txtTelaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Terminar Activity e voltar para o login
                finish();
            }
        });
    }

    //Realizando Cadastro
    private void cadastrar(){

        //Validação
        if(!validacao()){
            falhaCadastro();
            return;
        }

        //Sucesso ao verificar campos, ativando ProgressBar
        progressCadastro.setEnabled(true);
        progressCadastro.setVisibility(View.VISIBLE);

        //Acrescentando Delay no login
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Verificando a existência do CPF (Primary Key)
                if(!pacienteDAO.verificaCPFBD(etxtCPF.getText().toString())){
                    //Cadastrando no Banco de Dados e Iniciando App
                    if(!cadastraBD()){
                        falhaCadastro();
                        progressCadastro.setVisibility(View.GONE);
                        progressCadastro.setEnabled(false);
                        return;
                    } else {
                        sucessoCadastro();
                    }
                } else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(CadastroActivity.this);
                    dialog.setTitle("Erro de Cadastramento");
                    dialog.setMessage("CPF já cadastrado. Faça login!");
                    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Terminar Activity e voltar para o login
                            finish();
                        }
                    });
                    dialog.create();
                    dialog.show();
                }

            }
        }, 3000); //3s de delay
    }
    //Validação dos campos...
    private boolean validacao(){
        boolean valida = true;

        //Recuperando campos
        String Nome = etxtNome.getText().toString();
        String Sobrenome = etxtSobrenome.getText().toString();
        String CPF = etxtCPF.getText().toString();
        String Estado = etxtEstado.getText().toString();
        String Cidade = etxtCidade.getText().toString();
        String Telefone = etxtTelefone.getText().toString();
        String Senha = etxtSenha.getText().toString();

        //Validando campos..

        //Nome
        if(Nome.isEmpty() || Nome.length() < 3){
            etxtNome.setError("Pelo menos 3 caracteres!");
            valida = false;
        } else {
            etxtNome.setError(null);
        }

        //Sobrenome
        if(Sobrenome.isEmpty() || Sobrenome.length() < 3){
            etxtSobrenome.setError("Pelo menos 3 caracteres!");
            valida = false;
        } else{
            etxtSobrenome.setError(null);
        }

        //CPF
        if(CPF.isEmpty() || !validaCPF(CPF)){
            etxtCPF.setError("CPF inválido!");
            valida = false;
        } else {
            etxtCPF.setError(null);
        }

        //Estado
        if(Estado.isEmpty() || Estado.length() < 2){
            etxtEstado.setError("Sigla do Estado (2 caracteres). Ex: SP.");
            valida = false;
        } else {
            etxtEstado.setError(null);
        }

        //Cidade
        if(Cidade.isEmpty() || Cidade.length() < 3){
            etxtCidade.setError("Pelo menos 3 caracteres!");
            valida = false;
        } else {
            etxtCidade.setError(null);
        }

        //Telefone
        if(Telefone.isEmpty() || Telefone.length() < 11){
            etxtTelefone.setError("Telefone inválido!");
            valida = false;
        } else {
            etxtTelefone.setError(null);
        }

        //Senha
        if(Senha.isEmpty() || Senha.length() < 4 || Senha.length() > 10){
            etxtSenha.setError("Entre 4 e 10 caracteres alfanuméricos!");
            valida = false;
        } else {
            etxtSenha.setError(null);
        }

        return valida;
    }
    //Validando CPF
    private boolean validaCPF(String CPF){
        //1°: considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") || CPF.equals("99999999999") || (CPF.length() != 11))
            return false;

        //Analisando dígitos
        char dig10, dig11;
        int sm, i, r, num, peso;
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return true;
            else
                return false;
        } catch (InputMismatchException e) {
            return false;
        }
    }

    //Cadastrando no Banco de Dados
    private boolean cadastraBD(){
        //Recuperando Campos para Cadastro
        PacienteModelo paciente = new PacienteModelo();
        paciente.setNome(etxtNome.getText().toString() + " " + etxtSobrenome.getText().toString());
        paciente.setCPF(etxtCPF.getText().toString());
        paciente.setEstado(etxtEstado.getText().toString());
        paciente.setCidade(etxtCidade.getText().toString());
        paciente.setTelefone(etxtTelefone.getText().toString());
        paciente.setSenhaApp(etxtSenha.getText().toString());

        //Salvando no BD
        if(pacienteDAO.salvar(paciente)){
            return true;
        } else{
            return false;
        }
    }

    //Sucesso/Falha ao Cadastrar
    private void sucessoCadastro(){
        //Devolvendo com o valor do CPF cadastrado...
        setResult(RESULT_OK, new Intent().putExtra("cpf", etxtCPF.getText().toString()));
        finish();
    }
    private void falhaCadastro(){
        Toast.makeText(getApplicationContext(), "Erro de Autenticação", Toast.LENGTH_LONG).show();
    }


}
