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
        <h1>Login usuário Steam</h1>
        <p><input type="text" name="nome" placeholder="nome"/></p>
        <p><input type="password" name="password" placeholder="password"/></p>
        <p><input type="checkbox" name="Lembrar"/>Lembrar nome e senha</p>
        <p><input type="submit" value="Login"</p>
        <input type="hidden" name="command" value="Usuario"/>
        <input type="hidden" name="action" value="Login"/>
        </form>
    </body>
</html>
