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
            System.out.println(aluno.getUsuario());
            System.out.println(aluno.getSenha());
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {            
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
