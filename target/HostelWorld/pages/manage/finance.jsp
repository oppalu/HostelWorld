<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/9
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>财务统计</title>
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
        <section class="content-header"><h1>财务统计</h1></section>

        <section class="content">
            <section class="content">

                <div class="box box-success">
                    <div class="box-body">
                        <div class="col-md-6 col-sm-6">
                            <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">Awesome inns共盈利&nbsp;</span>
                            <span style="font-family:Microsoft YaHei;color: #ac2925;font-weight:500;font-size:24px;opacity:1">${allmoney}</span>
                            <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">元,今年各月盈利情况见右图</span>
                        </div>
                        <!--统计图部分-->
                        <div class="col-md-6 col-sm-6">
                            <div id="money" style="width: 400px;height: 400px;"></div>
                        </div>
                    </div>
                </div>
            </section>
        </section>
    </div>
</div>
<script src="../../js/jquery-2.2.3.min.js"></script>
<script src="../../js/bootstrap.js"></script>
<script src="../../js/app.js"></script>
<script src="../../js/echarts.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        Chart();
    });
    function Chart() {
        var myChart2 = echarts.init(document.getElementById('money'));
        var url = "/sysmoney";
        $.ajax(url, {
            type: 'GET',
            success: function (data) {
                myChart2.setOption({
                    title : {
                        text: '今年各月份消费情况',
                        x:'center'
                    },
                    toolbox: {
                        feature: {
                            magicType: {show: true, type: ['bar', 'line']}
                        }
                    },
                    tooltip : {trigger: 'axis'},
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data:['会员','非会员']
                    },
                    xAxis: {
                        data: data.month
                    },
                    yAxis: {},
                    series: [{
                        name: '会员',
                        type: 'bar',
                        data: data.member
                    },
                        {
                            name: '非会员',
                            type: 'bar',
                            data: data.nonmem
                        }]
                });
            }
        });
    }
</script>

</body>
</html>
