<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/5
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>发布计划</title>
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
                    <label name="hname">${hotel.id}</label>
                </div>
                <div class="pull-left info">
                    <p>
                        <label name="hname">${hotel.name}</label>
                    </p>
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
                    <a href="/hotel/info">
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
                        <li><a href="/hotel/room"><i class="fa fa-circle-o"></i> 添加房间</a></li>
                        <li><a href="/hotel/showRooms"><i class="fa fa-circle-o"></i> 房间状态</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="#">
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
        <section class="content-header"><h1>发布计划</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-default">
                        <div class="nav-tabs-custom">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#type" data-toggle="tab">发布新计划</a></li>
                                <li><a href="#room" data-toggle="tab">查看历史计划</a></li>
                            </ul>

                            <div class="tab-content">
                                <div class="tab-pane active" id="type">
                                    <form method="post" action="#" class="form-horizontal">

                                        <div class="form-group">
                                            <label class="col-sm-offset-1 col-sm-3 control-label">生效日期:</label>
                                            <div class="col-sm-6 input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="date" class="form-control pull-right" id="starttime">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-offset-1 col-sm-3 control-label">失效日期:</label>
                                            <div class="col-sm-6 input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="date" class="form-control pull-right" id="endtime">
                                            </div>
                                        </div>

                                        <hr>

                                        <div class="form-group">
                                            <label class="col-sm-offset-1 col-sm-2 control-label">房间类型</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control" name="type1">
                                            </div>
                                            <label class="col-sm-2 control-label">房间价格</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control" name="price1">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-offset-1 col-sm-2 control-label">房间类型</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control" name="type2">
                                            </div>
                                            <label class="col-sm-2 control-label">房间价格</label>
                                            <div class="col-sm-3">
                                                <input type="text" class="form-control" name="price2">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-offset-6 col-sm-4">
                                                <button type="submit" class="btn btn-primary">发布</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>

                                <div class="tab-pane" id="room">
                                    <table class="table table-hover">
                                        <tr>
                                            <th>计划编号</th>
                                            <th>生成日期</th>
                                            <th>生效日期</th>
                                            <th>失效日期</th>
                                            <th>状态</th>
                                        </tr>
                                        <tr>
                                            <td><a href="plandetail.html"> P123456</a></td>
                                            <td>2017-03-01</td>
                                            <td>2017-03-12</td>
                                            <td>2017-03-13</td>
                                            <td><span class="label label-warning">审核中</span></td>
                                        </tr>
                                        <tr>
                                            <td><a href="plandetail.html"> P123456</a></td>
                                            <td>2017-03-01</td>
                                            <td>2017-03-12</td>
                                            <td>2017-03-13</td>
                                            <td><span class="label label-success">审核通过</span></td>
                                        </tr>
                                        <tr>
                                            <td><a href="plandetail.html"> P123456</a></td>
                                            <td>2017-03-01</td>
                                            <td>2017-03-12</td>
                                            <td>2017-03-13</td>
                                            <td><span class="label label-danger">审核失败</span></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <!--tab-content-->
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
