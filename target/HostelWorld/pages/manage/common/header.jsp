<%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/6
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="main-header">
    <a href="#" class="logo">
        <span class="logo-lg"><b>Awesome</b>inns</span>
    </a>
    <nav class="navbar navbar-static-top">

        <div class="collapse navbar-collapse pull-right" id="navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/manage/logout">退出</a></li>
            </ul>
        </div>
    </nav>
</header>

<aside class="main-sidebar">
    <section class="sidebar">

        <!--下面不同的tab-->
        <ul class="sidebar-menu">
            <li class="header"></li>

            <li>
                <a href="#">
                    <i class="glyphicon glyphicon-th"></i>
                    <span>审批</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/manage/hotels"><i class="fa fa-circle-o"></i> 酒店信息修改</a></li>
                    <li><a href="/manage/plans"><i class="fa fa-circle-o"></i> 酒店计划</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="/manage/balance">
                    <i class="glyphicon glyphicon-file"></i>
                    <span>结算</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
            </li>

            <li>
                <a href="#">
                    <i class="glyphicon glyphicon-list"></i>
                    <span>统计信息</span>
                    <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/eachhotel"><i class="fa fa-circle-o"></i>各店情况</a></li>
                    <li><a href="/membersta"><i class="fa fa-circle-o"></i> 会员消费情况</a></li>
                    <li><a href="/financesta"><i class="fa fa-circle-o"></i> 财务情况</a></li>
                </ul>
            </li>
        </ul>
    </section>
</aside>

