<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/5
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <title>房间管理</title>
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
        <section class="content-header"><h1>修改房间信息</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <form method="post" action="/room/modify"class="form-horizontal">
                        <div class="form-group">
                            <div class="col-sm-3">
                                <input type="hidden" id="roomid" name="roomid" value="${room.id}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">房间名称</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="name" name="name" value="${room.name}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">房间类型</label>
                            <div class="col-sm-8">
                                <select id="roomtype" name="roomtype">
                                    <c:forEach items="${types}" var="t">
                                        <option value="${t.id}">${t.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-8">
                                <button type="submit" class="btn btn-primary">确认修改</button>
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

</body>
</html>
