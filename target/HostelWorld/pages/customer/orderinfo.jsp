<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/7
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <title>订单详情</title>
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
        <section class="content-header"><h1>订单详情</h1></section>

        <section class="invoice">
            <div class="row">
                <div class="col-xs-12">
                    <h2 class="page-header">
                        订单号${order.id}<span class="small label label-primary">${order.status}</span>
                        <small class="pull-right">订单生成日期:${order.createtime}</small>
                    </h2>
                </div>
            </div>

            <div class="row invoice-info">
                <div class="col-sm-4 invoice-col">
                    <strong>${hotelinfo.name}</strong><br>
                    <br>
                    <address>
                        ${hotelinfo.location}<br>
                        <br>
                        酒店电话:${hotelinfo.telephone}
                    </address>
                </div>
                <!-- /.col -->
                <div class="col-sm-4 invoice-col">
                    <strong>房型:</strong>&nbsp;${type.name}<br>
                    <br>
                    <strong>床位数:</strong>&nbsp;${type.bednum}<br>
                    <br>
                </div>
                <!-- /.col -->
                <div class="col-sm-4 invoice-col">
                    <strong>联系方式:</strong>&nbsp;${order.phone}<br>
                    <br>
                    <strong>入住日期:</strong>&nbsp;${order.begintime}<br>
                    <br>
                    <strong>离店日期:</strong>&nbsp;${order.endtime}<br>
                    <br>
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
            <hr>
            <div class="row">
                <div class="col-xs-6">
                    <p class="lead">入住信息:</p>
                    <p  style="margin-top: 5px;">
                        <strong>入住人1:</strong>&nbsp;${order.user1}<br>
                        <br>
                    </p>
                    <p  style="margin-top: 10px;">
                        <strong>入住人2:</strong>&nbsp;${order.user2}<br>
                        <br>
                    </p>
                    <p  style="margin-top: 10px;">
                        <a href="/cancel/${order.id}">取消订单</a>
                    </p>
                </div>
                <!-- /.col -->
                <div class="col-xs-6">
                    <div class="table-responsive">
                        <table class="table">
                            <tr>
                                <th style="width:50%">总金额</th>
                                <td>${order.price}</td>
                            </tr>
                            <tr>
                                <th>会员卡编号</th>
                                <td>${order.membercard}</td>
                            </tr>
                            <tr>
                                <th>优惠:</th>
                                <td>${order.discount}</td>
                            </tr>
                            <tr>
                                <th>实付金额</th>
                                <td>${order.realprice}</td>
                            </tr>
                            <tr>
                                <th>付款方式</th>
                                <td>${order.paytype}</td>
                            </tr>
                        </table>
                    </div>
                </div>
                <!-- /.col -->
            </div>

        </section>
    </div>
</div>
<script src="../../js/jquery-2.2.3.min.js"></script>
<script src="../../js/bootstrap.js"></script>
<script src="../../js/app.js"></script>

</body>
</html>
