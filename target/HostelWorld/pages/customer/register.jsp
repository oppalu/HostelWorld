<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/3
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="../../css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../../css/AdminLTE.css">
    <link rel="stylesheet" href="../../css/all-skins.css">
</head>

<body background="../../img/index.jpeg" class="hold-transition skin-blue sidebar-mini">
<div class="login-box">
    <div class="login-logo">
        <a><b>Awesome</b>inns</a>
    </div>

    <div class="login-box-body">
        <p class="login-msg">注册账号</p>
        <form action="/member/info" method="post" onsubmit="return mRegister()">
            <div class="form-group has-feedback">
                <input id="nick" name="nickname" type="text" class="form-control" placeholder="会员名">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input id="name" name="username" type="text" class="form-control" placeholder="姓名">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input id="pass" name="password" type="password" class="form-control" placeholder="密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input name="phone" type="text" class="form-control" placeholder="手机号">
                <span class="glyphicon glyphicon-phone form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <select id="sex" name="sex">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
                <span class="glyphicon glyphicon-heart form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input name="birth" type="date" class="form-control" placeholder="生日">
                <span class="glyphicon glyphicon-calendar form-control-feedback"></span>
            </div>
            <br>
            <br>
            <div class="row">
                <div class="col-xs-6">
                    已有账号?&nbsp;
                    <a href="/member/login" class="text-center">[登录]</a>
                </div>
                <div class="col-xs-6">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">注册</button>
                </div>
            </div>
        </form>
    </div>

</div>

<script src="../../js/jquery-2.2.3.min.js"/>
<script src="../../js/bootstrap.js"/>
<script src="../../js/app.js"/>

<%--<script type="text/javascript">--%>

    <%--function mRegister() {--%>
        <%--var nick = document.getElementById("nick").value;--%>
        <%--var name = document.getElementById("name").value;--%>
        <%--var pass = document.getElementById("pass").value;--%>

        <%--if(name == "" || pass == "" || nick == "") {--%>
            <%--alert("用户名、姓名与密码不能有空项!");--%>
            <%--return false;--%>
        <%--}--%>
    <%--}--%>
<%--</script>--%>

</body>
</html>
