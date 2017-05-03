/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ConnectionFactory {

    String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://localhost:5432/academia";
    private String usuario = "postgres";
    private String senha = "856321";

    public Connection getConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, usuario, senha);            
        } catch (SQLException erro) {            
            throw new RuntimeException(erro);
        } catch (ClassNotFoundException erro) {
            throw new RuntimeException(erro);
        }
    }

}
