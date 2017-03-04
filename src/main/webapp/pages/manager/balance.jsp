<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/4
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>结算</title>
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
        <a href="#" class="logo">
            <span class="logo-lg"><b>Awesome</b>inns</span>
        </a>
        <nav class="navbar navbar-static-top">

            <div class="collapse navbar-collapse pull-right" id="navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="login.html">退出</a></li>
                </ul>
            </div>
        </nav>
    </header>

    <aside class="main-sidebar">
        <section class="sidebar">

            <!--下面不同的tab-->
            <ul class="sidebar-menu">
                <li class="header"></li>

                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-th"></i>
                        <span>审批</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="openhotel.html"><i class="fa fa-circle-o"></i> 开店审批</a></li>
                        <li><a href="modify.html"><i class="fa fa-circle-o"></i> 酒店信息修改</a></li>
                        <li><a href="plan.html"><i class="fa fa-circle-o"></i> 酒店计划</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="#">
                        <i class="glyphicon glyphicon-file"></i>
                        <span>结算</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                </li>

                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-list"></i>
                        <span>统计信息</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="each_hotel.html"><i class="fa fa-circle-o"></i>各店情况</a></li>
                        <li><a href="member.html"><i class="fa fa-circle-o"></i> 会员消费情况</a></li>
                        <li><a href="finance.html"><i class="fa fa-circle-o"></i> 财务情况</a></li>
                    </ul>
                </li>
            </ul>
        </section>
    </aside>

    <div class="content-wrapper">
        <section class="content-header"><h1>结算</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-default">
                        <table class="table table-hover">
                            <tr>
                                <th>酒店名称</th>
                                <th>结算金额</th>
                                <th>银行账户</th>
                            </tr>
                            <tr>
                                <td>如家</td>
                                <td>20000</td>
                                <td>4920174819374028175</td>
                            </tr>
                            <tr>
                                <td>如家</td>
                                <td>20000</td>
                                <td>4920174819374028175</td>
                            </tr>
                            <tr>
                                <td>如家</td>
                                <td>20000</td>
                                <td>4920174819374028175</td>
                            </tr>
                        </table>
                        <div class="box box-footer">
                            <button class="col-sm-offset-4 col-sm-4 btn btn-primary" href="#">结算</button>
                        </div>

                    </div>
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

</body>
</html>