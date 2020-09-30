package com.example.objetointent;

import java.io.Serializable;

public class Pessoa implements Serializable {
    // atributos (variáveis)
    private String nome; // encapsulamento (caixa preta)
    private String sobrenome;

    // construtor vazio
    public Pessoa() {
    }

    // construtor inicializado
    public Pessoa(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
