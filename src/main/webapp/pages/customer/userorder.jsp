<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/7
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <title>订单管理</title>
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
        <section class="content-header"><h1>订单管理</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#info" data-toggle="tab">未入住订单</a></li>
                            <li><a href="#account" data-toggle="tab">历史订单</a></li>
                        </ul>

                        <div class="tab-content">
                            <div class="tab-pane active" id="info">
                                <table class="table table-hover">
                                    <tr>
                                        <th>订单编号</th>
                                        <th>酒店名称/房型</th>
                                        <th>入住日期</th>
                                        <th>退房日期</th>
                                        <th>总房价</th>
                                        <th>订单状态</th>
                                    </tr>
                                    <c:forEach items="${unuse}" var="u" varStatus="loop">
                                        <tr>
                                            <td><a href="orderinfo.html">${u.id}</a></td>
                                            <td>${unname[loop.count-1]}/${untype[loop.count-1]}</td>
                                            <td>${u.begintime}</td>
                                            <td>${u.endtime}</td>
                                            <td>${u.price}元</td>
                                            <td><span class="label label-primary">${u.status}</span></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                            <!--账号信息(密码)界面-->
                            <div class="tab-pane" id="account">
                                <table class="table table-hover">
                                    <tr>
                                        <th>订单编号</th>
                                        <th>酒店名称/房型</th>
                                        <th>入住日期</th>
                                        <th>退房日期</th>
                                        <th>总房价</th>
                                        <th>订单状态</th>
                                    </tr>
                                    <c:forEach items="${all}" var="u" varStatus="loop">
                                        <tr>
                                            <td><a href="orderinfo.html">${u.id}</a></td>
                                            <td>${allname[loop.count-1]}/${alltype[loop.count-1]}</td>
                                            <td>${u.begintime}</td>
                                            <td>${u.endtime}</td>
                                            <td>${u.price}元</td>
                                            <td><span class="label label-primary">${u.status}</span></td>
                                        </tr>
                                    </c:forEach>
                                </table>
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


</body>
</html>
