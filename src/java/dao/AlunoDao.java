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
                //lembrar que tem que ser na ordem do banco de dados
                aluno.setNome(rs.getString("nome_aluno"));
                aluno.setUsuario(rs.getString("usuario_aluno"));
                aluno.setSenha(rs.getString("senha_aluno"));
                aluno.setEmail(rs.getString("email_aluno"));
                aluno.setEndereco(rs.getString("endereco_aluno"));
                aluno.setPeso(rs.getDouble("peso_aluno"));                
                aluno.setAltura(rs.getDouble("altura_aluno"));
                aluno.setIdade(rs.getInt("idade_aluno"));
                aluno.setNivel(rs.getInt("nivel_aluno"));
                                
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
    
    //exclui aluno por enquanto deixa no nome mas dps tem uqe mudar para codigo ou login
    public boolean excluiAluno(Aluno aluno) throws SQLException{
        String sql = "delete from aluno where nome_aluno=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getNome());            
            ps.execute();
            return true;            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connection.close();
            ps.close();           
        }        
        return false;        
    }   
    //implementar todos os outros dados
    public void AlteraAluno(Aluno aluno) throws SQLException{
        String sql = "update aluno SET nome_aluno=?,usuario_aluno=?,senha_aluno=?,email_aluno=?,endereco_aluno=?,idade_aluno=?,peso_aluno=?,altura_aluno=? where nome_aluno=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getUsuario());
            ps.setString(3, aluno.getSenha());
            ps.setString(4, aluno.getEmail());
            ps.setString(5, aluno.getEndereco());
            ps.setInt(6, aluno.getIdade());
            ps.setDouble(7, aluno.getPeso());
            ps.setDouble(8, aluno.getAltura());
            
            ps.execute();                        
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connection.close();
            ps.close();           
        }       
               
    }   
}
