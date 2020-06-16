<%--
  Created by IntelliJ IDEA.
  User: Windows 10 Version 2
  Date: 6/6/2020
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculator</title>
    <style>
        .productDescription,.productPrice,.discountPercent {
            margin-left: 100px;
        }
    </style>
</head>
<body>
    <h2>Product Discount Calculator</h2>
    <form method="post" action = "/display-discount" >
        <label>Product Description :</label>
        <input type="text" name="productDescription"/><br/>
        <label>Product Price :</label>
        <input type="text" name="productPrice"/><br/>
        <label>Discount Percent(%) :</label>
        <input type="text" name="discountPercent"/><br/>
        <input type="submit" value="Calculate">
    </form>
</body>
</html>
