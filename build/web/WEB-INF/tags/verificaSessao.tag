<%-- 
    Document   : mensagemLogin
    Created on : 27/03/2017, 12:33:49
    Author     : User
--%>
<%@tag body-content="empty" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    if(session.getAttribute("sessaoUsuario")== null){
        response.sendRedirect("login.jsp");
    }
%>