<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/7
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>酒店详情</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <link rel="stylesheet" href="../../css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../../css/AdminLTE.css">
    <link rel="stylesheet" href="../../css/all-skins.css">
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div style="background-color: #ecf0f5">

    <jsp:include page="common/header.jsp"/>

    <section class="content-header"><h1>酒店详情</h1></section>

    <section class="content">
        <div class="row">
            <div class="col-md-3">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">酒店信息</h3>
                    </div>
                    <div class="box-body">
                        <strong><i class="fa fa-file-text-o margin-r-5"></i>名称</strong>
                        <p class="text-muted">${hotel.name}</p>
                        <hr>
                        <strong><i class="fa fa-map-marker margin-r-5"></i>地址</strong>
                        <p class="text-muted">${hotel.location}</p>
                        <hr>
                        <strong><i class="fa fa-file-text-o margin-r-5"></i> 联系电话</strong>
                        <p class="text-muted">${hotel.telephone}</p>
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <div class="box">
                    <div class="box-header with-border">
                        <h3 class="box-title">房间信息</h3>
                    </div>
                    <div class="box-body">
                        <table class="table table-bordered">
                            <tr>
                                <th>房型</th>
                                <th>床位数</th>
                                <th>价格</th>
                                <th>房间余量</th>
                                <th>预定</th>
                            </tr>
                            <c:forEach items="${type}" var="t" varStatus="loop">
                                <tr>
                                    <td>${t.name}</td>
                                    <td>${t.bednum}</td>
                                    <td>${t.price}</td>
                                    <td>${number[loop.count-1]}</td>
                                    <td><a class="btn btn-primary" href="/addOrder/${hotel.id}/${t.id}">预定</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!--row-->
    </section>
</div>
<script src="../../js/jquery-2.2.3.min.js"></script>
<script src="../../js/bootstrap.js"></script>
<script src="../../js/app.js"></script>


</body>
</html>
