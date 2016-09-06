<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="header.jsp"/>
	<jsp:include  page="sider.jsp"/>
	<div class="main">
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>用户名</th>
					<th>密码</th>
					<th>姓名</th>
					<th>性别</th>
					<th>出生日期</th>
					<th>手机</th>
					<th>地址</th>
					<th>权限</th>
					<th>操作</th>
				</tr>
				 <c:forEach items="${list}" var="use">
				<tr>
					<td >${use.usename} </td>
					<td >${use.password}</td>
					<td >${use.name}</td>
					<td>${use.sex}</td>
					<td>${use.birthday} </td>
					<td>${use.mobil} </td>
					<td>${use.address} </td>
					<td>${use.status} </td>
					<td ><a href="../alteruservlet?id=${use.id}">修改</a> <a href="deleteuservlet?id=${use.id}" onclick="return confirm('是否删除?')">删除</a></td>
				</tr>
				</c:forEach>
			</table>
			<div class="pager">
			 <ul class="clearfix">
			  <li>${pageStr }</li>
			 </ul>
			 </div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<script type="text/javascript">
	var mainMenu = document.getElementById("mainMenu").getElementsByTagName("li");
	resetliul();
	mainMenu[1].className = "current";
	function resetliul(){
		for(var i = 0; i< 5; i++){
			mainMenu[i].className = "";
		}
	}
</script>
<jsp:include  page="footer.jsp"/>