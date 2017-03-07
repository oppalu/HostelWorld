<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/7
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>下预定单</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <link rel="stylesheet" href="../../css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../../css/AdminLTE.css">
    <link rel="stylesheet" href="../../css/all-skins.css">
</head>
<%
    String begin = (String)session.getAttribute("datein");
    String end = (String)session.getAttribute("dateout");
%>

<body class="hold-transition skin-blue sidebar-mini">
<div style="background-color: #ecf0f5">

    <jsp:include page="common/header.jsp"/>

    <section class="content-header"><h1>填写预订信息</h1></section>

    <section class="content">
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">预订单</h3>
            </div>
            <form role="form" method="post" action="/submitOrder">
                <div class="box-body">
                    <div class="form-group">
                        <label for="hotel">宾馆名称</label>
                        <input type="hidden" class="form-control" name="hotelid" value="${hotel.id}">
                        <input type="text" class="form-control" name="hotel" id="hotel" value="${hotel.name}">
                    </div>
                    <div class="form-group">
                        <label for="roomtype">房间类型</label>
                        <input type="hidden" class="form-control" name="roomid" value="${room.id}">
                        <input type="text" class="form-control" id="roomtype" value="${room.typename}">
                    </div>

                    <div class="form-group">
                        <label for="datein">入住日期:</label>
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="date" class="form-control pull-right" id="datein" value="<%=begin%>">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="dateout">离店日期:</label>
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="date" class="form-control pull-right" id="dateout" value="<%=end%>">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="phone">联系方式</label>
                        <input type="text" class="form-control" id="phone" name="phone">
                    </div>
                </div>

                <div class="box-footer">
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
            </form>
        </div>
    </section>
</div>
<script src="../../js/jquery-2.2.3.min.js"></script>
<script src="../../js/bootstrap.js"></script>
<script src="../../js/app.js"></script>


</body>
</html>
