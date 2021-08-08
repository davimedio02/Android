package com.eric.conectandosaude.BancoDeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {

    //Constantes e Outros para BD
    private static int CURRENT_VERSION = 1; //Versão atual do app
    private static String NOME_DB = "DB_CONSULTANDOAPP"; //Nome do Banco de Dados
    //Tabelas
    public static String TABELA_PACIENTE = "paciente";
    public static String TABELA_MEDICOS = "medico";
    public static String TABELA_CONSULTA = "consulta";

    //Inserção genérica
    private SQLiteDatabase escrita;

    //Construtor
    public DBHelper(@Nullable Context context) {
        super(context, NOME_DB, null, CURRENT_VERSION);
    }

    //Criação do Banco de Dados (chamado uma única vez) -> Criar Tabelas
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Criação das Tabelas
        String sqlTable = "CREATE TABLE IF NOT EXISTS ";

        //Paciente
        String paciente = sqlTable + TABELA_PACIENTE +
                " (cpf CHAR(11) PRIMARY KEY NOT NULL, " +
                "nome VARCHAR(50) NOT NULL, " +
                "telefone CHAR(11)," +
                "estado CHAR(2) NOT NULL, " +
                "cidade VARCHAR(30) NOT NULL, " +
                "senha CHAR(10) NOT NULL" +
                ");";
        db.execSQL(paciente);

        //Médico
        String medico = sqlTable + TABELA_MEDICOS +
                " (crm CHAR(6) PRIMARY KEY NOT NULL, " +
                "nome VARCHAR(50) NOT NULL, " +
                "especialidade VARCHAR(20) NOT NULL, " +
                "estado VARCHAR(30) NOT NULL, " +
                "cidade VARCHAR(30) NOT NULL, " +
                "endereco VARCHAR(80) NOT NULL, " +
                "cep CHAR(8) NOT NULL" +
                ");";
        db.execSQL(medico);

        //**Inserção genérica de médicos**
        escrita = db;
        insereGenerico();
        //**Inserção genérica de médicos**

        //Consulta
        String consulta = sqlTable + TABELA_CONSULTA +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "cpf_paciente CHAR(11) NOT NULL, " +
                "crm_medico CHAR(6) NOT NULL, " +
                "tipo VARCHAR(30) NOT NULL, " +
                "data DATE NOT NULL, " +
                "hora TIME NOT NULL, " +
                "FOREIGN KEY (cpf_paciente) REFERENCES " + TABELA_PACIENTE + "(cpf), " +
                "FOREIGN KEY (crm_medico) REFERENCES " + TABELA_MEDICOS + "(crm), " +
                "FOREIGN KEY (tipo) REFERENCES " + TABELA_MEDICOS + "(especialidade)" +
                ");";
        db.execSQL(consulta);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Inserção Genérica ao iniciar BD
    private void insereGenerico(){
        ContentValues medicoargs = new ContentValues();
        try{
            //Inserindo campos genéricos (medicos.txt)

            //////////////////////////////////////////
            //CARDIOLOGIA
            //////////////////////////////////////////
            medicoargs.put("crm", "108075");
            medicoargs.put("nome", "José Neto Bezerra");
            medicoargs.put("especialidade", "Cardiologia");
            medicoargs.put("cidade", "Osasco");
            medicoargs.put("estado", "São Paulo");
            medicoargs.put("endereco", "Rua Djalma Luiz, 158, Bairro Antônio Pedro");
            medicoargs.put("cep", "06061980");
            escrita.insert(DBHelper.TABELA_MEDICOS, null, medicoargs);

            medicoargs.put("crm", "109978");
            medicoargs.put("nome", "Vanuza de Castro");
            medicoargs.put("especialidade", "Cardiologia");
            medicoargs.put("cidade", "Osasco");
            medicoargs.put("estado", "São Paulo");
            medicoargs.put("endereco", "Rua Djalma Luiz, 150, Bairro Antônio Pedro");
            medicoargs.put("cep", "06061980");
            escrita.insert(DBHelper.TABELA_MEDICOS, null, medicoargs);

            medicoargs.put("crm", "109981");
            medicoargs.put("nome", "Pedro Miguel de Oliveira");
            medicoargs.put("especialidade", "Cardiologia");
            medicoargs.put("cidade", "Belo Horizonte");
            medicoargs.put("estado", "Minas Gerais");
            medicoargs.put("endereco", "Rua João Ulrich, 190, Bairro Boa Vista");
            medicoargs.put("cep", "38402137");
            escrita.insert(DBHelper.TABELA_MEDICOS, null, medicoargs);

            medicoargs.put("crm", "189029");
            medicoargs.put("nome", "Pietra Cristina Rocha");
            medicoargs.put("especialidade", "Cardiologia");
            medicoargs.put("cidade", "Fortaleza");
            medicoargs.put("estado", "Ceará");
            medicoargs.put("endereco", "Rua Praieiras, 109, Bairro Boas Novas");
            medicoargs.put("cep", "60010130");
            escrita.insert(DBHelper.TABELA_MEDICOS, null, medicoargs);

            //////////////////////////////////////////
            //CLÍNICO GERAL
            //////////////////////////////////////////
            medicoargs.put("crm", "109029");
            medicoargs.put("nome", "Roberta Miranda");
            medicoargs.put("especialidade", "Clínico Geral");
            medicoargs.put("cidade", "São Paulo");
            medicoargs.put("estado", "São Paulo");
            medicoargs.put("endereco", "Rua Ipiranga, 190, Bairro Ipiranga");
            medicoargs.put("cep", "04633000");
            escrita.insert(DBHelper.TABELA_MEDICOS, null, medicoargs);

            medicoargs.put("crm", "0691069");
            medicoargs.put("nome", "Davi Augusto Neves");
            medicoargs.put("especialidade", "Clínico Geral");
            medicoargs.put("cidade", "Bauru");
            medicoargs.put("estado", "São Paulo");
            medicoargs.put("endereco", "Rua Rogério Diniz, 192, Bairro Boa Vida");
            medicoargs.put("cep", "17010011");
            escrita.insert(DBHelper.TABELA_MEDICOS, null, medicoargs);

            medicoargs.put("crm", "190827");
            medicoargs.put("nome", "Roger Marinho da Silva");
            medicoargs.put("especialidade", "Clínico Geral");
            medicoargs.put("cidade", "Barueri");
            medicoargs.put("estado", "São Paulo");
            medicoargs.put("endereco", "Rua Barueri, 193, Bairro Alphaville");
            medicoargs.put("cep", "06470230");
            escrita.insert(DBHelper.TABELA_MEDICOS, null, medicoargs);

            medicoargs.put("crm", "109284");
            medicoargs.put("nome", "Danilovski Ribery Siqueira");
            medicoargs.put("especialidade", "Clínico Geral");
            medicoargs.put("cidade", "Osasco");
            medicoargs.put("estado", "São Paulo");
            medicoargs.put("endereco", "Rua Nova Osasco, 179, Bairro Jardim Padroeira");
            medicoargs.put("cep", "06162215");
            escrita.insert(DBHelper.TABELA_MEDICOS, null, medicoargs);

            //////////////////////////////////////////
            //ORTOPEDISTA
            //////////////////////////////////////////
            medicoargs.put("crm", "092173");
            medicoargs.put("nome", "Gabriela Ganon Gomes");
            medicoargs.put("especialidade", "Ortopedia");
            medicoargs.put("cidade", "Osasco");
            medicoargs.put("estado", "São Paulo");
            medicoargs.put("endereco", "Rua Boa Vida, 390, Bairro Jardim Veloso");
            medicoargs.put("cep", "06150000");
            escrita.insert(DBHelper.TABELA_MEDICOS, null, medicoargs);

            medicoargs.put("crm", "192830");
            medicoargs.put("nome", "Lucas Soares Santanna");
            medicoargs.put("especialidade", "Ortopedia");
            medicoargs.put("cidade", "Osasco");
            medicoargs.put("estado", "São Paulo");
            medicoargs.put("endereco", "Rua Igreja Nossa Senhora, 97, Bairro Jardim Roberto");
            medicoargs.put("cep", "06170093");
            escrita.insert(DBHelper.TABELA_MEDICOS, null, medicoargs);

            medicoargs.put("crm", "190028");
            medicoargs.put("nome", "Matheus Ferreira");
            medicoargs.put("especialidade", "Ortopedia");
            medicoargs.put("cidade", "São Paulo");
            medicoargs.put("estado", "São Paulo");
            medicoargs.put("endereco", "Rua Alto Lapa, 87, Bairro Alto da Lapa");
            medicoargs.put("cep", "05083020");
            escrita.insert(DBHelper.TABELA_MEDICOS, null, medicoargs);

            medicoargs.put("crm", "091829");
            medicoargs.put("nome", "Raul Victor Dornelles");
            medicoargs.put("especialidade", "Ortopedia");
            medicoargs.put("cidade", "Salvador");
            medicoargs.put("estado", "Bahia");
            medicoargs.put("endereco", "Rua Victor Raul, 89, Bairro Fonte Nova");
            medicoargs.put("cep", "40010050");
            escrita.insert(DBHelper.TABELA_MEDICOS, null, medicoargs);

            //////////////////////////////////////////
            //PEDIATRIA
            //////////////////////////////////////////
            medicoargs.put("crm", "019238");
            medicoargs.put("nome", "Ana Carolina Verniz");
            medicoargs.put("especialidade", "Pediatria");
            medicoargs.put("cidade", "São Carlos");
            medicoargs.put("estado", "São Paulo");
            medicoargs.put("endereco", "Rua João Morello, 241, Bairro Comandante Sampaio");
            medicoargs.put("cep", "13560201");
            escrita.insert(DBHelper.TABELA_MEDICOS, null, medicoargs);

            medicoargs.put("crm", "192837");
            medicoargs.put("nome", "Maria Danielly");
            medicoargs.put("especialidade", "Pediatria");
            medicoargs.put("cidade", "Osasco");
            medicoargs.put("estado", "São Paulo");
            medicoargs.put("endereco", "Rua Roberto Firmino, 293, Bairro Sorocaba");
            medicoargs.put("cep", "05109230");
            escrita.insert(DBHelper.TABELA_MEDICOS, null, medicoargs);

            medicoargs.put("crm", "283747");
            medicoargs.put("nome", "Ingrid Lemos");
            medicoargs.put("especialidade", "Pediatria");
            medicoargs.put("cidade", "São Paulo");
            medicoargs.put("estado", "São Paulo");
            medicoargs.put("endereco", "Rua Osasco, 234, Bairro Genérico");
            medicoargs.put("cep", "05276029");
            escrita.insert(DBHelper.TABELA_MEDICOS, null, medicoargs);

            medicoargs.put("crm", "293849");
            medicoargs.put("nome", "Amanda Verniz");
            medicoargs.put("especialidade", "Pediatria");
            medicoargs.put("cidade", "São Carlos");
            medicoargs.put("estado", "São Paulo");
            medicoargs.put("endereco", "Rua Plínio Alves, 39, Bairro São Paulo");
            medicoargs.put("cep", "06264330");
            escrita.insert(DBHelper.TABELA_MEDICOS, null, medicoargs);

        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
