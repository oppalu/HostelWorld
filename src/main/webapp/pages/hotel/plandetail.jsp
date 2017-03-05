<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/5
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>计划详情</title>
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

            <div class="user-panel">
                <div class="pull-left image">
                    <img src="../../img/avatar.png" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>南京松山湖宾馆</p>
                </div>
            </div>

            <form action="searchresult.html" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" id="inputsearch" name="inputsearch" class="form-control" placeholder="查找预订单">
                    <span class="input-group-btn">
                        <button type="submit" id="search-btn" class="btn btn-flat">
                            <i class="fa fa-search"></i>
                        </button>
                    </span>
                </div>
            </form>

            <!--下面不同的tab-->
            <ul class="sidebar-menu">
                <li class="header"></li>

                <li class="treeview">
                    <a href="hotelinfo.html">
                        <i class="glyphicon glyphicon-file"></i>
                        <span>酒店信息</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                </li>

                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-th"></i>
                        <span>房间信息</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="addroom.html"><i class="fa fa-circle-o"></i> 添加房间</a></li>
                        <li><a href="roominfo.html"><i class="fa fa-circle-o"></i> 房间状态</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="plan.html">
                        <i class="glyphicon glyphicon-file"></i>
                        <span>发布计划</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                </li>

                <li>
                    <a href="#">
                        <i class="glyphicon glyphicon-list"></i>
                        <span>入住登记</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="bookin.html"><i class="fa fa-circle-o"></i> 预约入住</a></li>
                        <li><a href="newin.html"><i class="fa fa-circle-o"></i> 到店入住</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="leave.html">
                        <i class="glyphicon glyphicon-file"></i>
                        <span>离店登记</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                </li>

                <li class="treeview">
                    <a href="analyse.html">
                        <i class="glyphicon glyphicon-file"></i>
                        <span>统计信息</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                </li>
            </ul>
        </section>
    </aside>

    <div class="content-wrapper">
        <section class="content-header"><h1>计划详情</h1></section>

        <section class="invoice">
            <div class="row">
                <div class="col-xs-12">
                    <h2 class="page-header">
                        计划编号P100001<span class="small label label-primary">审核中</span>
                        <small class="pull-right">生成日期:2017-03-01</small>
                    </h2>
                </div>
            </div>

            <div class="row invoice-info">
                <table class="table table-hover">
                    <tr>
                        <th>房间类型</th>
                        <th>价格</th>
                        <th>生效日期</th>
                        <th>失效日期</th>
                        <th>状态</th>
                    </tr>
                    <tr>
                        <td>标准间</td>
                        <td>200</td>
                        <td>2017-03-12</td>
                        <td>2017-03-13</td>
                        <td><span class="label label-warning">审核中</span></td>
                    </tr>
                    <tr>
                        <td>标准间</td>
                        <td>200</td>
                        <td>2017-03-12</td>
                        <td>2017-03-13</td>
                        <td><span class="label label-success">审核通过</span></td>
                    </tr>
                    <tr>
                        <td>标准间</td>
                        <td>200</td>
                        <td>2017-03-12</td>
                        <td>2017-03-13</td>
                        <td><span class="label label-danger">审核失败</span></td>
                    </tr>
                </table>
            </div>

        </section>
    </div>
</div>
<script src="../../js/jquery-2.2.3.min.js"></script>
<script src="../../js/bootstrap.js"></script>
<script src="../../js/app.js"></script>

</body>
</html>