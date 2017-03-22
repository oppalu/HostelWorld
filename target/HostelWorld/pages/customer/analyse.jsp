<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/8
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <title>统计分析</title>
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
        <section class="content-header"><h1>统计数据</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-body">
                            <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">自从加入Awesome inns以来,&nbsp;</span>
                            <p style="padding-left:20px">
                                <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">您一共预定了</span>
                                <span id="totalrun" style="font-family:Microsoft YaHei;font-weight:500;font-size:24px;opacity:1">${all}</span>
                                <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">次,其中成功入住了</span>
                                <span id="totalwalk" style="font-family:Microsoft YaHei;font-weight:500;font-size:24px;opacity:1">${success}</span>
                                <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">次,</span>
                            </p>
                            <p style="padding-left:40px">
                                <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">实际共消费了</span>
                                <span id="equal" style="font-family:Microsoft YaHei;color: #ac2925;font-weight:500;font-size:24px;opacity:1">${money}</span>
                                <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">元</span>
                            </p>
                        </div>

                    </div>
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