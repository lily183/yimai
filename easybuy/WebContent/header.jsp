<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>������ - ��ҳ</title>
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
		<c:if test="${name!=null}"><a href="shopping.jsp" class="shopping">���ﳵ</a></c:if>
		<c:if test="${name==null}"><a href="login.jsp" class="shopping">���ﳵ</a></c:if>
	<c:if test="${name==null}">
	<a href="login.jsp">��¼</a><a href="register.jsp">ע��</a></c:if>
	<c:if test="${name!=null&&status==2}"><a href="manage/index.jsp">${name}</a>
	 <a href="Frontend?exit=0" onclick="return confirm('�Ƿ��˳�')">�˳�</a></c:if>
	<c:if test="${name!=null&&status==1}">${name}
	 <a href="Frontend?exit=0" onclick="return confirm('�Ƿ��˳�')">�˳�</a></c:if>
	<a href="fcommentshowServlet">����</a></div>
	
	<div class="navbar">
		<ul class="clearfix" id="mainMenu">
			<li class="current" id="mainMenu_0"><a href="Frontend">��ҳ</a></li>
			<c:forEach items="${listP}" var="p">
				<li><a href="#">${p.cname}</a></li>
			</c:forEach>
			
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap" id="subMenu">
		<ul class="clearfix" id="subMenu_0">
			<li class="first"><a href="#">����</a></li>
			<li><a href="#">Ӱ��</a></li>
			<li><a href="#">�ٶ�</a></li>
			<li><a href="#">����</a></li>
			<li><a href="#">С˵</a></li>
			<li><a href="#">����</a></li>
			<li><a href="#">�������</a></li>
			<li><a href="#">�ʼǱ�</a></li>
			<li><a href="#">���޷�</a></li>
			<li><a href="#">�ﶬѥ</a></li>
			<li><a href="#">�˶�Ь</a></li>
			<li><a href="#">���ݻ���</a></li>
			<li><a href="#">�ҷ���Ʒ</a></li>
			<li><a href="#">Ӥ���̷�</a></li>
			<li><a href="#">��Ʒ</a></li>
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
	        <div class="loading"><img src="images/loading.gif" alt="ͼƬ������"/></div>
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