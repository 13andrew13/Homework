<%--
  Created by IntelliJ IDEA.
  User: andrew
  Date: 28.12.17
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Facebook Login</title>
</head>
<body>
<div class="ph">
    <form id='regForm' action='/servlet/signUp' method='post'>
        <p>Continue as:</p>
        <div class="field">
            <div class="input"><label for="email">Email:</label><input type="text" name="email" value="<%=request.getAttribute("email")%>" id="email" /><p>${erEmail}</p></div>
        </div>

        <div class="field">
            <div class="input"><label for="name">Name:</label><input type="text" name="name" value="<%=request.getAttribute("name")%>" id="name" /><p>${erName}</p></div>
        </div>
        <p>Please enter password!!!</p>
        <div class="field">
            <div class="input"><label for="pass">Password:</label><input type="password" name="password" value="" id="pass" /><p>${erPass}</p></div>
        </div>

        <div class="field">
            <div class="input"><label for="repass">Re-password:</label><input type="password" name="re-password" value="" id="repass" /><p>${erRepass}</p></div>
        </div>

        <div class="submitt" >
            <button type="reset" class="res">Reset</button>
            <button type="submit" class="ent">Enter</button>
        </div>

    </form>
</div>

</body>
</html>
