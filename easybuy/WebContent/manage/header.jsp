<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>��̨���� - ������</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap" style="padding: 10px 10px 0 10px;">
	<div id="logo"><a href="index.jsp"><img src="../images/logo.gif" /></a></div>
	<div class="help"><a href="../Frontend">����ǰ̨ҳ��</a></div>
	<div class="navbar">
		<ul class="clearfix" id="mainMenu">
			<li class="current"><a href="index.jsp">��ҳ</a></li>
			<li><a href="../selectuservlet">�û�</a></li>
			<li><a href="ProductListServlet">��Ʒ</a></li>
			<li><a href="OrderqueryAll">����</a></li>
			<li><a href="commentshowServlet">����</a></li>
			<li><a href="newsshowServlet">����</a>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		����Ա${name}���ã�������${time }����ӭ�ص������̨��
	</div>
</div>
<div id="position" class="wrap">
	�����ڵ�λ�ã�<a href="index.jsp">������</a> &gt; �����̨
</div>
<div id="main" class="wrap">