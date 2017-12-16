<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 14.12.17
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<form id="login" action="/servlet/signUp" method="post">
    <div class="field">
        <label>Enter your name:</label>
        <div class="input"><input type="text" name="name"/></div>
    </div>

    <div class="field">
        <label>Enter your login:</label>
        <div class="input"><input type="text" name="email"/></div>
    </div>

    <div class="field">
        <a href="#" id="forgot">Forgot your password?</a>
        <label>Enter your password:</label>
        <div class="input"><input type="password" name="password"/></div>
    </div>

    <div class="submit">
        <button type="submit">Enter</button>
    </div>

</form>


</body>
</html>
