<%@ page import="java.sql.*, javax.naming.*, javax.sql.*" %>
<%
    String nome = request.getParameter("nome");
    String dataStr = request.getParameter("data_nascimento");

    try {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/BancoDB");
        Connection con = ds.getConnection();

        PreparedStatement ps = con.prepareStatement("INSERT INTO banco (nome, data_nascimento) VALUES (?, ?)");
        ps.setString(1, nome);
        ps.setDate(2, java.sql.Date.valueOf(dataStr));
        ps.executeUpdate();
        con.close();

        response.sendRedirect("listaBancos.jsp");
    } catch (Exception e) {
        out.println("Erro: " + e.getMessage());
    }
%>