<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/6
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
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
        <section class="content-header"><h1>会员卡信息</h1></section>

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <form method="post" action="/card/charge" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">会员卡号</label>
                            <label class="col-sm-2 control-label">${card.id}</label>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">状态:</label>
                            <span class="col-sm-offset-1 label label-success">${card.state}</span>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">到期时间:</label>
                            <label class="col-sm-2 control-label">${card.statetime}</label>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">等级:</label>
                            <label class="col-sm-2 control-label">${card.level}</label>
                            <a data-toggle="modal" href="#" data-target="#read">查看等级优惠说明</a>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">余额:</label>
                            <label class="col-sm-2 control-label">${card.balance}元</label>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-offset-2 col-sm-2 control-label">充值:</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="money" name="money" placeholder="充值金额">
                            </div>
                            <button type="submit" class="btn btn-danger">确认充值</button>
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
