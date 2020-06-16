<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Windows 10 Version 2
  Date: 6/7/2020
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary Translation</title>
</head>
<body>
    <h1>Translate by JSP</h1>
    <%
        Map<String, String> dic = new HashMap<>();
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");

        String search = request.getParameter("txtSearch").toLowerCase();

        String result = dic.get(search);
        if (result != null) {
            out.println("Word: " + search);
            out.println("Result: " + result);
        } else {
            out.println("Not found");
        }
    %>
</body>
</html>
