<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, br.com.atividade3.Banco" %>
<meta charset="UTF-8">

<html>
<head>
    <title>Lista de Bancos</title>
     <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            color: #333;
            padding: 40px;
        }

        h1, h2 {
            color: #2c3e50;
        }

        form {
            background: #ffffff;
            padding: 20px;
            margin-bottom: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            max-width: 400px;
        }

        input[type="text"],
        input[type="email"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-top: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
        }

        input[type="submit"],
input[type="button"] {
    background-color: #3498db;
    color: white;
    padding: 10px 16px;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    font-weight: bold;
}

input[type="submit"]:hover,
input[type="button"]:hover {
    background-color: #2980b9;
}
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 2px 8px rgba(0,0,0,0.05);
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #3498db;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .no-users {
            color: #888;
            font-style: italic;
        }
        .form-container {
    display: flex;
    gap: 20px;
    flex-wrap: wrap;
    margin-bottom: 30px;
}

.form-box {
    flex: 1;
    min-width: 300px;
}
    </style>
    <script>
        function habilitarEdicao(id) {
            document.getElementById('nome_' + id).style.display = 'none';
            document.getElementById('nomeInput_' + id).style.display = 'inline';

            document.getElementById('data_' + id).style.display = 'none';
            document.getElementById('dataInput_' + id).style.display = 'inline';

            document.getElementById('btnEditar_' + id).style.display = 'none';
            document.getElementById('btnSalvar_' + id).style.display = 'inline';
        }
    </script>
</head>
<body>
    <h2>Lista de Bancos</h2>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Data de Nascimento</th>
            <th>Atualizar</th>
            <th>Excluir</th>
        </tr>

        <%
            List<Banco> bancos = (List<Banco>) request.getAttribute("banco");
            for (Banco banco : bancos) {
        %>
        <tr>
            <form method="post" action="banco">
                <input type="hidden" name="updateId" value="<%= banco.getId() %>">
                <td><%= banco.getId() %></td>

                <td>
                    <span id="nome_<%= banco.getId() %>"><%= banco.getNome() %></span>
                    <input type="text" name="nome" id="nomeInput_<%= banco.getId() %>" value="<%= banco.getNome() %>" style="display:none;">
                </td>

                <td>
                    <span id="data_<%= banco.getId() %>"><%= banco.getDataNascimento() %></span>
                    <input type="date" name="data_nascimento" id="dataInput_<%= banco.getId() %>" value="<%= banco.getDataNascimento() %>" style="display:none;">
                </td>

                <td>
                    <input type="button" id="btnEditar_<%= banco.getId() %>" value="Editar" onclick="habilitarEdicao(<%= banco.getId() %>)">
                    <input type="submit" id="btnSalvar_<%= banco.getId() %>" value="Salvar" style="display:none;">
                </td>
            </form>

            <form method="post" action="banco">
                <input type="hidden" name="deleteId" value="<%= banco.getId() %>">
                <td><input type="submit" value="Excluir" onclick="return confirm('Tem certeza que deseja excluir?');"></td>
            </form>
        </tr>
        <%
            }
        %>
    </table>

    <br><hr><br>

    <h3>Inserir Novo Banco</h3>
    <form method="post" action="banco">
        Nome: <input type="text" name="nome" required>
        Data de Nascimento: <input type="date" name="data_nascimento" required>
        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
