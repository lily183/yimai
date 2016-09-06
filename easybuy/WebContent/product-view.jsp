<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
	<div id="main" class="wrap">
	<jsp:include page="sider.jsp"/>
	<div id="product" class="main">
		<c:forEach items="${list}" var="p">
		<h1>${p.pname}</h1>
		<div class="infos">
			<div class="thumb"><img src="images/product/${p.pfileName }" /></div>
			<div class="buy">
				<p>商城价：<span class="price">￥${p.pprice}</span></p>
				<p>库　存：${p.pstock }</p>
				<p>品     牌：${p.pbrand }</p>
				<p>条     码：${p.pcode }</p>
				<div class="button"><input type="button" name="button" value="" onclick="goBuy('${name}',${p.pcode },${p.pprice},${p.pid },'${p.pname }','${p.pfileName }')" /><a href="#">放入购物车</a></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				${p.pdesc }<br />
			</div>
		</div>
		</c:forEach>
	</div>
	<div class="clear"></div>
</div>
<jsp:include page="footer.jsp"/>
