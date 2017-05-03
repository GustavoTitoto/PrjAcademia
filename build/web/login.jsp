<%-- 
    Document   : login
    Created on : 02/05/2017, 08:55:26
    Author     : User
--%>
<link rel="stylesheet" href="css/estilo.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<title>Login</title>
<div id="todo">
<c:import url="cabeçalho.jsp"/>

<form action="ServletLogar" method="get">
    <table>
        <tr>
            <td colspan="2">Login</td>                       
        </tr>
        <tr>
            <td>Usuário:</td>
            <td><input type="text" name="usuario" id="usuario" autocomplete="on" required="true" placeholder="Usuário" autofocus></td>            
        </tr>
        <tr>
            <td>Senha:</td>
            <td><input type="password" name="senha" id="senha" autocomplete="on" required="true" placeholder="Senha"></td>            
        </tr>
        <tr>            
            <td><input type="reset" name="Limpar" id="btnLimpar"></td>
            <td><input type="submit" name="Acessar" id="btnEntrar"></td>            
        </tr>
        <tr>
            <td colspan="2"> <tag:mensagemLogin/> </td>                       
        </tr>
        
    </table>
    <c:import url="footer.jsp"/>
    
</form>


<c:import url="footer.jsp"/>
</div>