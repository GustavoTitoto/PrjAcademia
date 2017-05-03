<%-- 
    Document   : index
    Created on : 20/03/2017, 12:11:40
    Author     : User
--%>

<%@taglib tagdir="/WEB-INF/tags" prefix="tag"%>


<title>B&S</title>
<link rel="stylesheet" href="css/estilo.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tag:verificaSessao/>

<div id="todo">
    <c:import url="cabeçalho.jsp"/> 
    <c:import url="nav.jsp"/> 
    <c:import url="conteudo.jsp"/>
    <c:import url="footer.jsp"/>
</div>