<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Windows 10 Version 2
  Date: 6/9/2020
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
    <h1>Edit Product</h1>
    <p>
        <c:if test='${message != null}'>
            <span class="message">${message}</span>
        </c:if>
    </p>
    <a href="/products">Back To Product List</a>
    <form method="post" >
        <fieldset>
            <legend>Product Information</legend>
            <table>
                <tr>
                    <td>Name : </td>
                    <td><input type="text" name="name" value="${product.getName()}"></td>
                </tr>
                <tr>
                    <td>Description : </td>
                    <td><input type="text" name="description" value="${product.getDescription()}"></td>
                </tr>
                <tr>
                    <td>Manufacturer : </td>
                    <td><input type="text" name="manufacturer" value="${product.getManufacturer()}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update Product"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
