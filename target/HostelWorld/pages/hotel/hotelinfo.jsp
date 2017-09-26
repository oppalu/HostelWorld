<%@ page import="com.phoebe.model.Hotel" %><%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/5
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <title>酒店信息</title>
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
        <section class="content-header"><h1>酒店基本信息</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <form method="post" action="/hotel/modify" onsubmit="return checkBank()" class="form-horizontal">

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">酒店编号</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="hotelid" name="hotelid" value="${hotel.id}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">酒店名称</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="name" name="name" value="${hotel.name}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">所在城市</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="city" name="city" value="${hotel.city}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">具体地址</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="location" name="location" value="${hotel.location}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">酒店电话</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="tel" name="tel" value="${hotel.telephone}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">银行账户</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="bank" name="bank" value="${hotel.bankid}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">开业时间</label>
                            <div class="col-sm-3">
                                <label class="control-label">2017-03-01</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">状态</label>
                            <div class="col-sm-3">
                                <label class="control-label">${hotel.state}</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-8">
                                <button type="submit" class="btn btn-danger">修改</button>
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

<script type="text/javascript">

    function checkBank() {
        var bank = document.getElementById("bank").value;

        if(bank.length != 19) {
            alert("银行账户格式有误!");
            return false;
        }
    }

</script>

</body>
</html>
