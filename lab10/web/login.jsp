<%--
  Created by IntelliJ IDEA.
  User: c
  Date: 10.06.2020
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Authorize</title>
</head>
<body bgcolor="#dda0dd">
<fieldset>
    <legend>Authorize</legend>
    <form action="Login" method="POST">
        <input name="login" type="text" placeholder="login"/>
        <input name="password" type="text" placeholder="password"/>
        <input type="submit" value="Войти"/>
    </form>
</fieldset>
<form action="GoToRegister" method="POST">
    <input type="submit" value="Регистрация"/>
</form>
</body>
</html>
