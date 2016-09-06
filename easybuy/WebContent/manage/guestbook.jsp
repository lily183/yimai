<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="header.jsp"/>
	<jsp:include  page="sider.jsp"/>
	<div class="main">
		<h2>留言管理</h2>
		<div class="manage">
		   <c:if test="${list==null}">
                                              暂无留言信息
           </c:if>
           <c:if test="${list!=null}">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>留言内容</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${list}" var="prd"> 
				 <tr>
					<td class="first w4 c">${prd.EC_ID}</td>
					<td class="w1 c">${prd.EC_NICK_NAME}</td>
					<td>${prd.EC_CONTENT}</td>
					<c:if test="${prd.EC_REPLY!=null}">
					  <td class="w1 c">已回复</td>
					  <td class="w1 c"><a href="javascript:Deletecomment(${prd.EC_ID});">删除</a></td>
					</c:if>
					<c:if test="${prd.EC_REPLY==null}">
					  <td class="w1 c">未回复</td>
					  <td class="w1 c"><a href="comupdateServlet?id=${prd.EC_ID}">回复</a> <a href="javascript:Deletecomment(${prd.EC_ID});">删除</a></td>
					</c:if>
				 </tr>
			    </c:forEach> 
			 </table>
		    </c:if>
			<div class="pager">
				<ul class="clearfix">
				    <li align="center"> ${pageStr }</li>
				 
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<script type="text/javascript">
	var mainMenu = document.getElementById("mainMenu").getElementsByTagName("li");
	resetliul();
	mainMenu[4].className = "current";
	function resetliul(){
		for(var i = 0; i< 5; i++){
			mainMenu[i].className = "";
		}
	}
</script>
<jsp:include  page="footer.jsp"/>