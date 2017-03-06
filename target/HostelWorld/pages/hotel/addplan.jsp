<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/6
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <title>发布计划</title>
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
                        <div class="box-header">
                            发布计划
                        </div>

                        <div class="box-body">
                            <form method="post" action="/hotel/addplan" class="form-horizontal">

                                <div class="form-group">
                                    <label class="col-sm-offset-1 col-sm-3 control-label">生效日期:</label>
                                    <div class="col-sm-6 input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="date" class="form-control pull-right" name="starttime" id="starttime">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-offset-1 col-sm-3 control-label">失效日期:</label>
                                    <div class="col-sm-6 input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="date" class="form-control pull-right" name="endtime" id="endtime">
                                    </div>
                                </div>

                                <hr>

                                <%
                                    int i = 1;
                                %>
                                <c:forEach items="${types}" var="t">
                                    <div class="form-group">
                                        <label class="col-sm-offset-1 col-sm-2 control-label">房间类型</label>
                                        <div class="col-sm-3">
                                            <input type="text" value="${t.name}" class="form-control" name=<%="type"+String.valueOf(i)%>>
                                        </div>
                                        <label class="col-sm-2 control-label">房间价格</label>
                                        <div class="col-sm-3">
                                            <input type="text" value="${t.price}" class="form-control" name=<%="price"+String.valueOf(i)%>>
                                        </div>
                                    </div>
                                    <%i++;%>
                                </c:forEach>

                                <div class="form-group">
                                    <div class="col-sm-offset-6 col-sm-4">
                                        <button type="submit" class="btn btn-primary">发布</button>
                                    </div>
                                </div>
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


