<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/7
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>预约信息</title>
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
                            <h3 class="box-title">预约单信息</h3>
                        </div>

                        <form method="get" action="/checkin/${order.id}">
                            <div class="box-body">
                                <div class="form-group">
                                    <label class="col-sm-offset-1 col-sm-2 control-label">房间类型</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" name="type" value="${typename}">
                                    </div>
                                    <label class="col-sm-2 control-label">房间号</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" name="room" value="${order.roomname}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-offset-1 col-sm-2 control-label">入住日期</label>
                                    <div class="col-sm-3">
                                        <input type="date" class="form-control pull-right" id="datein" value="${order.begintime}">
                                    </div>
                                    <label class="col-sm-2 control-label">离店日期</label>
                                    <div class="col-sm-3">
                                        <input type="date" class="form-control pull-right" id="dateout" value="${order.endtime}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-offset-3 col-sm-2 control-label">联系方式</label>
                                    <div class="col-sm-4">
                                        <input type="hidden" name="orderid" value="${order.id}">
                                        <input type="text" class="form-control pull-right" id="phone" value="${order.phone}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block btn-flat">办理入住</button>
                                </div>
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
