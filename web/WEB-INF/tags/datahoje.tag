<%-- 
    Document   : mensagemLogin
    Created on : 27/03/2017, 12:33:49
    Author     : User
--%>
<%@tag body-content="empty" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="dataatual" class="java.util.Date"/>
<b><fmt:formatDate value="${dataatual}" pattern="dd/MM/yyyy" type="date"/></b>

<%-- 
    
<br><b><fmt:formatDate value="${dataatual}" dateStyle="long" type="date"/></b>
--%>