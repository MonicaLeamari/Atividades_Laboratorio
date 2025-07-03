package br.com.atividade3;

import br.com.atividade3.BancoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;

public class BancoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("ListaBanco.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String deleteId = request.getParameter("deleteId");
        String updateId = request.getParameter("updateId");

        Banco banco = new Banco();

        try {
            if (deleteId != null && !deleteId.isEmpty()) {
                banco.excluir(Integer.parseInt(deleteId));

            } else if (updateId != null && !updateId.isEmpty()) {
                banco.setId(Integer.parseInt(updateId));
                banco.setNome(request.getParameter("nome"));
                banco.setData_nascimento(Date.valueOf(request.getParameter("data_nascimento")));
                banco.atualizar();

            } else {
                banco.setNome(request.getParameter("nome"));
                banco.setData_nascimento(Date.valueOf(request.getParameter("data_nascimento")));
                banco.salvar();
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }

        response.sendRedirect("banco");
    }}