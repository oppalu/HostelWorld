<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/4
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>用户信息</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <link rel="stylesheet" href="../../css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../../css/AdminLTE.css">
    <link rel="stylesheet" href="../../css/all-skins.css">

</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <jsp:include page="common/header1.jsp"/>

    <div class="content-wrapper">
        <section class="content-header"><h1>个人信息</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#info" data-toggle="tab">基本信息</a></li>
                            <li><a href="#account" data-toggle="tab">账号安全</a></li>
                        </ul>

                        <div class="tab-content">
                            <!--个人信息tab界面-->
                            <div class="tab-pane active" id="info">
                                <form method="post" action="/member/updateinfo" class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-sm-offset-2 col-sm-2 control-label">用户编号</label>
                                        <div class="col-sm-3">
                                            <input type="text" id="userid" name="userid" value="${member.id}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-offset-2 col-sm-2 control-label">用户名</label>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="nick" name="nick" value="${member.nickname}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-offset-2 col-sm-2 control-label">真实姓名</label>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="username" name="username" value="${member.name}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-offset-2 col-sm-2 control-label">性别</label>
                                        <div class="col-sm-8">
                                            <select id="sex" name="sex">
                                                <option value="男">男</option>
                                                <option value="女">女</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-offset-2 col-sm-2 control-label">手机号</label>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="phone" name="phone" value="${member.phone}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-offset-2 col-sm-2 control-label">生日</label>
                                        <div class="col-sm-3">
                                            <input id="birth" name="birth" type="date" value="${member.birthday}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-offset-4 col-sm-8">
                                            <button type="submit" class="btn btn-danger">修改</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!--账号信息(密码)界面-->
                            <div class="tab-pane" id="account">
                                <div style="width: 50%" class="col-md-offset-2">
                                    <h4 class="col-sm-offset-2">修改密码</h4>
                                    <form method="post" action="/member/updatepass" onsubmit="return checkPass()" class="form-horizontal">
                                        <input type="hidden" name="userid" value="${member.id}">
                                        <div class="form-group">
                                            <label class="col-sm-offset-2 col-sm-4 control-label">当前密码</label>
                                            <div class="col-sm-6">
                                                <input type="password" class="form-control" id="current_pwd" name="current_pwd">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-offset-2 col-sm-4 control-label">新密码</label>
                                            <div class="col-sm-6">
                                                <input type="password" class="form-control" id="new_pwd" name="new_pwd">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-offset-2 col-sm-4 control-label">重复新密码</label>
                                            <div class="col-sm-6">
                                                <input type="password" class="form-control" id="repeat_pwd" name="repeat_pwd">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-offset-6 col-sm-4">
                                                <button type="submit" class="btn btn-danger">修改密码</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!--tab-content-->
                    </div>
                    <!--nav-tabs-custom-->
                </div>
                <!--col-->
            </div>
            <!--row-->
        </section>
    </div>
</div>

<script src="../../js/jquery-2.2.3.min.js"></script>
<script src="../../js/bootstrap.js"></script>
<script src="../../js/app.js"></script>
<script type="text/javascript">
    function setImagePreview() {
        var docObj = document.getElementById("file");
        var preview = document.getElementById("userimage");
        preview.src = window.URL.createObjectURL(docObj.files[0]);
    }

    function checkPass() {
        var current = document.getElementById("current_pwd").value;
        var pass1 = document.getElementById("new_pwd").value;
        var pass2 = document.getElementById("repeat_pwd").value;

        if(pass1 != pass2) {
            alert("两次新密码输入不一致!");
            return false;
        }

        if(current != ${member.password}) {
            alert("原密码输入有误!");
            return false;
        }
    }

</script>
</body>
</html>
