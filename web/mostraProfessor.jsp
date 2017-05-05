<%-- 
    Document   : mostraProfessor
    Created on : 21/03/2017, 12:48:21
    Author     : User
--%>
<link rel="stylesheet" href="css/estilo.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>B&S</title>
<div id="todo">
    <c:import url="cabeçalho.jsp"/>
    <c:import url="nav.jsp"/>
    <div id="conteudo">
        <h1>Lista de Professores</h1>
        <%-- contador n está funcionando--%>
        <c:set var="contador" value="${0}"></c:set>
            <table>
                <tr>
                    <td>Nome</td><td>Usuario</td><td>Email</td><td>Endereço</td><td>Nivel</td><td colspan="2">Opções</td>            
                </tr>

            <c:forEach var="registroProfessor" items="${sessaoListaProfessor}">
                <tr>
                    <td>${registroProfessor['nome']}</td>
                    <td>${registroProfessor['usuario']}</td>
                    <td>${registroProfessor['email']}</td>
                    <td>${registroProfessor['endereco']}</td>                                        
                    <td>${registroProfessor['nivel']}</td>
                    <td><a href="AlterarProfessor?nome=${registroProfessor['nome']}$usuario=${registroProfessor['usuario']}"><img src="imagens/36966.png" alt="" id="icone"/></a></td>                
                    <td><a href="ExcluirProfessor?nome=${registroProfessor['nome']}"><img src="imagens/61848.png" alt="" id="icone"/></a></td>
                </tr>           
            </c:forEach>                
            <tr><td colspan="7">Listando ${contador} registros de Professores </td></tr>
        </table>
    </div>
    <c:import url="footer.jsp"/>
</div>
