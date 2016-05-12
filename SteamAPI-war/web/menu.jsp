<%-- 
    Document   : menu
    Created on : 11/05/2016, 17:56:24
    Author     : Rafael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
              <nav class="Menu">
            <ul>
                <a href="index.jsp"><li class="${menu.equals('home')?'selecionado':''}">Home</li></a>
                
                <li class="${menu.equals('pagina2')?'selecionado':''}">Página 2</li>
                <c:choose>
                    <c:when test="${user==null}">
                        <a href="login.jsp"><li class="${menu.equals('login')?'selecionado':''}"  >Login</li></a>
                    </c:when>
                    <c:otherwise>
                        <a href="pagina1.jsp"><li class="${menu.equals('pagina1')?'selecionado':''}">Página 1</li></a>
                        <a href="FrontController?command=Usuario&action=logout"><li >Logout</li></a>
                    </c:otherwise>
                </c:choose>
                
            </ul>
    </body>
</html>
