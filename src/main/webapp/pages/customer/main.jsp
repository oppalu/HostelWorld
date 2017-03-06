<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/6
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>酒店预订</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <link rel="stylesheet" href="../../css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../../css/AdminLTE.css">
    <link rel="stylesheet" href="../../css/all-skins.css">
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div style="background-color: #ecf0f5">

    <header class="main-header">
        <a href="index.html" class="logo">
            <span class="logo-lg"><b>Awesome</b>inns</span>
        </a>
        <nav class="navbar navbar-static-top">

            <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">酒店预订</a></li>
                </ul>
            </div>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="../../img/avatar.png" class="user-image" alt="User Image">
                            <span class="hidden-xs">Jessica</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="user-header">
                                <img src="../../img/avatar.png" class="img-circle" alt="User Image">
                                <p>Jessica</p>
                            </li>
                            <li class="user-body">
                                <div class="row">
                                    <div class="col-xs-6 text-center">
                                        <a href="userorder.html">我的订单</a>
                                    </div>
                                    <div class="col-xs-6 text-center">
                                        <a href="membercard.html">我的会员卡</a>
                                    </div>
                                </div>
                            </li>
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="userinfo.html" class="btn btn-default btn-flat">我的信息</a>
                                </div>
                                <div class="pull-right">
                                    <a href="login.html" class="btn btn-default btn-flat">退出</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <section class="content-header"><h1>酒店预订</h1></section>

    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <form method="post" action="#">
                    <div class="form-group col-sm-3">
                        <label>城市:</label>
                        <input type="text" class="form-control pull-right" id="city">
                    </div>
                    <div class="form-group col-sm-3">
                        <label>入住日期:</label>
                        <input type="date" class="form-control pull-right" id="datein">
                    </div>
                    <div class="form-group col-sm-3">
                        <label>离店日期:</label>
                        <input type="date" class="form-control pull-right" id="dateout">
                    </div>
                    <div class="form-group col-sm-3">
                        <button type="submit" class="btn btn-primary btn-block btn-flat">查询</button>
                    </div>
                </form>
            </div>
            <div class="col-xs-12">
                <div class="box-body">
                    <ul class="products-list product-list-in-box">
                        <li class="item">
                            <div class="product-img">
                                <img src="../../img/hotel.jpeg" alt="Product Image">
                            </div>
                            <div class="product-info">
                                <a class="product-title" href="hoteldetail.html">如家快捷酒店</a>
                                <br>
                                <span class="product-description">南京仙林大学城羊山北路1号（南京工业职业技术学院南门内)</span>
                                <span class="pull-right product-description">酒店电话:02585864000</span>
                                </span>
                            </div>
                        </li>

                        <li class="item">
                            <div class="product-img">
                                <img src="../../img/hotel.jpeg" alt="Product Image">
                            </div>
                            <div class="product-info">
                                <a class="product-title" href="hoteldetail.html">如家快捷酒店</a>
                                <br>
                                <span class="product-description">南京仙林大学城羊山北路1号（南京工业职业技术学院南门内)</span>
                                <span class="pull-right product-description">酒店电话:02585864000</span>
                                </span>
                            </div>
                        </li>

                        <li class="item">
                            <div class="product-img">
                                <img src="../../img/hotel.jpeg" alt="Product Image">
                            </div>
                            <div class="product-info">
                                <a class="product-title" href="hoteldetail.html">如家快捷酒店</a>
                                <br>
                                <span class="product-description">南京仙林大学城羊山北路1号（南京工业职业技术学院南门内)</span>
                                <span class="pull-right product-description">酒店电话:02585864000</span>
                                </span>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <!--col-->
        </div>
        <!--row-->
    </section>
</div>
<script src="../../js/jquery-2.2.3.min.js"></script>
<script src="../../js/bootstrap.js"></script>
<script src="../../js/app.js"></script>


</body>
</html>
