<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Sign In</title>
    <link href="/style/reg.css" rel="stylesheet"/>
</head>

<body>
<div class="ph">
    <form id='regForm' action='/servlet/signUp' method='post'>
        <div class="field">
            <div class="input"><label for="email">Email:</label><input type="text" name="email" value="${email eq ''?'':email}" id="email" /><p>${erEmail}</p></div>
        </div>

        <div class="field">
            <div class="input"><label for="name">Name:</label><input type="text" name="name" value="${name eq ''?'':name}" id="name" /><p>${erName}</p></div>
        </div>

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
    <div style="margin: auto; ">
        <a href="/servlet/facebookLogin">Login Facebook </a>
    </div>
</div>
</body>
</html>