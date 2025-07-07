//package br.com.atividade7;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import br.com.atividade7.Banco;
//import br.com.atividade7.Conexao;
//
//public class BancoDAO {
//
//    public void inserir(Banco banco) throws Exception {
//        String sql = "INSERT INTO banco (nome, data_nascimento) VALUES (?, ?)";
//        try (Connection con = Conexao.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setString(1, banco.getNome());
//            ps.setDate(2, banco.getDataNascimento());
//            ps.executeUpdate();
//        }
//    }
//
//    public void atualizar(Banco banco) throws Exception {
//        String sql = "UPDATE banco SET nome = ?, data_nascimento = ? WHERE id = ?";
//        try (Connection con = Conexao.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setString(1, banco.getNome());
//            ps.setDate(2, banco.getDataNascimento());
//            ps.setInt(3, banco.getId());
//            ps.executeUpdate();
//        }
//    }
//
//    public void deletar(int id) throws Exception {
//        String sql = "DELETE FROM banco WHERE id = ?";
//        try (Connection con = Conexao.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setInt(1, id);
//            ps.executeUpdate();
//        }
//    }
//
//    public Banco buscarPorId(int id) throws Exception {
//        String sql = "SELECT * FROM banco WHERE id = ?";
//        try (Connection con = Conexao.getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                return new Banco(
//                    rs.getInt("id"),
//                    rs.getString("nome"),
//                    rs.getDate("data_nascimento")
//                );
//            }
//        }
//        return null;
//    }
//
//    public List<Banco> listarTodos() throws Exception {
//        List<Banco> lista = new ArrayList<>();
//        String sql = "SELECT * FROM banco ORDER BY id";
//        try (Connection con = Conexao.getConnection();
//             Statement stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            while (rs.next()) {
//                Banco banco = new Banco(
//                    rs.getInt("id"),
//                    rs.getString("nome"),
//                    rs.getDate("data_nascimento")
//                );
//                lista.add(banco);
//            }
//        }
//        return lista;
//    }
//}