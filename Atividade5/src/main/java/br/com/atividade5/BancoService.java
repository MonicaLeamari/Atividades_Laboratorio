package br.com.atividade5;

import br.com.atividade5.Banco;
import br.com.atividade5.BancoDAO;
import java.util.List;

public class BancoService {

    private BancoDAO bancoDAO = new BancoDAO();

    public void salvar(Banco banco) throws Exception {
        bancoDAO.inserir(banco);
    }

    public void atualizar(Banco banco) throws Exception {
        bancoDAO.atualizar(banco);
    }

    public void excluir(int id) throws Exception {
        bancoDAO.deletar(id);
    }

    public List<Banco> listarTodos() throws Exception {
        return bancoDAO.listarTodos();
    }
}
