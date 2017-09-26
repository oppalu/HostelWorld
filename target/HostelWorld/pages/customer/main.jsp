<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/6
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <title>酒店预订</title>
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

    <section class="content-header"><h1>酒店预订</h1></section>

    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <form method="post" action="/main">
                    <div class="form-group col-sm-3">
                        <label>城市:</label>
                        <input type="text" class="form-control pull-right" name="city">
                    </div>
                    <div class="form-group col-sm-3">
                        <label>入住日期:</label>
                        <input type="date" class="form-control pull-right" name="datein" id="datein">
                    </div>
                    <div class="form-group col-sm-3">
                        <label>离店日期:</label>
                        <input type="date" class="form-control pull-right" name="dateout" id="dateout">
                    </div>
                    <div class="form-group col-sm-3">
                        <button type="submit" class="btn btn-primary btn-block btn-flat">查询</button>
                    </div>
                </form>
            </div>
            <div class="col-xs-12">
                <div class="box-body">
                    <ul class="products-list product-list-in-box">
                        <c:forEach items="${hotels}" var="h">
                            <li class="item">
                                <div class="product-img">
                                    <img src="../../img/hotel.jpeg" alt="Product Image">
                                </div>
                                <div class="product-info">
                                    <a class="product-title" href="/hotelinfo/${h.id}">${h.name}</a>
                                    <br>
                                    <span class="product-description">${h.location}</span>
                                    <span class="pull-right product-description">酒店电话:${h.telephone}</span>
                                    </span>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <!--col-->
        </div>
        <!--row-->
    </section>
</div>
<script src="../../js/jquery-2.2.3.min.js"></script>
<script src="../../js/bootstrap.js"></script>
<script src="../../js/app.js"></script>


</body>
</html>
