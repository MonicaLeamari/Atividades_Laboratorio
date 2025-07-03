package br.com.atividade5;

import br.com.atividade5.BancoDAO;

import br.com.atividade5.BancoService;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;

public class BancoServlet extends HttpServlet {

    private BancoService bancoService = new BancoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("banco", bancoService.listarTodos());
            request.getRequestDispatcher("ListaBanco.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String dataStr = request.getParameter("data_nascimento");
        String deleteId = request.getParameter("deleteId");
        String updateId = request.getParameter("updateId");

        try {
            if (deleteId != null) {
                bancoService.excluir(Integer.parseInt(deleteId));
            } else {
                Banco banco = new Banco();
                banco.setNome(nome);
                banco.setData_nascimento(Date.valueOf(dataStr));

                if (updateId != null) {
                    banco.setId(Integer.parseInt(updateId));
                    bancoService.atualizar(banco);
                } else {
                    bancoService.salvar(banco);
                }
            }

            response.sendRedirect("banco");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
