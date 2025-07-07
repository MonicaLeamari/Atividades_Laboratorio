package br.com.atividade7;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/banco")
public class BancoServlet extends HttpServlet {

    private BancoSession bancoSession = new BancoSession();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("banco", bancoSession.listarTodos());
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
                bancoSession.excluir(Integer.parseInt(deleteId));
            } else {
                Banco banco = new Banco();
                banco.setNome(nome);
                banco.setDataNascimento(new SimpleDateFormat("yyyy-MM-dd").parse(dataStr));

                if (updateId != null) {
                    banco.setId(Integer.parseInt(updateId));
                    bancoSession.atualizar(banco);
                } else {
                    bancoSession.salvar(banco);
                }
            }

            response.sendRedirect("banco");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}