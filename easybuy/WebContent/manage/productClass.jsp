<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="header.jsp"/>
	<jsp:include  page="sider.jsp"/>
	<div class="main">
		<h2>分类管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>分类名称</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${listP}" var="p">
					<tr>
						<td class="first w4 c">${p.cid}</td>
						<td>${p.cname}</td>
						<td class="w1 c"><a href="CatModifyServlet?cid=${p.cid}">修改</a> <a href="javascript:DeleteCategory(${p.cid});">删除</a></td>
					</tr>
					<c:forEach items="${listS}" var="s">
						<c:if test="${s.cpid==p.cid}">
							<tr>
								<td class="first w4 c">${s.cid }</td>
								<td class="childClass">${s.cname }</td>
								<td class="w1 c"><a href="CatModifyServlet?cid=${s.cid}">修改</a> <a href="javascript:DeleteCategory(${s.cid });">删除</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="clear"></div>
</div>
<script type="text/javascript">
	var mainMenu = document.getElementById("mainMenu").getElementsByTagName("li");
	resetliul();
	mainMenu[2].className = "current";
	function resetliul(){
		for(var i = 0; i< 5; i++){
			mainMenu[i].className = "";
		}
	}
</script>
<jsp:include  page="footer.jsp"/>