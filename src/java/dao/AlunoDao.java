/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;

/**
 *
 * @author User
 */
public class AlunoDao {

    private Connection connection;

    public AlunoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean verificaUsuario(Aluno aluno) {
        String sql = "select * from aluno where usuario_aluno=? and senha_aluno=?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getUsuario());
            ps.setString(2, aluno.getSenha());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Aluno getUsuario(String usuario, String senha) throws SQLException {
        String sql = "select * from aluno where usuario_aluno=? and senha_aluno=?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = connection.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            if (rs.next()) {
                //Pegando Dados do Aluno
                Aluno aluno = new Aluno();
                aluno.setUsuario(usuario);
                aluno.setSenha(senha);
                //aluno.setNome(rs.getString("nome"));

                return aluno;

            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //fechando conexões
            connection.close();
            ps.close();
            rs.close();
            //System.out.println("O connection está fechado ? = "+connection.isClosed());
            //System.out.println("O PS está fechado ? = "+ps.isClosed());
            //System.out.println("O RS está fechado ? = "+rs.isClosed());
        }

        return null;
    }

    public List getListaAluno() throws SQLException {
        String sql = "select * from aluno";        
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Aluno> listaAluno = new ArrayList<Aluno>();        
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                //Pegando Dados do Aluno
                Aluno aluno = new Aluno();
                
                aluno.setNome(rs.getString("nome_aluno"));
                aluno.setUsuario(rs.getString("usuario_aluno"));
                //aluno.setEndereco(rs.getString("enedereco_aluno"));
                //aluno.setEmail(rs.getString("email_aluno"));
                //aluno.setAltura(rs.getDouble("altura_aluno"));
                //aluno.setIdade(rs.getInt("idade_aluno"));
                //aluno.setPeso(rs.getDouble("peso_aluno"));
                System.out.println("TESTANDO ONDE APARECE");
                listaAluno.add(aluno);                                
            }
            return listaAluno;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //fechando conexões
            connection.close();
            ps.close();
            rs.close();
        }
        return null;
    }
}
