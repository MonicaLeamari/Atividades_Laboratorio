package br.com.atividade6;

import java.sql.Date;

public class Banco {
    private int id;
    private String nome;
    private Date data_nascimento;
    

    public Banco() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Date getData_nascimento() { return data_nascimento; }
    public void setData_nascimento(Date data_nascimento) { this.data_nascimento = data_nascimento; }
    
    public Banco(int id, String nome, Date data_nascimento) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }
}