<%--
  Created by IntelliJ IDEA.
  User: Chen
  Date: 2020/7/30
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

    <script>
        window.onload = function (ev) {
            document.getElementById("img").onclick = function (ev1) {
                this.src = "/day09_cookie_war_exploded/checkCodeServlet?time=" + new Date().getTime();
            }
        }
    </script>

    <style>
        div{
            color: red;
        }
    </style>

</head>
<body>

<form action="/day09_cookie_war_exploded/loginServlet" method="post" >
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="/checkCodeServlet"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登陆"></td>
        </tr>
    </table>
</form>

<div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%></div>
<div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%></div>

</body>
</html>
