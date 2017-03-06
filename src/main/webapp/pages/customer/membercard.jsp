<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/6
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <title>会员卡信息</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <link rel="stylesheet" href="../../css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../../css/AdminLTE.css">
    <link rel="stylesheet" href="../../css/all-skins.css">
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <jsp:include page="common/header1.jsp"/>

    <div class="content-wrapper">
        <section class="content-header"><h1>我的会员卡</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <table class="table table-condensed">
                        <tr>
                            <th>会员卡号</th>
                            <th>等级</th>
                            <th>余额</th>
                            <th>到期时间</th>
                            <th>状态</th>
                        </tr>
                        <c:if test="${not empty card}">
                            <tr>
                                <td><a href="/card/${card.id}">${card.id}</a> </td>
                                <td>${card.level}</td>
                                <td>${card.balance}</td>
                                <td>${card.statetime}</td>
                                <td><span class="label label-warning">${card.state}</span></td>
                            </tr>
                        </c:if>
                    </table>
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

<div class="modal fade" id="read" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">我店会员等级为累计积分/500(即累计500积分为1级会员),5级以下会员享受95折优惠,10级以下享受9折优惠,以此类推75折封顶</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>

