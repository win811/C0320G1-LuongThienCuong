<%--
  Created by IntelliJ IDEA.
  User: Windows 10 Version 2
  Date: 6/11/2020
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <h1>Calculator</h1>
    <form method="get" action="/calculator" >
        <input type="text" name="firstNumber" placeholder="Enter First Number" value="${firstNumber}">
        <input type="text" name="secondNumber" placeholder="Enter Second Number" value="${secondNumber}"> <br><br>
        <input type="submit" name="button" value="Addition(+)">
        <input type="submit" name="button" value="Subtraction(-)">
        <input type="submit" name="button" value="Multiplication(x)">
        <input type="submit" name="button" value="Division(/)">
    </form>
    <h2>Result :</h2>
    <c:if  test="${resultCalculator != null}">
    <span>${resultCalculator}</span>
    </c:if>
</body>
</html>
