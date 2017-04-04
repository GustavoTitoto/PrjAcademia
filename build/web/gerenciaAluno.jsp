<%-- 
    Document   : cadastroAluno
    Created on : 21/03/2017, 12:42:26
    Author     : User
--%>

<link rel="stylesheet" href="css/estilo.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tagsTest"%>
<title>B&S</title>
<div id="todo">
    <c:import url="cabeçalho.jsp"/>
    <c:import url="nav.jsp"/>
    <div class="container">
        <div class="row">
            <h1> Cadastre-se</h1>
            <hr>
        </div>

        <div class="row" id="formAluno">
            <form action="./SalvaAluno">

                <div class="form-group">
                    <label for="nome_completo">Digite seu nome completo:</label>
                    <input type="text" class="form-control" name="txtNome" id="txtNome" required>
                </div>

                <div class="form-group">
                    <label for="nome_completo">Usuário:</label>
                    <input type="text" class="form-control" name="txtUsuario" id="txtUsuario" required>
                </div>

                <div class="form-group">
                    <label for="nome_completo">Senha:</label>
                    <input type="text" class="form-control" name="txtSenha" id="txtSenha" required>
                </div>

                <div class="form-group">
                    <label for="email">Informe seu e-mail:</label>
                    <input type="email" class="form-control" name="txtEmail" id="txtEmail" required>
                </div>

                <div class="form-group">
                    <label for="nome_completo">Endereço:</label>
                    <input type="text" class="form-control" name="txtEndereco" id="txtEndereco" required>
                </div>

                <div class="form-group">
                    <label for="idade">Informe sua idade:</label>
                    <input type="number" class="form-control" name="intIdade" id="intIdade" min="10" max="110" required>
                </div>                

                <div class="form-group">
                    <label for="nome_completo">Peso:</label>
                    <input type="text" class="form-control" name="doublePeso" id="doublePeso" required>
                </div>

                <div class="form-group">
                    <label for="nome_completo">Altura:</label>
                    <input type="text" class="form-control" name="doubleAltura" id="doubleAltura" required>
                </div>

                <div class="form-group">
                    <label for="data_pgto">Data de Nascimento:</label>
                    <input type="date" class="form-control" name="dateNascimento" id="dateNascimento" required>
                </div>

                <div class="form-group">
                    <label for="genero">Informe seu género sexual:</label><br/>
                    <input type="radio" name="txtGenero" value="masculino" id="txtGenero"> Masculino<br/>
                    <input type="radio" name="txtGenero" value="feminino" id="txtGenero"> Feminino
                </div>  

                <div class="form-group" align="center">
                    <button type="submit" class="btn btn-lg btn-success"> 
                        <span class="glyphicon glyphicon-ok" aria-hidden="true" value="Gravar"></span> Gravar
                    </button>                    
                </div>

            </form>
        </div>
    </div>

    <c:import url="footer.jsp"/>
</div>