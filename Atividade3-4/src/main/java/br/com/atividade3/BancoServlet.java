package br.com.atividade3;

import br.com.atividade3.BancoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class BancoServlet extends HttpServlet {

    private BancoDAO bancoDAO;

    @Override
    public void init() {
        bancoDAO = new BancoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Banco> lista = bancoDAO.listarTodos();
            request.setAttribute("banco", lista);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ListaBanco.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Erro ao buscar lista de bancos", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");
        String dataStr = request.getParameter("data_nascimento");
        String deleteId = request.getParameter("deleteId");
        String updateId = request.getParameter("updateId");

        try {
            if (deleteId != null && !deleteId.isEmpty()) {
                int id = Integer.parseInt(deleteId);
                bancoDAO.deletar(id);
            } else if (updateId != null && !updateId.isEmpty()) {
                int id = Integer.parseInt(updateId);
                Banco banco = new Banco();
                banco.setId(id);
                banco.setNome(nome);
                banco.setDataNascimento(Date.valueOf(dataStr));
                bancoDAO.atualizar(banco);
            } else {
                Banco banco = new Banco();
                banco.setNome(nome);
                banco.setDataNascimento(Date.valueOf(dataStr));
                bancoDAO.inserir(banco);
            }

            response.sendRedirect("banco");

        } catch (Exception e) {
            throw new ServletException("Erro ao processar requisição POST", e);
        }
    }
}
