package com.ems.bdsqlite.pojo;

import java.io.Serializable;

public class Aluno implements Serializable {
    private int id;
    private String ra;
    private String nome;
    private String curso;

    public Aluno() {
    }

    public Aluno(int id, String ra, String nome, String curso) {
        this.id = id;
        this.ra = ra;
        this.nome = nome;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getDados() {
        return "RA: " + ra + "\n" +
                "Nome: " + nome + "\n" +
                "Curso: " + curso;
    }
}
