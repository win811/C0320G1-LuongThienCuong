<%--
  Created by IntelliJ IDEA.
  User: Windows 10 Version 2
  Date: 6/11/2020
  Time: 9:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create A New Employee</title>
</head>
<body>
    <h1>Enter Employee's Information</h1>
    <form:form method="post" action="/show_info" modelAttribute="employee">

        <fieldset>
            <legend>Employee's Information</legend>
            <table>
                <tr>
                    <td><label>Employee ID : </label></td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td><label>Employee's Name : </label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><label>Employee's Contact Number :</label></td>
                    <td><form:input path="contractNumber"/></td>
                </tr>
                <tr><input type="submit" value="Create" /></tr>
            </table>
        </fieldset>

    </form:form>
</body>
</html>
