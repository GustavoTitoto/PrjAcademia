<%-- 
    Document   : index
    Created on : 20/03/2017, 12:11:40
    Author     : User


<%@taglib tagdir="/WEB-INF/tags" prefix="tag"%>


<title>B&S</title>
<link rel="stylesheet" href="css/estilo.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

Para redirecionar os erros bugou o programa por isso tirei
<error-page>
        <exception-type>java.lang.Exeption</exception-type>
        <location>erro.jsp</location>
    </error-page>
    <error-page>
        <error-code>404</error-code>
        <location>erro.jsp</location>
    </error-page>

<div id="todo">
    <c:import url="cabeçalho.jsp"/> 
    <h1>Atenção o sistema apresentou um problema favor entrar em contato com o Administrador</h1> 
    <c:import url="footer.jsp"/>
</div>--%>