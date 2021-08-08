package com.davizaum.calculadoracientfica;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //TextField relacionados a entrada do usuário e ao sinal utilizado
    TextView txtfEntrada, txtfSinal;

    //Verificação de vírgula no número digitado
    boolean temVirgula;

    //Uso de valores em decimais para os cálculos
    Double num1, num2, resposta;

    //Recuperar valores e sinais advindos dos textos
    String txtNum1, txtNum2, txtSinal;

    //Recuperação dos botões para colocar as funções de "onClick" (quando apertar...)
    Button[] btnDigitos, btnSinais;
    Button btnVirgula, btnIgual, btnLimpar;
    ImageButton btnDeletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FindViewById é uma função para recuperar o componente (View) com base em um parâmetro
            //Geralmente, utiliza-se a classe "R" para encontrar o componente pelo "id"
        txtfEntrada = (TextView) findViewById(R.id.txtEntrada);
        txtfSinal = (TextView) findViewById(R.id.txtSinal);

        //Recuperação dos botões
        btnDigitos = new Button[10]; //Instância do Objeto Botão, com 10 posições
        btnDigitos[0] = findViewById(R.id.btn0);
        btnDigitos[1] = findViewById(R.id.btn1);
        btnDigitos[2] = findViewById(R.id.btn2);
        btnDigitos[3] = findViewById(R.id.btn3);
        btnDigitos[4] = findViewById(R.id.btn4);
        btnDigitos[5] = findViewById(R.id.btn5);
        btnDigitos[6] = findViewById(R.id.btn6);
        btnDigitos[7] = findViewById(R.id.btn7);
        btnDigitos[8] = findViewById(R.id.btn8);
        btnDigitos[9] = findViewById(R.id.btn9);

        btnSinais = new Button[12];
        btnSinais[0] = findViewById(R.id.btnLog);
        btnSinais[1] = findViewById(R.id.btnLn);
        btnSinais[2] = findViewById(R.id.btnPotX);
        btnSinais[3] = findViewById(R.id.btnRaiz);
        btnSinais[4] = findViewById(R.id.btnFatorial);
        btnSinais[5] = findViewById(R.id.btnSen);
        btnSinais[6] = findViewById(R.id.btnCos);
        btnSinais[7] = findViewById(R.id.btnTan);
        btnSinais[8] = findViewById(R.id.btnSoma);
        btnSinais[9] = findViewById(R.id.btnSubtrai);
        btnSinais[10] = findViewById(R.id.btnMultiplica);
        btnSinais[11] = findViewById(R.id.btnDivisao);

        btnVirgula = findViewById(R.id.btnVirgula);
        btnIgual = findViewById(R.id.btnIgual);
        btnDeletar = findViewById(R.id.btnDelete);
        btnLimpar = findViewById(R.id.btnLimpar);

        //Iniciar sem vírgula
        temVirgula = false;

        //Setando os onClick nos botões recuperados!
        setOnClick();
    }

    //---------------------------------------------------------------------------------------------//
    //-------------------- Método privado para setar os "OnClick" nos botões! ---------------------//
    //---------------------------------------------------------------------------------------------//
    private void setOnClick(){
        //Dígitos
        btnDigitos[0].setOnClickListener(this::onClick_btn0);
        btnDigitos[1].setOnClickListener(this::onClick_btn1);
        btnDigitos[2].setOnClickListener(this::onClick_btn2);
        btnDigitos[3].setOnClickListener(this::onClick_btn3);
        btnDigitos[4].setOnClickListener(this::onClick_btn4);
        btnDigitos[5].setOnClickListener(this::onClick_btn5);
        btnDigitos[6].setOnClickListener(this::onClick_btn6);
        btnDigitos[7].setOnClickListener(this::onClick_btn7);
        btnDigitos[8].setOnClickListener(this::onClick_btn8);
        btnDigitos[9].setOnClickListener(this::onClick_btn9);

        //Sinais/Operações
        btnSinais[0].setOnClickListener(this::onClick_btnLog);
        btnSinais[1].setOnClickListener(this::onClick_btnLn);
        btnSinais[2].setOnClickListener(this::onClick_btnPotN);
        btnSinais[3].setOnClickListener(this::onClick_btnRaizQuad);
        btnSinais[4].setOnClickListener(this::onClick_btnFatorial);
        btnSinais[5].setOnClickListener(this::onClick_btnSen);
        btnSinais[6].setOnClickListener(this::onClick_btnCos);
        btnSinais[7].setOnClickListener(this::onClick_btnTan);
        btnSinais[8].setOnClickListener(this::onClick_btnSoma);
        btnSinais[9].setOnClickListener(this::onClick_btnSubtrai);
        btnSinais[10].setOnClickListener(this::onClick_btnMultiplica);
        btnSinais[11].setOnClickListener(this::onClick_btnDivide);

        //Outros
        btnVirgula.setOnClickListener(this::onClick_btnVirgula);
        btnIgual.setOnClickListener(this::onClick_btnIgualdade);
        btnDeletar.setOnClickListener(this::onClick_btnLimparDigito);
        btnLimpar.setOnClickListener(this::onClick_btnLimparTotal);
    }

    //---------------------------------------------------------------------------------------------//
    //------------- Recuperando os valores numéricos e a função matemática desejada! --------------//
    //---------------------------------------------------------------------------------------------//

    //Botão 0
    @SuppressLint("SetTextI18n") //SuppressLint é utilizado para ignorar alguns warning's durante a compilação
    private void onClick_btn0(View view){
        txtfEntrada.setText(txtfEntrada.getText() + "0");
    }

    //Botão 1
    @SuppressLint("SetTextI18n")
    private void onClick_btn1(View view){
        txtfEntrada.setText(txtfEntrada.getText() + "1");
    }

    //Botão 2
    @SuppressLint("SetTextI18n")
    private void onClick_btn2(View view){
        txtfEntrada.setText(txtfEntrada.getText() + "2");
    }

    //Botão 3
    @SuppressLint("SetTextI18n")
    private void onClick_btn3(View view){
        txtfEntrada.setText(txtfEntrada.getText() + "3");
    }

    //Botão 4
    @SuppressLint("SetTextI18n")
    private void onClick_btn4(View view){
        txtfEntrada.setText(txtfEntrada.getText() + "4");
    }

    //Botão 5
    @SuppressLint("SetTextI18n")
    private void onClick_btn5(View view){
        txtfEntrada.setText(txtfEntrada.getText() + "5");
    }

    //Botão 6
    @SuppressLint("SetTextI18n")
    private void onClick_btn6(View view){
        txtfEntrada.setText(txtfEntrada.getText() + "6");
    }

    //Botão 7
    @SuppressLint("SetTextI18n")
    private void onClick_btn7(View view){
        txtfEntrada.setText(txtfEntrada.getText() + "7");
    }

    //Botão 8
    @SuppressLint("SetTextI18n")
    private void onClick_btn8(View view){
        txtfEntrada.setText(txtfEntrada.getText() + "8");
    }

    //Botão 9
    @SuppressLint("SetTextI18n")
    private void onClick_btn9(View view){
        txtfEntrada.setText(txtfEntrada.getText() + "9");
    }

    //Botão de Vírgula (Ponto)
    @SuppressLint("SetTextI18n")
    private void onClick_btnVirgula(View view){

        //Só coloca caso não tenha vírgula
        if(temVirgula == false){

            //Verificação do texto atual
            if(txtfEntrada.getText().equals("")){
                txtfEntrada.setText("0.");
            }
            else{
                txtfEntrada.setText(txtfEntrada.getText() + ".");
            }

            //Já tem vírgula, não pode colocar mais
            temVirgula = true;
        }

    }

    //Botão de Soma
    private void onClick_btnSoma(View view){
        //Atribui o sinal da operação
        txtSinal = "+";

        //Recupera e salva o valor 1 digitado pelo usuário até aqui
        txtNum1 = txtfEntrada.getText().toString();

        //Seta a entrada para nulo (0)
        txtfEntrada.setText(null);

        //Atribui o sinal respectivo ao TextView
        txtfSinal.setText("+");

        //Reseta a presença de vírgula para o número novo
        temVirgula = false;
    }

    //Botão de Subtração
    private void onClick_btnSubtrai(View view){
        //Atribui o sinal da operação
        txtSinal = "-";

        //Recupera e salva o valor 1 digitado pelo usuário até aqui
        txtNum1 = txtfEntrada.getText().toString();

        //Seta a entrada para nulo (0)
        txtfEntrada.setText(null);

        //Atribui o sinal respectivo ao TextView
        txtfSinal.setText("-");

        //Reseta a presença de vírgula para o número novo
        temVirgula = false;
    }

    //Botão de Multiplicação
    private void onClick_btnMultiplica(View view){
        //Atribui o sinal da operação
        txtSinal = "*";

        //Recupera e salva o valor 1 digitado pelo usuário até aqui
        txtNum1 = txtfEntrada.getText().toString();

        //Seta a entrada para nulo (0)
        txtfEntrada.setText(null);

        //Atribui o sinal respectivo ao TextView
        txtfSinal.setText("x");

        //Reseta a presença de vírgula para o número novo
        temVirgula = false;
    }

    //Botão de Divisão
    private void onClick_btnDivide(View view){
        //Atribui o sinal da operação
        txtSinal = "/";

        //Recupera e salva o valor 1 digitado pelo usuário até aqui
        txtNum1 = txtfEntrada.getText().toString();

        //Seta a entrada para nulo (0)
        txtfEntrada.setText(null);

        //Atribui o sinal respectivo ao TextView
        txtfSinal.setText("÷");

        //Reseta a presença de vírgula para o número novo
        temVirgula = false;
    }

    //Botão de Logaritmo (base 10)
    @SuppressLint("SetTextI18n")
    private void onClick_btnLog(View view){
        //Atribui o sinal da operação
        txtSinal = "log";

        //Seta a entrada para nulo (0)
        txtfEntrada.setText(null);

        //Atribui o sinal respectivo ao TextView
        txtfSinal.setText("log");

        //Reseta a presença de vírgula para o número novo
        temVirgula = false;
    }

    //Botão de Logaritmo Natural (base e)
    @SuppressLint("SetTextI18n")
    private void onClick_btnLn(View view){
        //Atribui o sinal da operação
        txtSinal = "ln";

        //Seta a entrada para nulo (0)
        txtfEntrada.setText(null);

        //Atribui o sinal respectivo ao TextView
        txtfSinal.setText("ln");

        //Reseta a presença de vírgula para o número novo
        temVirgula = false;
    }

    //Botão de Potência
    private void onClick_btnPotN(View view){
        //Atribui o sinal da operação
        txtSinal = "power";

        //Recupera e salva o valor 1 digitado pelo usuário até aqui
        txtNum1 = txtfEntrada.getText().toString();

        //Seta a entrada para nulo (0)
        txtfEntrada.setText(null);

        //Caso a entrada esteja vazia...
        if(txtNum1.equals("")){
            txtSinal = null;
            txtfSinal.setText("ERRO!");
        }
        else{
            //Atribui o sinal respectivo ao TextView
            txtfSinal.setText("xⁿ");
        }

        //Reseta a presença de vírgula para o número novo
        temVirgula = false;
    }

    //Botão de Fatorial
    private void onClick_btnFatorial(View view){
        //Atribui o sinal da operação
        txtSinal = "factorial";

        //Seta a entrada para nulo (0)
        txtfEntrada.setText(null);

        //Atribui o sinal respectivo ao TextView
        txtfSinal.setText("!");

        //Reseta a presença de vírgula para o número novo
        temVirgula = false;
    }

    //Botão de Seno
    @SuppressLint("SetTextI18n")
    private void onClick_btnSen(View view){
        //Atribui o sinal da operação
        txtSinal = "sin";

        //Seta a entrada para nulo (0)
        txtfEntrada.setText(null);

        //Atribui o sinal respectivo ao TextView
        txtfSinal.setText("sen");

        //Reseta a presença de vírgula para o número novo
        temVirgula = false;
    }

    //Botão de Cosseno
    @SuppressLint("SetTextI18n")
    private void onClick_btnCos(View view){
        //Atribui o sinal da operação
        txtSinal = "cos";

        //Seta a entrada para nulo (0)
        txtfEntrada.setText(null);

        //Atribui o sinal respectivo ao TextView
        txtfSinal.setText("cos");

        //Reseta a presença de vírgula para o número novo
        temVirgula = false;
    }

    //Botão de Tangente
    @SuppressLint("SetTextI18n")
    private void onClick_btnTan(View view){
        //Atribui o sinal da operação
        txtSinal = "tan";

        //Seta a entrada para nulo (0)
        txtfEntrada.setText(null);

        //Atribui o sinal respectivo ao TextView
        txtfSinal.setText("tan");

        //Reseta a presença de vírgula para o número novo
        temVirgula = false;
    }

    //Botão de Raiz Quadrada
    private void onClick_btnRaizQuad(View view){
        //Atribui o sinal da operação
        txtSinal = "root";

        //Seta a entrada para nulo (0)
        txtfEntrada.setText(null);

        //Atribui o sinal respectivo ao TextView
        txtfSinal.setText("√");

        //Reseta a presença de vírgula para o número novo
        temVirgula = false;
    }

    //---------------------------------------------------------------------------------------------//
    //---------------------- Operações de Remoção Parcial (dígitos) e Total -----------------------//
    //---------------------------------------------------------------------------------------------//

    private void onClick_btnLimparDigito(View view){
        //Necessário verificar se há algo já digitado
        if(txtfEntrada.getText().equals("")){
            txtfEntrada.setText(null);
        }
        //Caso já tenha algo digitado
        else{
            //Necessário saber a posição da vírgula (caso exista)
            int tamanho = txtfEntrada.getText().length() - 1;
            String verificaVirgula = txtfEntrada.getText().toString();

            //Verificando virgula
            if(verificaVirgula.charAt(tamanho) == '.'){
                //Retira a vírgula
                temVirgula = false;
            }

            //Setando o novo texto
            txtfEntrada.setText(txtfEntrada.getText().subSequence(0, tamanho));
        }
    }

    private void onClick_btnLimparTotal(View view){
        //Basicamente, limpar todos os valores possívels (colocar null)
        txtfEntrada.setText(null);
        txtfSinal.setText(null);
        txtNum1 = null;
        txtNum2 = null;
        txtSinal = null;
        temVirgula = false;
    }

    //---------------------------------------------------------------------------------------------//
    //---------------- Realização das Operações: verificação e uso de switch/case -----------------//
    //---------------------------------------------------------------------------------------------//
    @SuppressLint("SetTextI18n")
    private void onClick_btnIgualdade(View view){
        //Verificação de Erros: não há sinal; não há 1° ou 2° números
        if(txtSinal == null) {
            txtfSinal.setText(txtfEntrada.getText());
        }
        else if(txtfEntrada.getText().equals("") || ((txtSinal.equals("+") || txtSinal.equals("-") || txtSinal.equals("*") || txtSinal.equals("/")) && txtNum1.equals(""))){
            txtfSinal.setText("ERRO!");
        }
        //Do contrário, pode fazer operação tranquilo (NÃO vamos verificar a questão de casas decimais...)
        else{
            //Operações com mais de um número
            if (
                    txtSinal.equals("+") ||
                    txtSinal.equals("-") ||
                    txtSinal.equals("*") ||
                    txtSinal.equals("/") ||
                    txtSinal.equals("power"))
            {
                num1 = Double.parseDouble(txtNum1);
                txtNum2 = txtfEntrada.getText().toString();
                num2 = Double.parseDouble(txtNum2);
            }
            //Operações com apenas um número
            else{
                txtNum1 = txtfEntrada.getText().toString();
                num1 = Double.parseDouble(txtNum1);
            }

            //Realização das Operações após pré-configuração dos números!
            switch (txtSinal) {
                case "log":
                    resposta = Math.log10(num1);
                    break;
                case "ln":
                    resposta = Math.log(num1);
                    break;
                case "power":
                    resposta = Math.pow(num1, num2);
                    break;
                case "root":
                    resposta = Math.sqrt(num1);
                    break;
                case "factorial":
                    Integer i = Integer.parseInt(txtNum1) - 1;
                    while(i > 0){
                        num1 = num1 * i;
                        i--;
                    }
                    resposta = num1;
                    break;
                case "sin":
                    num1 = Math.toRadians(num1);
                    resposta = Math.sin(num1);
                    break;
                case "cos":
                    num1 = Math.toRadians(num1);
                    resposta = Math.cos(num1);
                    break;
                case "tan":
                    num1 = Math.toRadians(num1);
                    resposta = Math.tan(num1);
                    break;
                case "+":
                    resposta = num1 + num2;
                    break;
                case "-":
                    resposta = num1 - num2;
                    break;
                case "*":
                    resposta = num1 * num2;
                    break;
                case "/":
                    resposta = num1 / num2;
                    break;
            }

            //Limpando os campos de sinais após operação
            txtSinal = null;
            txtfSinal.setText(null);

            //Mostrando a resposta final no campo
            txtfEntrada.setText(resposta + "");
        }

    }

}