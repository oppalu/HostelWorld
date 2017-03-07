<%@ page import="com.phoebe.model.Member" %><%--
  Created by IntelliJ IDEA.
  User: phoebegl
  Date: 2017/3/6
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Member m = (Member)session.getAttribute("member");
%>
<header class="main-header">
    <a href="/" class="logo">
        <span class="logo-lg"><b>Awesome</b>inns</span>
    </a>
    <nav class="navbar navbar-static-top">

        <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/main">酒店预订</a></li>
            </ul>
        </div>

        <%if(m == null) {%>
        <div class="collapse navbar-collapse pull-right" id="navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/member/login">登录</a></li>
            </ul>
        </div>

        <%} else {%>
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="../../img/avatar.png" class="user-image" alt="User Image">
                        <span class="hidden-xs"><%=m.getName()%></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="user-header">
                            <img src="../../img/avatar.png" class="img-circle" alt="User Image">
                            <p><%=m.getName()%></p>
                        </li>
                        <li class="user-body">
                            <div class="row">
                                <div class="col-xs-6 text-center">
                                    <a href="/getorders">我的订单</a>
                                </div>
                                <div class="col-xs-6 text-center">
                                    <a href="/card/mycard">我的会员卡</a>
                                </div>
                            </div>
                        </li>
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="/member/info" class="btn btn-default btn-flat">我的信息</a>
                            </div>
                            <div class="pull-right">
                                <a href="/member/logout" class="btn btn-default btn-flat">退出</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
        <%}%>
    </nav>
</header>