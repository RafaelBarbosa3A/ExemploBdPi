<%-- 
    Document   : tela
    Created on : Nov 8, 2017, 10:02:25 AM
    Author     : r.almeida.barbosa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>tela</title>
    </head>
    <body>
        
        <h1>capturing</h1>
        <form action="${pageContext.request.contextPath}/ServletTeste" method="post">
            name: <input type="text" name="nome" value="joãozinho"/>
            age: <input type="number" name="idade" value="15"/>
            <button type="submit">send</button>
        </form>
    </body>
</html>
