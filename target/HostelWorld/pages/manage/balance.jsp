<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/4
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <title>结算</title>
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
        <section class="content-header"><h1>结算</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-default">
                        <table class="table table-hover">
                            <tr>
                                <th>酒店名称</th>
                                <th>结算金额</th>
                                <th>银行账户</th>
                            </tr>
                            <c:forEach items="${balance}" var="b">
                                <tr>
                                    <td>${b[1]}</td>
                                    <td>${b[3]}</td>
                                    <td>${b[2]}</td>
                                </tr>
                            </c:forEach>
                        </table>
                        <div class="box box-footer">
                            <form method="post" action="/manage/dobalance">
                                <button type="submit" class="col-sm-offset-4 col-sm-4 btn btn-primary">结算</button>
                            </form>
                        </div>

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