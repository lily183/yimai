<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<script src="scripts/setHomeSetFav.js" type="text/javascript" charset="gb2312"></script>
<script src="scripts/myfocus-2.0.1.min.js" type="text/javascript"></script>
<script src="scripts/mf-pattern/mF_fancy.js" type="text/javascript"></script>
<link href="scripts/mf-pattern/mF_fancy.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">

  myFocus.set({
	id:'adbox'
	  });
</script>
</head>
<body>
<div id="header" class="wrap"     style="padding:10px 10px 0px 10px;">
	<div id="logo"><a href="Frontend"><img src="images/logo.gif" /></a></div>
	<div class="help">
		<c:if test="${name!=null}"><a href="shopping.jsp" class="shopping">购物车</a></c:if>
		<c:if test="${name==null}"><a href="login.jsp" class="shopping">购物车</a></c:if>
	<c:if test="${name==null}">
	<a href="login.jsp">登录</a><a href="register.jsp">注册</a></c:if>
	<c:if test="${name!=null&&status==2}"><a href="manage/index.jsp">${name}</a>
	 <a href="Frontend?exit=0" onclick="return confirm('是否退出')">退出</a></c:if>
	<c:if test="${name!=null&&status==1}">${name}
	 <a href="Frontend?exit=0" onclick="return confirm('是否退出')">退出</a></c:if>
	<a href="fcommentshowServlet">留言</a></div>
	
	<div class="navbar">
		<ul class="clearfix" id="mainMenu">
			<li class="current" id="mainMenu_0"><a href="Frontend">首页</a></li>
			<c:forEach items="${listP}" var="p">
				<li><a href="#">${p.cname}</a></li>
			</c:forEach>
			
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap" id="subMenu">
		<ul class="clearfix" id="subMenu_0">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
		<c:forEach items="${listP}" var="p">
			<ul class="clearfix">
			<c:forEach items="${listS}" var="s">
				<c:if test="${s.cpid==p.cid}">
					<li><a href="FrontendProList?cid=${s.cid }">${s.cname }</a></li>
				</c:if>
			</c:forEach>
			</ul>
		</c:forEach>
	</div>
</div>


<c:if test="${slider==1}">
	<div class="ad" id="adbox">
	        <div class="loading"><img src="images/loading.gif" alt="图片加载中"/></div>
	        <div class="pic">
	           <ul>
	             <li><img src="images/ad2.jpg"/></li>
	             <li><img src="images/ad3.jpg"/></li>
	             <li><img src="images/ad4.jpg"/></li>
	           </ul>
	        </div>
	  </div><!--ad finish-->
	
	  <div class="sideimg">    
	  	<span class="sideimg1"><img src="images/sideimg4.gif"/></span>
	  </div>
</c:if>