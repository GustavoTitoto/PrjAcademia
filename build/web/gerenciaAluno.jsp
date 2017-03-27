<%-- 
    Document   : cadastroAluno
    Created on : 21/03/2017, 12:42:26
    Author     : User
--%>

<link rel="stylesheet" href="css/estilo.css">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tagsTest"%>
<title>B&S</title>
<div id="todo">
    <c:import url="cabeçalho.jsp"/>
    <c:import url="nav.jsp"/>
    <div id="conteudo">
     <h1>Local onde vai possuir formulario de aluno.</h1>
     <form id="formAluno" action="./SalvaAluno">
         <h3>Nome</h3> <input type="text" name="txtNome" value="" id="txtNome"/>
        <h3>Usuario</h3> <input type="text" name="txtUsuario" value="" id="txtUsuario"/>
        <h3>Senha</h3> <input type="text" name="txtSenha" value="" id="txtSenha"/><br>  
        <%-- <tagsTest:mensagemLogin/>--%>
        <input type="submit" name="btnGravar" value="Gravar"/>
        <input type="submit" name="btnEditar" value="Editar"/>
        <input type="submit" name="btnExcluir" value="Excluir"/>
     </form>   
    </div>
    <c:import url="footer.jsp"/>
</div>