<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/3
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
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
        <p class="login-msg">用户登录</p>
        <form method="post" action="/member/main" onsubmit="return mLog()">
            <div class="form-group">
                <input id="m" name="username" type="text" class="form-control" placeholder="会员名">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group">
                <input id="mp" name="password" type="password" class="form-control" placeholder="密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-7">
                    <a href="/member/register" class="text-center">没有账号?</a>
                </div>

                <div class="col-xs-5">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
            </div>
        </form>

    </div>
</div>

<script src="../../js/jquery-2.2.3.min.js"/>
<script src="../../js/bootstrap.js"/>
<script src="../../js/app.js"/>
<script type="text/javascript">

    function mLog() {
        var uname = document.getElementById("m").value;
        var upass = document.getElementById("mp").value;

        if(uname == null || upass == null) {
            alert("用户名或密码不能为空!");
            return false;
        }
    }

</script>

</body>
</html>