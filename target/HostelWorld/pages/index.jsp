<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/2/22
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>预定首页</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/AdminLTE.css">
    <link rel="stylesheet" href="../css/all-skins.css">
</head>

<body background="../img/index.jpeg">

<div class="login-box">
    <div class="box box-primary">
        <div class="box-header">
            <h3 class="box-title">Date picker</h3>
        </div>
        <div class="box-body">
            <!-- Date -->
            <div class="form-group">
                <label>Date:</label>

                <div class="input-group date">
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                    <input type="text" class="form-control pull-right" id="datepicker">
                </div>
                <!-- /.input group -->
            </div>
            <!-- /.form group -->

            <!-- Date range -->
            <div class="form-group">
                <label>Date range:</label>

                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                    <input type="text" class="form-control pull-right" id="reservation">
                </div>
                <!-- /.input group -->
            </div>
            <!-- /.form group -->

            <!-- Date and time range -->
            <div class="form-group">
                <label>Date and time range:</label>

                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="fa fa-clock-o"></i>
                    </div>
                    <input type="text" class="form-control pull-right" id="reservationtime">
                </div>
                <!-- /.input group -->
            </div>
            <!-- /.form group -->

            <!-- Date and time range -->
            <div class="form-group">
                <label>Date range button:</label>

                <div class="input-group">
                    <button type="button" class="btn btn-default pull-right" id="daterange-btn">
                    <span>
                      <i class="fa fa-calendar"></i> Date range picker
                    </span>
                        <i class="fa fa-caret-down"></i>
                    </button>
                </div>
            </div>
            <!-- /.form group -->

        </div>
        <!-- /.box-body -->
    </div>
</div>

</body>
</html>
