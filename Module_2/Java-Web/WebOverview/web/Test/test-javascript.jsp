<%--
  Created by IntelliJ IDEA.
  User: Windows 10 Version 2
  Date: 6/6/2020
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <h2>JavaOverview.LoginServlet</h2>
    <input type="text" name="username" id="username" size="30" placeholder="username"/><br/>
    <input type="password" name="password" id="password" size="30" placeholder="password"/><br/>
    <input type="button" onclick="submit()" value="Sign in"/>
    <script>
        function submit() {
            let userName = document.getElementById("username").value;
            let passWord = document.getElementById("password").value;
            if (userName === "admin" && passWord === "admin") {
                document.write("Welcome " + userName);
            } else {
                document.write("Incorrect Account !");
            }
        }
    </script>
</body>
</html>
