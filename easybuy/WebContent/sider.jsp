<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="lefter">
	<div class="box">
		<h2>��Ʒ����</h2>
		<dl>
			<c:forEach items="${listP}" var="p">
				<dt>${p.cname }</dt>
				<c:forEach items="${listS}" var="s">
					<c:if test="${s.cpid==p.cid}">
						<dd><a href="FrontendProList?cid=${s.cid }">${s.cname }</a></dd>
					</c:if>
				</c:forEach>
			</c:forEach>
		</dl>
	</div>
	<div class="spacer"></div>
	<div class="last-view">
		<h2>������</h2>
		<dl class="clearfix">
			<dt><img src="images/product/0_tiny.gif" /></dt>
			<dd><a href="product-view.jsp">�����·�˿��¶��Ʒ�ɿ���500g/��</a></dd>
			<dt><img src="images/product/0_tiny.gif" /></dt>
			<dd><a href="product-view.jsp">�����·�˿��¶��Ʒ�ɿ���500g/��</a></dd>
		</dl>
	</div>
</div>