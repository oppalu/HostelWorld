<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/2/22
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>预定首页</title>
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

    <a href="../hotel/login.html" class="pull-right">酒店后台入口</a>

    <div class="login-box-body">

        <form method="post" action="#">
            <div class="form-group">
                <label>城市:</label>
                <div class="input-group">
                    <input type="text" class="form-control pull-right" id="city">
                </div>
            </div>

            <div class="form-group">
                <label>入住日期:</label>
                <div class="input-group date">
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                    <input type="date" class="form-control pull-right" id="datein">
                </div>
            </div>

            <div class="form-group">
                <label>离店日期:</label>
                <div class="input-group date">
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                    <input type="date" class="form-control pull-right" id="dateout">
                </div>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block btn-flat">查询</button>
            </div>
        </form>
    </div>
</div>

<script src="../../js/jquery-2.2.3.min.js"/>
<script src="../../js/bootstrap.js"/>
<script src="../../js/app.js"/>

</body>
</html>