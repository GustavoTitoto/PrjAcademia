/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Professor;

/**
 *
 * @author User
 */
public class ProfessorDao {
     private Connection connection;

    public ProfessorDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public boolean verificaUsuario(Professor professor) {
        String sql = "select * from professor where usuario_professor=? and senha_professor=?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, professor.getUsuario());
            ps.setString(2, professor.getSenha());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Professor getUsuario(String usuario, String senha) throws SQLException {
        String sql = "select * from professor where usuario_professor=? and senha_professor=?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = connection.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            if (rs.next()) {
                //Pegando Dados do Professor
                Professor professor = new Professor();
                professor.setUsuario(usuario);
                professor.setSenha(senha);
                //professor.setNome(rs.getString("nome"));

                return professor;

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
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

    
    
    public List getListaProfessor() throws SQLException {
        String sql = "select * from professor";        
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Professor> listaProfessor = new ArrayList<Professor>();        
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                //Pegando Dados do Professor do banco
                Professor professor = new Professor();
                //lembrar que tem que ser na ordem do banco de dados
                professor.setNome(rs.getString("nome_professor"));
                professor.setUsuario(rs.getString("usuario_professor"));
                professor.setEmail(rs.getString("email_professor"));
                professor.setEndereco(rs.getString("endereco_professor"));                
                professor.setNivel(rs.getInt("nivel_professor"));
                
                System.out.println(rs.getString("nome_professor"));                
                listaProfessor.add(professor);                                
            }
            return listaProfessor;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //fechando conexões
            connection.close();
            ps.close();
            rs.close();
        }
        return null;
    }
    
    //exclui professor por enquanto deixa no nome mas dps tem uqe mudar para codigo ou login
    public boolean excluiProfessor(Professor professor) throws SQLException{
        String sql = "delete from professor where nome_professor=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, professor.getNome());            
            ps.execute();
            return true;            
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connection.close();
            ps.close();           
        }        
        return false;        
    }   
    //implementar todos os outros dados
    public void AlteraProfessor(Professor professor) throws SQLException{
        String sql = "update professor SET nome_professor=?,usuario_professor=? where nome_professor=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, professor.getNome());
            ps.setString(2, professor.getUsuario());
            ps.execute();                        
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connection.close();
            ps.close();           
        }       
               
    }   
}
