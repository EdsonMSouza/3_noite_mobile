package com.ems.bdsqlite.utils;

import java.io.Serializable;

public class Banco implements Serializable {
    private static String banco = "db_aluno.db";
    private static String tabela = "alunos";

    public static String banco() {
        return banco;
    }

    public static String criaTabela() {
        return "CREATE TABLE IF NOT EXISTS " + tabela() + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "ra VARCHAR NOT NULL, " +
                "nome VARCHAR NOT NULL, " +
                "curso VARCHAR NOT NULL);";
    }

    public static String tabela() {
        return tabela;
    }
}
