<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/5
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>申请开店</title>
    <link rel="stylesheet" href="../../css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../../css/AdminLTE.css">
    <link rel="stylesheet" href="../../css/all-skins.css">
</head>

<body background="../../img/index.jpeg" class="hold-transition skin-blue sidebar-mini">
<div class="login-box">
    <div class="login-logo">
        <a>酒店后台管理</a>
    </div>

    <div class="login-box-body">
        <p class="login-msg">申请开店</p>
        <form action="/hotel/info" method="post" onsubmit="return hLogin()">
            <div class="form-group has-feedback">
                <input id="name" name="name" type="text" class="form-control" placeholder="酒店名称">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input id="pass" name="password" type="password" class="form-control" placeholder="密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input id="city" name="city" type="text" class="form-control" placeholder="所在城市">
                <span class="glyphicon glyphicon-home form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input id="location" name="location" type="text" class="form-control" placeholder="地址">
                <span class="glyphicon glyphicon-map-marker form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input id="phone" name="phone" type="text" class="form-control" placeholder="酒店电话">
                <span class="glyphicon glyphicon-phone form-control-feedback"></span>
            </div>
            <br>
            <br>
            <div class="row">
                <div class="col-xs-6">
                    已有账号?&nbsp;
                    <a href="/hotel/login" class="text-center">[登录]</a>
                </div>
                <div class="col-xs-6">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">提交申请</button>
                </div>
            </div>
        </form>
    </div>

</div>

<script src="../../js/jquery-2.2.3.min.js"/>
<script src="../../js/bootstrap.js"/>
<script src="../../js/app.js"/>
<%--<script type="text/javascript">--%>

    <%--function hLogin() {--%>
        <%--var city = document.getElementById("city").value;--%>
        <%--var name = document.getElementById("name").value;--%>
        <%--var pass = document.getElementById("pass").value;--%>
        <%--var location = document.getElementById("location").value;--%>
        <%--var phone = document.getElementById("phone").value;--%>

        <%--if(name == "" || pass == "" || city == "" || location == "" || phone == "") {--%>
            <%--alert("所填项不能有空项!");--%>
            <%--return false;--%>
        <%--}--%>
    <%--}--%>
<%--</script>--%>

</body>
</html>
