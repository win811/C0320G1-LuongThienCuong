<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Windows 10 Version 2
  Date: 6/11/2020
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Condiment Results</title>
</head>
<body>
    <h3>Your Choice :</h3>
    <c:forEach items="${condimentResults}" var="condiment">
        <span>${condiment}-</span>
    </c:forEach>
</body>
</html>
