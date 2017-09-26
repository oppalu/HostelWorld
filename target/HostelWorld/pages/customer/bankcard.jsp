<%@ page import="com.phoebe.model.Bankaccount" %><%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/6
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <title>银行卡管理</title>
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
        <section class="content-header"><h1>银行卡信息</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#info" data-toggle="tab">我的银行卡</a></li>
                            <li><a href="#account" data-toggle="tab">添加银行卡</a></li>
                        </ul>

                        <div class="tab-content">
                            <!--个人信息tab界面-->
                            <div class="tab-pane active" id="info">
                                <table class="table table-condensed">
                                    <tr>
                                        <th>卡号</th>
                                        <th>开户人姓名</th>
                                        <th>余额</th>
                                        <th>操作</th>
                                    </tr>
                                    <c:if test="${not empty bank}">
                                        <tr>
                                            <td>${bank.account}</td>
                                            <td>${bank.name}</td>
                                            <td>${bank.balance}</td>
                                            <td>
                                                <form method="post" action="/card/deleteBankcard">
                                                    <button type="submit" class="btn btn-danger" >删除</button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:if>
                                </table>
                            </div>

                            <div class="tab-pane" id="account">
                                <div style="width: 50%" class="col-md-offset-2">
                                    <form method="post" action="/card/addBankcard" class="form-horizontal">
                                        <div class="form-group">
                                            <label class="col-sm-offset-2 col-sm-4 control-label">卡号</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" name="n_account">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-offset-2 col-sm-4 control-label">开户人姓名</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" name="n_name">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-offset-2 col-sm-4 control-label">余额</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" name="n_balance">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-offset-6 col-sm-4">
                                                <button type="submit" class="btn btn-primary">添加</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!--tab-content-->
                    </div>
                    <!--nav-tabs-custom-->
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