<%@ page import="com.phoebe.model.Hotel" %><%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/6
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Hotel hotel = (Hotel)session.getAttribute("hotel");
%>
<header class="main-header">
    <a href="#" class="logo">
        <span class="logo-lg"><b>Awesome</b>inns</span>
    </a>
    <nav class="navbar navbar-static-top">

        <div class="collapse navbar-collapse pull-right" id="navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/hotel/logout">退出</a></li>
            </ul>
        </div>
    </nav>
</header>

<aside class="main-sidebar">
    <section class="sidebar">

        <div class="user-panel">
            <div class="pull-left image">
                <label name="hname"><%=hotel.getId()%></label>
            </div>
            <div class="pull-left info">
                <p>
                    <label name="hname"><%=hotel.getName()%></label>
                </p>
            </div>
        </div>

        <form action="/search" method="post" class="sidebar-form">
            <div class="input-group">
                <input type="text" id="inputsearch" name="inputsearch" class="form-control" placeholder="查找预订单">
                <span class="input-group-btn">
                        <button type="submit" id="search-btn" class="btn btn-flat">
                            <i class="fa fa-search"></i>
                        </button>
                    </span>
            </div>
        </form>

        <!--下面不同的tab-->
        <ul class="sidebar-menu">
            <li class="header"></li>

            <li class="treeview">
                <a href="/hotel/info">
                    <i class="glyphicon glyphicon-file"></i>
                    <span>酒店信息</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
            </li>

            <li>
                <a href="#">
                    <i class="glyphicon glyphicon-th"></i>
                    <span>房间信息</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/hotel/room"><i class="fa fa-circle-o"></i> 添加房间</a></li>
                    <li><a href="/hotel/showRooms"><i class="fa fa-circle-o"></i> 房间状态</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="glyphicon glyphicon-th"></i>
                    <span>酒店计划</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/hotel/plan"><i class="fa fa-circle-o"></i> 历史计划列表</a></li>
                    <li><a href="/hotel/addplan"><i class="fa fa-circle-o"></i> 发布计划</a></li>
                </ul>
            </li>

            <li>
                <a href="#">
                    <i class="glyphicon glyphicon-list"></i>
                    <span>入住登记</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/hotel/bookin"><i class="fa fa-circle-o"></i> 预约入住</a></li>
                    <li><a href="/newin"><i class="fa fa-circle-o"></i> 到店入住</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="leave.html">
                    <i class="glyphicon glyphicon-file"></i>
                    <span>离店登记</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
            </li>

            <li class="treeview">
                <a href="/hotel/analyse">
                    <i class="glyphicon glyphicon-file"></i>
                    <span>统计信息</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
            </li>
        </ul>
    </section>
</aside>
