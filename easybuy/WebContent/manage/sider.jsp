<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="menu-mng" class="lefter">
	<div class="box">
		<dl>
			<dt>用户管理</dt>
			<dd><em><a href="user-add.jsp">新增</a></em><a href="../selectuservlet">用户管理</a></dd>
			<dt>商品信息</dt>
			<dd><em><a href="CatPreAddServlet">新增</a></em><a href="CatListServlet">分类管理</a></dd>
			<dd><em><a href="ProductPreAddServlet">新增</a></em><a href="ProductListServlet">商品管理</a></dd>
			<dt>订单管理</dt>
			<dd><a href="OrderqueryAll">订单管理</a></dd>
			<dt>留言管理</dt>
			<dd><a href="commentshowServlet">留言管理</a></dd>
			<dt>新闻管理</dt>
			<dd><em><a href="news-add.jsp">新增</a></em><a href="newsshowServlet">新闻管理</a></dd>
		</dl>
	</div>
</div>