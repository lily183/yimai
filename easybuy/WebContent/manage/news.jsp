<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="header.jsp"/>
	<jsp:include  page="sider.jsp"/>
	<div class="main">
		<h2>新闻管理</h2>
		<div class="manage">
		    <c:if test="${list==null}">
                                              暂无新闻信息
             </c:if>
             <c:if test="${list!=null}">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>新闻标题</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${list}" var="prd"> 
				<tr>
					<td class="first w4 c">${prd.EN_ID}</td>
					<td>${prd.EN_TITLE}</td>
					<td class="w1 c"><a href="updateServlet?pid=${prd.EN_ID}">修改</a> <a href="javascript:Deletenews(${prd.EN_ID});">删除</a></td>
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
	mainMenu[5].className = "current";
	function resetliul(){
		for(var i = 0; i< 5; i++){
			mainMenu[i].className = "";
		}
	}
</script>
<jsp:include  page="footer.jsp"/>