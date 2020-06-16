<%--
  Created by IntelliJ IDEA.
  User: Windows 10 Version 2
  Date: 6/7/2020
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <style>
        .calculate {
            width: 400px;
        }
        .calculate input,select {
            position: absolute;
            left: 150px;
        }
    </style>
</head>
<body>
<h1>Simple Calculator</h1>
<form class="calculate" method="post" >
    <fieldset>
        <legend>Calculator</legend>
        <label>First Operand :
            <input type="text" name="firstOperand" value="10"/>
        </label><br/>
        <label>Operator :
            <select name="operator">
                <option value="+">Addition</option>
                <option value="-">Subtraction</option>
                <option value="*">Multiplication</option>
                <option value="/">Division</option>
            </select>
        </label> <br/>
        <label>Second Operand :
            <input type="text" name="secondOperand" value="2"/>
        </label><br/>
        <input type="submit" value="Calculate"/>
    </fieldset>
</form>
</body>
</html>
