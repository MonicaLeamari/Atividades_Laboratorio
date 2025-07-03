package br.com.atividade3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BancoServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

        ArrayList<Banco>listaBancos = new ArrayList<>();

        try {
        	Class.forName("org.postgresql.Driver");
            Connection con = Conexao.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM banco");

            while (rs.next()) {
                Banco banco = new Banco(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDate("data_nascimento")
                );
                listaBancos.add(banco);
            }

            rs.close();
            stmt.close();
            con.close();

            request.setAttribute("banco", listaBancos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ListaBanco.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            throw new ServletException("Erro ao listar bancos", e);
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
		        Class.forName("org.postgresql.Driver");
		        Connection con = Conexao.getConnection();

		        if (deleteId != null && !deleteId.isEmpty()) {
		            int id = Integer.parseInt(deleteId);
		            String sql = "DELETE FROM banco WHERE id = ?";
		            PreparedStatement ps = con.prepareStatement(sql);
		            ps.setInt(1, id);
		            ps.executeUpdate();
		            ps.close();

		        } else if (updateId != null && !updateId.isEmpty() && nome != null && dataStr != null) {
		            int id = Integer.parseInt(updateId);
		            Date dataNascimento = Date.valueOf(dataStr);
		            String sql = "UPDATE banco SET nome = ?, data_nascimento = ? WHERE id = ?";
		            PreparedStatement ps = con.prepareStatement(sql);
		            ps.setString(1, nome);
		            ps.setDate(2, dataNascimento);
		            ps.setInt(3, id);
		            ps.executeUpdate();
		            ps.close();

		        } else if (nome != null && dataStr != null) {
		            Date dataNascimento = Date.valueOf(dataStr);
		            String sql = "INSERT INTO banco (nome, data_nascimento) VALUES (?, ?)";
		            PreparedStatement ps = con.prepareStatement(sql);
		            ps.setString(1, nome);
		            ps.setDate(2, dataNascimento);
		            ps.executeUpdate();
		            ps.close();
		        }

		        con.close();
		        response.sendRedirect("banco");

		    } catch (Exception e) {
		        throw new ServletException("Erro ao processar requisição POST", e);
		    }
	    }



}
