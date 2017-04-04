/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import dao.AlunoDao;
import model.Aluno;
import controler.Conecta_Banco;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "SalvaAluno", urlPatterns = {"/SalvaAluno"})
public class SalvaAluno extends HttpServlet {

    Conecta_Banco conexao = new Conecta_Banco();
    Connection resp;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nome, usuario, senha,email,endereco,sexo, mensagem;
        int idade;
        double peso,altura;
        
        
        nome = request.getParameter("txtNome");
        usuario = request.getParameter("txtUsuario");
        senha = request.getParameter("txtSenha");
        email = request.getParameter("txtEmail");
        endereco = request.getParameter("txtEndereco");
        idade = request.getParameter("intIdade");
        peso = request.getParameter("doublePeso");
        altura = request.getParameter("doubleAltura");        
        sexo = request.getParameter("txtGenero");
                       
                
        try {
            resp = conexao.conectaPostgre("academia");
            if (resp != null) {
                conexao.ExecutaSql("select * from usuario where nome='" + nome + "'");

                if (!conexao.resultset.first()) {
                    PreparedStatement pst = resp.prepareStatement("insert into usuario (nome, login, senha) values (?, ?, ?)");
                       
                    pst.setString(1, nome);
                    pst.setString(2, usuario);
                    pst.setString(3, senha);
                    pst.setString(4, email);
                    pst.setString(5, endereco);
                    pst.setString(6, idade);
                    pst.setString(7, peso);
                    pst.setString(8, altura);
                    pst.setString(9, dataDeNascimento);
                    pst.setString(10, sexo);
                    
                    pst.execute();
                    response.sendRedirect("gerenciaAluno.jsp");
                    /*aviso de sucesso de cadastro*/
                } else {
                    /*aviso de falha de cadastro*/

                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(SalvaAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
