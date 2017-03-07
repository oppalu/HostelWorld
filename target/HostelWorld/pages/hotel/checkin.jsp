<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/8
  Time: 00:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>新建入住单</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <link rel="stylesheet" href="../../css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../../css/AdminLTE.css">
    <link rel="stylesheet" href="../../css/all-skins.css">
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <jsp:include page="common/header.jsp"/>

    <div class="content-wrapper">
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">新建入住单</h3>
                        </div>

                        <form method="post" action="/checkin">
                            <div class="box-body">
                                <div class="row">
                                    <div class="form-group">
                                        <label class="col-sm-offset-1 col-sm-2 control-label">房间类型</label>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" value="${typename}">
                                        </div>
                                        <label class="col-sm-2 control-label">房间号</label>
                                        <div class="col-sm-3">
                                            <input type="hidden" name="orderid" value="${order.id}">
                                            <input type="text" class="form-control" value="${order.roomname}">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-offset-1 col-sm-2 control-label">入住日期</label>
                                        <div class="col-sm-3">
                                            <input type="date" class="form-control pull-right" value="${order.begintime}">
                                        </div>
                                        <label class="col-sm-2 control-label">离店日期</label>
                                        <div class="col-sm-3">
                                            <input type="date" class="form-control pull-right" value="${order.endtime}">
                                        </div>
                                    </div>
                                </div>

                                <hr>

                                <div class="row">
                                    <div class="form-group">
                                        <label class="col-sm-offset-1 col-sm-2 control-label">客人1姓名</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" name="name1">
                                        </div>
                                        <label class="col-sm-2 control-label">证件号码</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="id1">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-offset-1 col-sm-2 control-label">客人2姓名</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" name="name2">
                                        </div>
                                        <label class="col-sm-2 control-label">证件号码</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" name="id2">
                                        </div>
                                    </div>
                                </div>

                                <hr>

                                <div class="row">
                                    <div class="col-xs-6">
                                        <p  style="margin-top: 5px;">
                                            <strong>联系方式:</strong>
                                            <input type="text" class="form-control" name="phone" value="${order.phone}">
                                            <br>
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
                                                    <th>会员编号</th>
                                                    <td><input type="text" class="form-control" name="vip" value="${order.membercard}"></td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block btn-flat">确定</button>
                            </div>
                        </form>
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
