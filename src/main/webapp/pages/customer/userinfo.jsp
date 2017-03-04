<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/4
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <header class="main-header">
        <a href="index.html" class="logo">
            <span class="logo-lg"><b>Awesome</b>inns</span>
        </a>
        <nav class="navbar navbar-static-top">

            <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="main.html">酒店预订</a></li>
                </ul>
            </div>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="../../img/avatar.png" class="user-image" alt="User Image">
                            <span class="hidden-xs">Jessica</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="user-header">
                                <img src="../../img/avatar.png" class="img-circle" alt="User Image">
                                <p>Jessica</p>
                            </li>
                            <li class="user-body">
                                <div class="row">
                                    <div class="col-xs-6 text-center">
                                        <a href="userorder.html">我的订单</a>
                                    </div>
                                    <div class="col-xs-6 text-center">
                                        <a href="membercard.html">我的会员卡</a>
                                    </div>
                                </div>
                            </li>
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">我的信息</a>
                                </div>
                                <div class="pull-right">
                                    <a href="login.html" class="btn btn-default btn-flat">退出</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <aside class="main-sidebar">
        <section class="sidebar">
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="../../img/avatar.png" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>Jessica</p>
                </div>
            </div>

            <!--下面不同的tab-->
            <ul class="sidebar-menu">
                <li class="header"></li>

                <li class="treeview">
                    <a href="#">
                        <i class="glyphicon glyphicon-file"></i>
                        <span>个人信息</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                </li>

                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-th"></i>
                        <span>我的订单</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="userorder.html"><i class="fa fa-circle-o"></i> 所有订单</a></li>
                        <li><a href="useranalyse.html"><i class="fa fa-circle-o"></i> 历史数据统计</a></li>
                    </ul>
                </li>

                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-list"></i>
                        <span>账户管理</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="membercard.html"><i class="fa fa-circle-o"></i> 我的会员卡</a></li>
                        <li><a href="bankcard.html"><i class="fa fa-circle-o"></i> 我的银行卡</a></li>
                        <li><a href="point.html"><i class="fa fa-circle-o"></i> 我的积分</a></li>
                    </ul>
                </li>
            </ul>
        </section>
    </aside>

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
                                <form method="post" action="#" enctype="multipart/form-data" class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-sm-offset-2 col-sm-2 control-label">头像</label>
                                        <div class="col-sm-2 pull-left image">
                                            <img class="img-circle" id="userimage" name="userimage" width="70%" height="70%" style="diplay:none" />
                                        </div>
                                        <br>
                                        <div class="col-sm-4">
                                            <input type="file" id="file" name="file" id="file" onchange="setImagePreview()">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-offset-2 col-sm-2 control-label">用户名</label>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="nickname" name="user_name" placeholder="用户名">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-offset-2 col-sm-2 control-label">真实姓名</label>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="user_name" name="user_name" placeholder="姓名">
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
                                            <input type="text" class="form-control" id="phone" name="user_name" placeholder="手机号">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-offset-2 col-sm-2 control-label">生日</label>
                                        <div class="col-sm-3">
                                            <input id="birth" name="birth" type="date">
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
                                    <form method="post" action="#" class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-sm-offset-2 col-sm-4 control-label">当前密码</label>
                                            <div class="col-sm-6">
                                                <input type="password" class="form-control" name="current_pwd">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-offset-2 col-sm-4 control-label">新密码</label>
                                            <div class="col-sm-6">
                                                <input type="password" class="form-control" name="new_pwd">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-offset-2 col-sm-4 control-label">重复新密码</label>
                                            <div class="col-sm-6">
                                                <input type="password" class="form-control" name="repeat_pwd">
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
</script>
</body>
</html>
