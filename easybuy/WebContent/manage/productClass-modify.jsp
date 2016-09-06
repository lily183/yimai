<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="header.jsp"/>
	<jsp:include  page="sider.jsp"/>
	<div class="main">
		<h2>�޸ķ���</h2>
		<div class="manage">
			<form action="CatModifyExeServlet" method="post">
				<table class="form">
					<tr>
						<td class="field">�����ࣺ</td>
						<td>
							<select name="cpid">
								<c:if test="${cat.cpid==-1}">
									<option value="-1" selected="selected">����Ŀ</option>
								</c:if>
								<c:if test="${cat.cpid!=-1}">
									<c:forEach items="${list}" var="c">
										<option value="${c.cid}"
											<c:if test="${c.cid==cat.cpid}">selected="selected"</c:if>
										>
										${c.cname }</option>
									</c:forEach>
								</c:if>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">�������ƣ�</td>
						<td><input type="text" class="text" name="cname" value="${cat.cname }" />
						<input type="hidden" class="text" name="cid" value="${cat.cid }" /></td>
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
	mainMenu[2].className = "current";
	function resetliul(){
		for(var i = 0; i< 5; i++){
			mainMenu[i].className = "";
		}
	}
</script>
<jsp:include  page="footer.jsp"/>
