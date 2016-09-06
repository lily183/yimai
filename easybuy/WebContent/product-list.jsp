<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
	<div id="main" class="wrap">
	<jsp:include page="sider.jsp"/>
	<div class="main">
		<div class="product-list">
			<h2>全部商品</h2>
			<div class="pager">
				<ul class="clearfix">
					${pageStr }
				</ul>
			</div>
			<div class="clear"></div>
			<ul class="product clearfix">
				<c:forEach items="${plist }" var="p">
					<li>
						<dl>
							<dt><a href="ProductViewServlet?pid=${p.pid }" target="_blank"><img src="images/product/${p.pfileName }" /></a></dt>
							<dd class="title"><a href="ProductViewServlet?pid=${p.pid }" target="_blank">${p.pname }</a></dd>
							<dd class="price">￥${p.pprice }</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					${pageStr }
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<jsp:include page="footer.jsp"/>
