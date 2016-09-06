<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap" style="padding: 10px 10px 0 10px;">
	<div id="logo"><a href="index.jsp"><img src="../images/logo.gif" /></a></div>
	<div class="help"><a href="../Frontend">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix" id="mainMenu">
			<li class="current"><a href="index.jsp">首页</a></li>
			<li><a href="../selectuservlet">用户</a></li>
			<li><a href="ProductListServlet">商品</a></li>
			<li><a href="OrderqueryAll">订单</a></li>
			<li><a href="commentshowServlet">留言</a></li>
			<li><a href="newsshowServlet">新闻</a>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员${name}您好，今天是${time }，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">