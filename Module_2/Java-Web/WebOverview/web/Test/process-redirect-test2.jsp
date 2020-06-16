<%--
  Created by IntelliJ IDEA.
  User: Windows 10 Version 2
  Date: 6/7/2020
  Time: 12:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Process Redirect Test 2</title>
</head>
<body>
    <%
        String firstNumber = request.getParameter("firstNumber");
        String secondNumber = request.getParameter("secondNumber");
        Integer sum = (Integer) request.getAttribute("sum");
    %>
    <h2>First Number : <%=firstNumber%></h2>
    <h2>Second Number : <%=secondNumber%></h2>
    <h2>Sum : <%=sum%></h2>

</body>
</html>
