<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/9
  Time: 00:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>分店统计</title>
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
        <section class="content-header"><h1>各店统计</h1></section>

        <section class="content">
            <div class="box box-default">
                <table class="table table-hover">
                    <tr>
                        <th>酒店编号</th>
                        <th>酒店名称</th>
                        <th>入住订单(笔数)</th>
                        <th>营业金额</th>
                    </tr>
                    <c:forEach items="${hotels}" var="h" varStatus="loop">
                        <tr>
                            <td>${h.id}</td>
                            <td>${h.name}</td>
                            <td>${ordernum[loop.count-1]}</td>
                            <td>${money[loop.count-1]}</td>
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