<%-- 
    Document   : index
    Created on : 20/03/2017, 12:11:40
    Author     : User
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="controler.Conecta_Banco"%>

<link rel="stylesheet" href="css/estilo.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="todo">
    <c:import url="cabeçalho.jsp"/>
    <% Conecta_Banco conn = new Conecta_Banco();

        Connection conexao = conn.conectaPostgre("academia");

    %>

    <div id="conteudo">
        <div id="centraliza">
            <div id="formLogin">
                <form method="post" action="index.jsp">                
                    <p>Login <input class="campo" autofocus type="text" name="login" id="login" value="" placeholder="Usuário" required="true" autocomplete="on"></p>
                    <p>Senha <input class="campo" type="password" name="senha" id="senha" value="" placeholder="Senha" required="true"></p>
                        <%                    if (conexao != null) {
                                String login, senha;
                                login = request.getParameter("login");
                                senha = request.getParameter("senha");
                                Statement st;
                                ResultSet rs;
                                st = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
                                rs = st.executeQuery("select * from usuario where login='" + login + "'and senha='" + senha + "'");
                                if (rs.next()) {
                                    response.sendRedirect("principal.jsp");
                                }

                            } else {
                                out.println("não foi possivel logar");
                            }
                        %>

                    <!--                <p class="remember_me">
                                        <label>
                                            <input type="checkbox" name="remember_me" id="remember_me">
                                            Remember me on this computer
                                        </label>
                                    </p>-->
                    <input id="btn"type="submit" value="Logar">
                </form>  
            </div>
        </div>
    </div>
    <c:import url="footer.jsp"/>
</div>