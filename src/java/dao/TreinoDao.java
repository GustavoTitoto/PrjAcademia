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
import model.Treino;

/**
 *
 * @author User
 */
public class TreinoDao {
    private Connection connection;

    public TreinoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }
    public List getListaTreino() throws SQLException {
        String sql = "select * from treino";        
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Treino> listaTreino = new ArrayList<Treino>();        
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                //Pegando Dados do Treino
                Treino treino = new Treino();
                //lembrar que tem que ser na ordem do banco de dados                
                treino.setTipo(rs.getString("tipo"));
                treino.setAparelhos(rs.getString("aparelho"));
                treino.setRepeticoes(rs.getString("repeticoes"));
                treino.setIntervalo(rs.getString("tempo_intervalo"));
                treino.setProfessor(rs.getString("nome_professor"));                
                treino.setAluno(rs.getString("nome_aluno"));
                
                                
                listaTreino.add(treino);                                
            }
            return listaTreino;
        } catch (SQLException ex) {
            Logger.getLogger(TreinoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //fechando conexões
            connection.close();
            ps.close();
            rs.close();
        }
        return null;
    }
    
    //exclui treino por enquanto deixa no nome mas dps tem uqe mudar para codigo ou login
    public boolean excluiTreino(Treino treino) throws SQLException{
        String sql = "delete from treino where nome_treino=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, treino.getTipo());            
            ps.execute();
            return true;            
        } catch (SQLException ex) {
            Logger.getLogger(TreinoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connection.close();
            ps.close();           
        }        
        return false;        
    }   
    //implementar todos os outros dados
    public void AlteraTreino(Treino treino) throws SQLException{
        String sql = "update treino SET nome_treino=?,usuario_treino=? where nome_treino=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            
            ps.execute();                        
        } catch (SQLException ex) {
            Logger.getLogger(TreinoDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connection.close();
            ps.close();           
        }       
               
    } 
}
