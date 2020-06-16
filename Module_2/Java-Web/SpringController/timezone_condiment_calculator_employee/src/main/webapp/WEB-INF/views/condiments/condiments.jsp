<%--
  Created by IntelliJ IDEA.
  User: Windows 10 Version 2
  Date: 6/11/2020
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
    <form method="get" action="/condiment-results">
        <input type="checkbox" name="condiment" value="Lettuce">Lettuce
        <input type="checkbox" name="condiment" value="Tomato">Tomato
        <input type="checkbox" name="condiment" value="Mustard">Mustard
        <input type="checkbox" name="condiment" value="Sprouts">Sprouts
        <hr>
        <input type="submit" value="Save">
    </form>
</body>
</html>
