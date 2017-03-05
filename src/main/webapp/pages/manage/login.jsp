<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/4
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>经理登录</title>
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
        <form method="post" action="/manage/hotels">
            <div class="form-group has-feedback">
                <input name="mname" id="mname" type="text" class="form-control" placeholder="工号">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input name="mpassword" id="mpassword" type="password" class="form-control" placeholder="密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <input type="hidden" id="merror" name="merror">
                <div class="col-xs-offset-3 col-xs-6">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
            </div>
        </form>
    </div>

</div>

<script src="../../js/jquery-2.2.3.min.js"/>
<script src="../../js/bootstrap.js"/>
<script src="../../js/app.js"/>

</body>
</html>