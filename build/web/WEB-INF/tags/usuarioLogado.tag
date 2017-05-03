<%-- 
    Document   : mensagemLogin
    Created on : 27/03/2017, 12:33:49
    Author     : User
--%>
<%@tag body-content="empty" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${sessaoUsuario !=null}">
        Usuário logado: ${sessaoUsuario}        
    </c:when>
    <c:otherwise>
        Usuário não logado!
    </c:otherwise>
    
</c:choose>