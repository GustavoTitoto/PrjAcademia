<%-- 
    Document   : mostraAluno
    Created on : 21/03/2017, 12:48:09
    Author     : User
--%>
<%@page import="model.Aluno"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>

<link rel="stylesheet" href="css/estilo.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>B&S</title>
<div id="todo">
    <c:import url="cabeçalho.jsp"/>
    <c:import url="nav.jsp"/>
    <div id="conteudo">
        <h1>Lista de Usuários</h1>
        <c:set var="contador" value="${0}"></c:set>
            <table>
                <tr>
                    <td>Nome</td><td>Usuario</td><td>Email</td><td>Endereço</td><td>Peso</td><td>Altura</td><td>Nivel</td><td colspan="2">Opções</td>            
                </tr>

            <c:forEach var="registroAluno" items="${sessaoListaAluno}">
                <tr>
                    <td>${registroAluno['nome']}</td>
                    <td>${registroAluno['usuario']}</td>
                    <td>${registroAluno['email']}</td>
                    <td>${registroAluno['endereco']}</td>
                    <td>${registroAluno['peso']}</td>
                    <td>${registroAluno['altura']}</td>
                    <td>${registroAluno['nivel']}</td>
                    <td><a href="AlterarAluno?aluno=${registroAluno['nome']}"><img src="imagens/36966.png" alt="" id="icone"/></a></td>                
                    <td><a href="ExcluirAluno?aluno=${registroAluno['nome']}"><img src="imagens/61848.png" alt="" id="icone"/></a></td>
                </tr>           
            </c:forEach>
            <tr><td colspan="9">Listando ${contador} regisros de Alunos </td></tr>
        </table>
    </div>
    <c:import url="footer.jsp"/>
</div>
