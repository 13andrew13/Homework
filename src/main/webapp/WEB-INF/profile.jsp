<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile</title>
    <link href="/style/profile.css" rel="stylesheet"/>
</head>

<body>
<div class="ph">
    <form id='regForm' action='/servlet/profile' method='post'>
        <div class="field">
            <div class="input"><label for="email">Email:</label>
                <input  type="text" readonly name="email" value="<c:out value="${user.email}"/>" id="email" />
                <input type="button" onclick="changeEmail()" class="redakt" value="Change">
            </div>
        </div>

        <div class="field">
            <div class="input"><label for="name">Name:</label>
                <input type="text" readonly name="name" value="<c:out value="${user.name}"/>" id="name" />
                <input type="button" onclick="changeName()" class="redakt" value="Change">
            </div>
        </div>
        <div class="submitt" >
            <div>
                <a href="/servlet/facebookLogin">FB</a>
            </div>
            <button type="submit" class="ent">Enter</button>
        </div>

    </form>
</div>
</body>
</html>

<script>
    function changeEmail(){
        document.getElementById('email').readOnly = false;
        document.getElementById('email').style.border = '0.1em solid black';
    }
    function changeName(){
        document.getElementById('name').readOnly = false;
        document.getElementById('name').style.border = '0.1em solid black';
    }
</script>