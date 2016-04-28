<%-- 
    Document   : Login
    Created on : 28/04/2016, 09:32:01
    Author     : 41411803
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Steam_user</title>
    </head>
    <body>
        
        <form method="POST" action="FrontController">
        <h1>Login usuário Steam:</h1>
        <p><input type="text" name="nome" placeholder="nome"/></p>
        <p><input type="password" name="password" placeholder="password"/></p>
        <p><input type="checkbox" name="Lembrar"/>Lembrar nome e senha</p>
        <p><input type="submit" value="LOGIN"</p>
        <input type="hidden" name="command" value="Usuario"/>
        <input type="hidden" name="action" value="Login"/>
        </form>
        
        <p><h1>Ou criar novo usuário:</h1></p>
        
        <form>
            <p><input type="text" name="nome" placeholder="nome usuário" required="required"/>*</p>
            <p><input type="password" name="pwd1" placeholder="Senha" required="required"/>*</p>
            <p><input type="password" name="pwd2" placeholder="Confirmar Senha" required="required"/>*</p>
            <p><input type="email" name="email" placeholder="email" required="required"/>*</p>
            <input type="hidden" name="command" value="Usuario"/>
            <input type="hidden" name="action" value="Registrar"/>
            <p><input type="submit" value="CADASTRAR"</p>         
        </form>
        
    </body>
</html>
