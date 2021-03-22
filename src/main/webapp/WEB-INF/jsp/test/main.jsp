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

<p>登录成功</p>
你的用户名为：<p>${userName}</p>
你的密码为：<p>${password}</p>
<a href="login" onclick="Logout">退出</a>


</body>
</html>