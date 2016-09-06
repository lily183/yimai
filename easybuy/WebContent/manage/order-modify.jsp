<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="header.jsp"/>
	<jsp:include  page="sider.jsp"/>
	<div class="main">
		<h2>�޸Ķ���</h2>
		<div class="manage">
			<form action="OrderupdateServlet2" method="post">
				<table class="form">
					<tr>
						<td class="field">����ID��</td>
						<td><input type="text" class="text" name="EO_ID" value="${ord.EO_ID}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">������������</td>
						<td><input type="text" class="text" name="EO_USER_NAME" value="${ord.EO_USER_NAME}" /></td>
					</tr>
					<tr>
						<td class="field">�ջ���ַ</td>
						<td><input type="text" class="text" name="EO_USER_ADDRESS" value="${ord.EO_USER_ADDRESS}" /></td>
					</tr>
					<tr>
						<td class="field">״̬</td>
						<td>
							<select name="EO_STATUS">
								<c:if test="${ord.EO_STATUS==1}">
								<option value="1" selected="selected">�ѷ���</option>
								<option value="2">δ����</option>
								</c:if>
								<c:if test="${ord.EO_STATUS==2}">
								<option value="1">�ѷ���</option>
								<option value="2" selected="selected">δ����</option>
								</c:if>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="����" /></label></td>
					</tr>
				</table>
			</form>
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
