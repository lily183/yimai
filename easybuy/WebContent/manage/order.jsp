<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="header.jsp"/>
	<jsp:include  page="sider.jsp"/>
	<div class="main">
		<h2>��������</h2>
		<div class="manage">
			<div class="search">
				<form action="OrderqueryByeo_id" method="post">
					����ID��<input type="text" class="text" name="EO_ID" /> 
					�����ˣ�<input type="text" class="text" name="EO_USER_NAME" /> 
					<label class="ui-blue">
					<input type="submit" name="submit" value="��ѯ" />
					</label>
				</form>
			</div>
			<div class="spacer"></div>
			<table class="list">
				<tr>
					<th>����ID</th>
					<th>����</th>
					<th>�ջ���ַ</th>
					<th>״̬</th>
					<th>����</th>
				</tr>
				<c:forEach items = "${ord}" var= "o">
				<tr>
					<td class="first w4 c">${o.EO_ID }</td>
					<td class="w1 c">${o.EO_USER_NAME}</td>
					<td>${o.EO_USER_ADDRESS}</td>
					
					<c:if test="${o.EO_STATUS==1}">
					<td>�ѷ���</td>
					</c:if>
					<c:if test="${o.EO_STATUS==2}">
					<td>������</td>
					</c:if>
					<td class="w1 c"><a href="OrderupdateServlet?EO_ID=${o.EO_ID }">�޸�</a> <a href="OrderdeleteServlet?EO_ID=${o.EO_ID }">ɾ��</a></td>
				</tr>
				</c:forEach>
			</table>
			<div class="pager">
				<ul class="clearfix">
					<li>${pageStr}</li>
					
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<script type="text/javascript">
	var mainMenu = document.getElementById("mainMenu").getElementsByTagName("li");
	resetliul();
	mainMenu[3].className = "current";
	function resetliul(){
		for(var i = 0; i< 5; i++){
			mainMenu[i].className = "";
		}
	}
</script>
<jsp:include  page="footer.jsp"/>
