<%-- 
    Document   : login
    Created on : Oct 9, 2022, 5:57:31 PM
    Author     : tobys
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            Username: <<input type="text" name="username" value="${user.username}"><br>
            Password: <<input type="password" name="password" value=""><br>
            <input type="submit" value="Log in">
        </form>
    <c:if test="${invalidInput}">
        <p>Invalid entry.</p>
    </c:if>
    <c:if test="${logoutMessage}">
        <p>You have successfully logged out.</p>
    </c:if>
    </body>
</html>
