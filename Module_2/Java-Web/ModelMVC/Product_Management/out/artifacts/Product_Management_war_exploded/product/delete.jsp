<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nhat
  Date: 4/20/18
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting customer</title>
</head>
<body>
    <h1>Delete Product</h1>
    <a href="/products">Back To Product List</a>
    <form method="post">
        <h3>Are you sure?</h3>
        <fieldset>
            <legend>Product Information</legend>
            <table>
                <tr>
                    <td>Name : </td>
                    <td>${product.getName()}</td>
                </tr>
                <tr>
                    <td>Description : </td>
                    <td>${product.getDescription()}</td>
                </tr>
                <tr>
                    <td>Manufacturer : </td>
                    <td>${product.getManufacturer()}</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Delete customer"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>