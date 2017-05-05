<%-- 
    Document   : mostraTreino
    Created on : 21/03/2017, 12:47:56
    Author     : User
--%>

<link rel="stylesheet" href="css/estilo.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>B&S</title>
<div id="todo">
    <c:import url="cabeçalho.jsp"/>
    <c:import url="nav.jsp"/>
    <div id="conteudo">
        <h1>Lista de Treinos</h1>
        <%-- contador n está funcionando--%>
        <c:set var="contador" value="${0}"></c:set>
            <table>
                <tr>
                    <td>Tipo</td><td>aparelhos</td><td>repetições</td><td>intervalo</td><td>Professor</td><td>Aluno</td><td colspan="2">Opções</td>            
                </tr>

            <c:forEach var="registroTreino" items="${sessaoListaTreino}">
                <tr>
                    <td>${registroTreino['tipo']}</td>
                    <td>${registroTreino['aparelhos']}</td>
                    <td>${registroTreino['repeticoes']}</td>
                    <td>${registroTreino['intervalo']}</td>
                    <td>${registroTreino['professor']}</td>
                    <td>${registroTreino['aluno']}</td>                    
                    <td><a href="AlterarTreino?nome=${registroTreino['nome']}$usuario=${registroTreino['usuario']}"><img src="imagens/36966.png" alt="" id="icone"/></a></td>                
                    <td><a href="ExcluirTreino?nome=${registroTreino['nome']}"><img src="imagens/61848.png" alt="" id="icone"/></a></td>
                </tr>           
            </c:forEach>                
            <tr><td colspan="7">Listando ${contador} registros de Treinos </td></tr>
        </table>
    </div>
    <c:import url="footer.jsp"/>
</div>
