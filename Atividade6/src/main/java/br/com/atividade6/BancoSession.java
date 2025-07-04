package br.com.atividade6;

import br.com.atividade6.Banco;
import br.com.atividade6.BancoDAO;
import java.util.List;

public class BancoSession {

    private BancoDAO bancoDAO = new BancoDAO();

    public void salvar(Banco banco) throws Exception {
        bancoDAO.inserir(banco);
    }

    public void atualizar(Banco banco) throws Exception {
        bancoDAO.atualizar(banco);
    }
    
    private void validarBanco(Banco banco) throws Exception {
        if (banco.getNome() == null || banco.getNome().trim().isEmpty()) {
            throw new Exception("O nome é obrigatório.");
        }

        if (banco.getData_nascimento() == null) {
            throw new Exception("A data de nascimento é obrigatória.");
        }

    }

    public void excluir(int id) throws Exception {
        bancoDAO.deletar(id);
    }

    public List<Banco> listarTodos() throws Exception {
        return bancoDAO.listarTodos();
    }
    
    public BancoSession() {
        this.bancoDAO = new BancoDAO(); 
    }
    
    
}

