<%--
  Created by IntelliJ IDEA.
  User: Windows 10 Version 2
  Date: 6/6/2020
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
    <h2>Currency Converter</h2>
    <form method="post" action="../JSP-JSTL/currency-converter-by-jsp.jsp" >
        <label>Rate: </label><br/>
        <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
        <label>USD: </label><br/>
        <input type="text" name="usd" placeholder="USD" value="0"/><br/>
        <input type = "submit" id = "submit" value = "Converter"/>
    </form>
</body>
</html>