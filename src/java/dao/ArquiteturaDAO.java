/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Arquitetura;

public class ArquiteturaDAO {

    public static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }

        } catch (SQLException e) {
        }
    }

    public static void gravar(Arquitetura arquitetura) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO arquitetura (idArquitetura, caminhoImagem, FK_automovel) VALUES (?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, arquitetura.getIdArquitetura());
            comando.setString(2, arquitetura.getCaminhoImagem());
            comando.setInt(3, arquitetura.getIdAutomovel());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Arquitetura> obterArquiteturas() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Arquitetura> arquiteturas = new ArrayList<Arquitetura>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM arquitetura");
            while (rs.next()) {
                Arquitetura arquitetura = new Arquitetura(
                        rs.getInt("idArquitetura"),
                        rs.getString("caminhoImagem"),
                        rs.getInt("FK_automovel")
                );
                arquiteturas.add(arquitetura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return arquiteturas;
    }

    public static Arquitetura obterArquitetura(int idArquitetura) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Arquitetura arquitetura = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM arquitetura where idArquitetura = " + idArquitetura);
            rs.first();
            arquitetura = new Arquitetura(
                    rs.getInt("idArquitetura"),
                    rs.getString("caminhoImagem"),
                    rs.getInt("FK_automovel")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return arquitetura;
    }

    public static void alterar(Arquitetura arquitetura) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE arquitetura SET caminhoImagem = ?, "
                    + "FK_automovel = ? "
                    + "WHERE IdArquitetura = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, arquitetura.getCaminhoImagem());
            comando.setInt(2, arquitetura.getIdAutomovel());
            comando.setInt(3, arquitetura.getIdArquitetura());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Arquitetura arquitetura) throws SQLException, ClassNotFoundException {
        try {
            Connection db = BD.getConexao();
            PreparedStatement st = db.prepareStatement("delete from arquitetura where idArquitetura = ? ");
            st.setInt(1, arquitetura.getIdArquitetura());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {

        }
    }
}
