<%--
  Created by IntelliJ IDEA.
  User: Windows 10 Version 2
  Date: 6/11/2020
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Email Validate</h1>
    <h3 style="color:red">${message}</h3>
    <form action="validate" method="post">
        <input type="text" name="email"><br>
        <input type="submit" value="Validate">
    </form>
</body>
</html>
