<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/5
  Time: 16:53
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
                    <form name="myform" method="post" enctype="multipart/form-data" class="form-horizontal">

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">酒店名称</label>
                            <div class="col-sm-3">
                                <label class="control-label">${hotel.name}</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">所在城市</label>
                            <div class="col-sm-3">
                                <label class="control-label">${hotel.city}</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">具体地址</label>
                            <div class="col-sm-3">
                                <label class="control-label">${hotel.location}</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">酒店电话</label>
                            <div class="col-sm-3">
                                <label class="control-label">${hotel.telephone}</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">银行账户</label>
                            <div class="col-sm-3">
                                <label class="control-label">${hotel.bankid}</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">开业时间</label>
                            <div class="col-sm-3">
                                <label class="control-label">2017-03-01</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-2">
                                <input class="btn btn-success" type="button" value="审批通过" onclick="yesAction()">
                            </div>
                            <div class="col-sm-2">
                                <input class="btn btn-danger" type="button" value="审批不通过" onclick="noAction()">
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
    function yesAction(){
        document.myform.action="/manage/stateok/${hotel.id}";
        document.myform.submit();
    }
    function noAction(){
        document.myform.action="/manage/stateno/${hotel.id}";
        document.myform.submit();
    }
</script>

</body>
</html>
