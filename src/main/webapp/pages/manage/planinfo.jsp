<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/6
  Time: 16:57
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
        <section class="content-header"><h1>计划内容</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">

                    <form method="post" name="myform" enctype="multipart/form-data" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-offset-1 col-sm-3 control-label">生效日期:</label>
                            <div class="col-sm-6 input-group date">
                                <label class="control-label">${plan.begintime}</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-1 col-sm-3 control-label">失效日期:</label>
                            <div class="col-sm-6 input-group date">
                                <label class="control-label">${plan.endtime}</label>
                            </div>
                        </div>

                        <hr>

                        <c:forEach items="${type}" var="t" varStatus="loop">
                            <div class="form-group">
                                <label class="col-sm-offset-1 col-sm-2 control-label">房间类型</label>
                                <div class="col-sm-3">
                                    <label class="control-label">${t}</label>
                                </div>
                                <label class="col-sm-2 control-label">房间价格</label>
                                <div class="col-sm-3">
                                    <label class="control-label">${price[loop.count-1]}</label>
                                </div>
                            </div>
                        </c:forEach>

                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-2">
                                <input class="btn btn-success" type="button" value="审批通过" onclick="yAction()">
                            </div>
                            <div class="col-sm-2">
                                <input class="btn btn-danger" type="button" value="审批不通过" onclick="nAction()">
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
    function yAction(){
        document.myform.action="/manage/ok/${plan.id}";
        document.myform.submit();
    }
    function nAction(){
        document.myform.action="/manage/no/${plan.id}";
        document.myform.submit();
    }
</script>

</body>
</html>