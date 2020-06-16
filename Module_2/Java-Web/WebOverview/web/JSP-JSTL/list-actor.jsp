

<%--
  Created by IntelliJ IDEA.
  User: Windows 10 Version 2
  Date: 6/7/2020
  Time: 7:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<html>
<head>
    <title>List Actor</title>
    <style>
        .table1 img {
            height: auto;
            width: auto;
            max-width: 400px;
            max-height: 400px;
        }
    </style>
</head>
<body>
    <h2>List Of Actor</h2>
    <table class="table1" border="1" cellspacing="0" width="1055">
        <tr>
            <th>Name</th>
            <th width="10%">Age</th>
            <th width="10%">Nation</th>
            <th>Description</th>
            <th>Image</th>
        </tr>
        <c:forEach items="${list_actor}" var="actress">
            <tr>
                <td>${actress.getName()}</td>
                <td>${actress.getAge()}</td>
                <td>${actress.getNation()}</td>
                <td>${actress.getDescription()}</td>
                <td width="400"><img src = "JSP-JSTL/Image-Actor/${actress.getImage()}" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
