package br.com.atividade7;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "banco")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public java.sql.Date getDataNascimento() { return (java.sql.Date) dataNascimento; }
    public void setDataNascimento(Date dataNascimento) { this.dataNascimento = dataNascimento; }
    
    public Banco(int id,String nome, Date dataNascimento) {
    	this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public Banco() {}
}