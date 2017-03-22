/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import controler.Conecta_Banco;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
        
        String nome, usuario, senha, achaUsuario;
        achaUsuario = "nenhum";
        nome = request.getParameter("txtNome");
        usuario = request.getParameter("txtUsuario");
        senha = request.getParameter("txtsenha");
        try {
            resp = conexao.conectaPostgre("academia");
            if(resp != null){
                conexao.ExecutaSql("select * from usuario where nome='"+nome+"'");
                conexao.resultset.first();
                achaUsuario = conexao.resultset.getString("nome");
                       
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalvaAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SalvaAluno</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Nome:" + nome + " usu:" + usuario + " senha:" + senha + " acha usuuu:" +achaUsuario+"</h1>");
            out.println("</body>");
            out.println("</html>");
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
