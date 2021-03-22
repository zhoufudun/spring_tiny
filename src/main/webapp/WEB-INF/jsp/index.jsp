<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>主界面</title>
</head>
<body>



<script>
    function Logout() {
        <%
        session.invalidate();
        %>


    }
</script>
<form id="login" name="login" method ="post"  action="/test/login.htm">
    <p>用户名：<input id="userName" name="userName" type="text" /></p>  <!--用户名文本框-->
    <p>密　码：<input id="password" name="password" type="text" /></p>                     <!--密码文本框-->
    <p><button id="subLogin"  name ="subLogin" type="submit" value="提交" >提交</button></p><!--提交按钮-->
</form>


</body>
</html>