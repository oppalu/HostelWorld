<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/5
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <title>房间管理</title>
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
        <section class="content-header"><h1>房间状态</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box box-default">
                        <table class="table table-hover">
                            <tr>
                                <th>房间号</th>
                                <th>房间类型</th>
                                <th>房间状态</th>
                                <th>入住时间</th>
                                <th>离开时间</th>
                                <th>操作</th>
                            </tr>
                            <c:forEach items="${rooms}" var="r">
                                <tr>
                                    <td>${r.name}</td>
                                    <td>${r.typename}</td>
                                    <td><span class="label label-info">${r.status}</span></td>
                                    <td>${r.orderstart}</td>
                                    <td>${r.orderend}</td>
                                    <td><a href="/room/${r.id}">修改房间信息</a></td>
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
<script type="text/javascript">
    function setImagePreview() {
        var docObj = document.getElementById("file");
        var preview = document.getElementById("image");
        preview.src = window.URL.createObjectURL(docObj.files[0]);
    }
</script>


</body>
</html>
