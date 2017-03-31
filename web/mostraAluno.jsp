<%-- 
    Document   : mostraAluno
    Created on : 21/03/2017, 12:48:09
    Author     : User
--%>
<%@page import="java.sql.Connection"%>
<%@page import="controler.Conecta_Banco"%>
<link rel="stylesheet" href="css/estilo.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>B&S</title>
<div id="todo">
    <c:import url="cabeçalho.jsp"/>
    <c:import url="nav.jsp"/>
    <div id="conteudo">
        <h1>Tabela com alunos</h1>
        <table border="1">
            <tr>
                <td>ID</td> 
                <td>Nome</td>
                <td>Usuario</td>
                <td>Senha</td>
                <td>Email</td>
                <td>Endereço</td>
                <td>Peso</td>
                <td>Altura</td>
                <td>Data de Nascimento</td>
                <td colspan="2">Opção</td>
                
            </tr>
            <%
                Conecta_Banco conexao = new Conecta_Banco();
                Connection resp;
                resp = conexao.conectaPostgre("academia");
                
                conexao.ExecutaSql("select * from aluno order by id_aluno");
                conexao.resultset.first();
            %>

            <tr>
                <%
                    do{
                    out.println("<tr>");
                    out.println("<td>"+conexao.resultset.getInt("id_aluno")+"</td>");
                    out.println("<td>"+conexao.resultset.getString("nome_aluno")+"</td>");
                    out.println("<td>"+conexao.resultset.getString("usuario_aluno")+"</td>");
                    out.println("<td>"+conexao.resultset.getString("senha_aluno")+"</td>");
                    out.println("<td>"+conexao.resultset.getString("email_aluno")+"</td>");
                    out.println("<td>"+conexao.resultset.getString("endereco_aluno")+"</td>");
                    out.println("<td>"+conexao.resultset.getDouble("peso_aluno")+"</td>");
                    out.println("<td>"+conexao.resultset.getDouble("altura_aluno")+"</td>");
                    out.println("<td>"+conexao.resultset.getDate("datadenascimento_aluno")+"</td>");
                    out.println("<td><input type='submit' value='Alterar' name='btnAlterar' /></td>");
                    out.println("<td><input type='submit' value='Excluir' name='btnExcluir' /></td>");
                    out.println("</tr>");
                    }while(conexao.resultset.next());
                %>                
            </tr>

        </table>


    </div>
    <c:import url="footer.jsp"/>
</div>
