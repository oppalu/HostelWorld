<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/6
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <title>历史计划列表</title>
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
        <section class="content-header"><h1>发布计划</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-default">
                        <table class="table table-hover">
                            <tr>
                                <th>计划编号</th>
                                <th>生成日期</th>
                                <th>生效日期</th>
                                <th>失效日期</th>
                                <th>状态</th>
                            </tr>
                            <c:forEach items="${plans}" var="p">
                                <tr>
                                    <td><a href="/plan/${p.id}"> ${p.id}</a></td>
                                    <td>${p.createtime}</td>
                                    <td>${p.begintime}</td>
                                    <td>${p.endtime}</td>
                                    <td><span class="label label-warning">${p.state}</span></td>
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

