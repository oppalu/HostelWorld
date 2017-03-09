<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/7
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>统计信息</title>
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
        <section class="content-header"><h1>统计信息</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#type" data-toggle="tab">所有订单</a></li>
                            <li><a href="#room" data-toggle="tab">统计分析</a></li>
                        </ul>

                        <div class="tab-content">
                            <div class="tab-pane active" id="type">
                                <div>
                                    <table class="table table-hover">
                                        <tr>
                                            <th>订单编号</th>
                                            <th>房型</th>
                                            <th>入住日期</th>
                                            <th>退房日期</th>
                                            <th>总房价</th>
                                            <th>联系电话</th>
                                            <th>订单状态</th>
                                        </tr>
                                        <c:forEach items="${list}" var="l"  varStatus="loop">
                                            <tr>
                                                <td><a href="/showinfo/${l.id}">${l.id}</a></td>
                                                <td>${typename[loop.count-1]}</td>
                                                <td>${l.begintime}</td>
                                                <td>${l.endtime}</td>
                                                <td>${l.price}</td>
                                                <td>${l.phone}</td>
                                                <td><span class="label label-primary">${l.status}</span></td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>

                            <div class="tab-pane" id="room">
                                <%--订单情况--%>
                                <div class="box box-danger">
                                    <div class="box-body">
                                        <div class="col-md-6 col-sm-6">
                                            <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">本店一共有&nbsp;</span>
                                            <span style="font-family:Microsoft YaHei;font-weight:500;font-size:24px;opacity:1">${allcount}</span>
                                            <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">份订单,</span>
                                        </div>
                                        <!--统计图部分-->
                                        <div class="col-md-6 col-sm-6">
                                            <div id="order" style="width: 350px;;height: 350px;"></div>
                                        </div>
                                    </div>
                                </div>

                                    <div class="box box-warning">
                                        <div class="box-body">
                                            <div class="col-md-6 col-sm-6">
                                                <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">其中成功入住的有&nbsp;</span>
                                                <span style="font-family:Microsoft YaHei;font-weight:500;font-size:24px;opacity:1">${successcount}</span>
                                                <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">份订单,</span>
                                            </div>
                                            <!--统计图部分-->
                                            <div class="col-md-6 col-sm-6">
                                                <div id="success" style="width: 350px;;height: 350px;"></div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="box box-success">
                                        <div class="box-body">
                                            <div class="col-md-6 col-sm-6">
                                                <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">本店共盈利&nbsp;</span>
                                                <span style="font-family:Microsoft YaHei;font-weight:500;font-size:24px;opacity:1">${profit}</span>
                                                <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">元</span>
                                                <p style="padding-left:20px">
                                                    <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">其中会员共消费</span>
                                                    <span style="font-family:Microsoft YaHei;font-weight:500;font-size:24px;opacity:1">${member}</span>
                                                    <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">元,</span>
                                                </p>
                                                <p style="padding-left:20px">
                                                    <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">非会员共消费</span>
                                                    <span style="font-family:Microsoft YaHei;font-weight:500;font-size:24px;opacity:1">${nonmember}</span>
                                                    <span style="font-family:Microsoft YaHei;font-weight:400;font-size:16px;opacity:0.8">元</span>
                                                </p>
                                            </div>
                                            <!--统计图部分-->
                                            <div class="col-md-6 col-sm-6">
                                                <div id="money" style="width: 350px;height: 350px;"></div>
                                            </div>
                                        </div>
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
<script src="../../js/echarts.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        Chart();
    });
    function Chart() {
        var myChart1 = echarts.init(document.getElementById('order'));
        var url = "/hotel/allchart";
        $.ajax(url, {
            type: 'GET',
            success: function (data) {
                myChart1.setOption({
                    title : {
                        text: '今年各月份订单情况',
                        x:'center'
                    },
                    tooltip : {},
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data:['月份']
                    },
                    xAxis: {
                        data: data.month
                    },
                    yAxis: {},
                    series: [{
                        name: '月份',
                        type: 'bar',
                        data: data.count
                    }]
                });
            }
        });

        var myChart2 = echarts.init(document.getElementById('success'));
        var url = "/hotel/successchart";
        $.ajax(url, {
            type: 'GET',
            success: function (data) {
                myChart2.setOption({
                    title : {
                        text: '今年各月份入住情况',
                        x:'center'
                    },
                    tooltip : {},
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data:['月份']
                    },
                    xAxis: {
                        data: data.m
                    },
                    yAxis: {},
                    series: [{
                        name: '月份',
                        type: 'bar',
                        data: data.c
                    }]
                });
            }
        });

        var myChart3 = echarts.init(document.getElementById('money'));
        myChart3.setOption({
            title : {
                text: '会员与非会员消费情况',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['会员','非会员']
            },
            series : [
                {
                    name: '消费情况',
                    type: 'pie',
                    radius : '60%',
                    center: ['50%', '60%'],
                    data:[
                        {value:${member}, name:'会员'},
                        {value:${nonmember}, name:'非会员'}
                    ]
                }
            ]
        });
    }
</script>

</body>
</html>
