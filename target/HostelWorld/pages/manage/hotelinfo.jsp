<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/5
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <title>酒店信息</title>
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
                        <li><a href="/manage/hotels"><i class="fa fa-circle-o"></i> 酒店信息修改</a></li>
                        <li><a href="plan.html"><i class="fa fa-circle-o"></i> 酒店计划</a></li>
                    </ul>
                </li>

                <li class="treeview">
                    <a href="balance.html">
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
        <section class="content-header"><h1>酒店基本信息</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <form name="myform" method="post" enctype="multipart/form-data" class="form-horizontal">

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">酒店名称</label>
                            <div class="col-sm-3">
                                <label class="control-label">${hotel.name}</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">所在城市</label>
                            <div class="col-sm-3">
                                <label class="control-label">${hotel.city}</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">具体地址</label>
                            <div class="col-sm-3">
                                <label class="control-label">${hotel.location}</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">酒店电话</label>
                            <div class="col-sm-3">
                                <label class="control-label">${hotel.telephone}</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">银行账户</label>
                            <div class="col-sm-3">
                                <label class="control-label">${hotel.bankid}</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">开业时间</label>
                            <div class="col-sm-3">
                                <label class="control-label">2017-03-01</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-2">
                                <input class="btn btn-success" type="button" value="审批通过" onclick="yesAction()">
                            </div>
                            <div class="col-sm-2">
                                <input class="btn btn-danger" type="button" value="审批不通过" onclick="noAction()">
                            </div>
                        </div>
                    </form>
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
    function yesAction(){
        document.myform.action="/stateok/${hotel.id}";
        document.myform.submit();
    }
    function noAction(){
        document.myform.action="/stateno/${hotel.id}";
        document.myform.submit();
    }
</script>

</body>
</html>
