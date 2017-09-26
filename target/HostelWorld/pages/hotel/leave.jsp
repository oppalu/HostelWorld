<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/8
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>离店登记</title>
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
        <section class="content-header"><h1>入住单</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-default">
                        <table class="table table-hover">
                            <tr>
                                <th>订单编号</th>
                                <th>房型</th>
                                <th>房间号</th>
                                <th>入住日期</th>
                                <th>退房日期</th>
                                <th>总房价</th>
                                <th>联系电话</th>
                            </tr>
                            <c:forEach items="${list}" var="l" varStatus="loop">
                                <tr>
                                    <td><a href="/checkout/${l.id}">${l.id}</a></td>
                                    <td>${typename[loop.count-1]}</td>
                                    <td>${l.roomname}</td>
                                    <td>${l.begintime}</td>
                                    <td>${l.endtime}</td>
                                    <td>${l.price}</td>
                                    <td>${l.phone}</td>
                                </tr>
                            </c:forEach>
                        </table>
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
