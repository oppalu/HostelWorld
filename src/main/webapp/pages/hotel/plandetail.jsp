<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/5
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <title>计划详情</title>
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
        <section class="content-header"><h1>计划详情</h1></section>

        <section class="invoice">
            <div class="row">
                <div class="col-xs-12">
                    <h2 class="page-header">
                        计划编号${plan.id}<span class="small label label-primary">${plan.state}</span>
                        <small class="pull-right">生成日期:${plan.createtime}</small>
                    </h2>
                </div>
            </div>

            <div class="row invoice-info">
                <table class="table table-hover">
                    <tr>
                        <th>房间类型</th>
                        <th>价格</th>
                        <th>生效日期</th>
                        <th>失效日期</th>
                    </tr>
                    <c:forEach items="${type}" var="t" varStatus="loop">
                        <tr>
                            <td>${t}</td>
                            <td>${price[loop.count-1]}</td>
                            <td>${plan.begintime}</td>
                            <td>${plan.endtime}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </section>
    </div>
</div>
<script src="../../js/jquery-2.2.3.min.js"></script>
<script src="../../js/bootstrap.js"></script>
<script src="../../js/app.js"></script>

</body>
</html>