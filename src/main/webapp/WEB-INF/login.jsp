<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Sign Up</title>
    <link href="/style/log.css" rel="stylesheet"/>
</head>

<body>
<form id="loginForm" action="/servlet/login" method="post">

    <div class="field">
        <label>Enter your login:</label>
        <div class="input"><label>
            <input type="email" name="email" value=""/>
        </label></div>
    </div>

    <div class="field">
        <label>Enter your password:</label>
        <div class="input"><label>
            <input type="password" name="password"/>
        </label></div>
    </div>

    <div class="submit">
        <button type="submit">Enter</button>
    </div>
</form>
</body>
</html>