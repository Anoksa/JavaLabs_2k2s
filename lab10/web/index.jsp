<%--
  Created by IntelliJ IDEA.
  User: c
  Date: 10.06.2020
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Lab10</title>
  <style>
    .horizontal {
      display: inline-block;
      margin-right: 100px;
    }
  </style>
</head>

<body>
<div class="horizontal">
  <img src="https://i.pinimg.com/564x/3d/00/3f/3d003f7d68933ee38c0d8ae482dd5b29.jpg" style="margin: 10px; width: 200px; height: 200px">
  <form action="Time" method="GET">
    <input type="submit" value="Получить информацию">
  </form>
</div>

<div class="horizontal">
  <img src="https://i.pinimg.com/736x/26/b3/3b/26b33baecedee0a8bace0ab5a75f067d.jpg" style="margin: 10px; width: 200px; height: 200px">
  <form method="POST" action="GoToLogin">
    <input type="submit" value="Окно авторизации"/>
  </form>
</div>

<div class="horizontal">
  <form method="GET" action="FirstServlet">
    <input type="submit" value="6"/>
  </form>
  <form method="POST" action="FirstServlet">
    <input type="submit" value="6"/>
  </form>
</div>
</body>
</html>
