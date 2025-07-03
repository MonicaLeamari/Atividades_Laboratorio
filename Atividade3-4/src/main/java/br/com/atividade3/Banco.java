package br.com.atividade3;
import java.sql.Date;
import java.util.List;

public class Banco {
    private int id;
    private String nome;
    private Date data_nascimento;

    private BancoDAO bancoDAO = new BancoDAO();

    public Banco() {}

    public Banco(int id, String nome, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = dataNascimento;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    
    public List<Banco> getLista() {
        try {
            return bancoDAO.listarTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void salvar() {
        try {
            Banco banco = new Banco(0, nome, data_nascimento);
            bancoDAO.inserir(banco);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizar() {
        try {
            Banco banco = new Banco(id, nome, data_nascimento);
            bancoDAO.atualizar(banco);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        try {
            bancoDAO.deletar(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
