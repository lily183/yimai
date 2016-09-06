<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="header.jsp"/>
	<jsp:include  page="sider.jsp"/>
	<div class="main">
		<h2>»Ø¸´ÁôÑÔ</h2>
		<div class="manage">
			<form action="commentupdateServlet" method="post">
				<table class="form">
					<tr>
						<!--<td class="field">ÁôÑÔID£º</td>
						--><td><input type="hidden" class="text" name="id" value="${update.EC_ID}"  /></td>
					</tr>
					<tr>
						<td class="field">ÁôÑÔĞÕÃû£º</td>
						<td><input type="text" class="text" name="name" value="${update.EC_NICK_NAME}" disabled="disabled"/></td>
					</tr>
					<tr>
						<td class="field">ÁôÑÔÄÚÈİ£º</td>
						<td><textarea name="content" disabled="disabled">${update.EC_CONTENT}</textarea></td>
					</tr>
					<tr>
						<td class="field">»Ø¸´ÄÚÈİ£º</td>
						<td><textarea name="replyContent">${update.EC_REPLY}</textarea></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="»Ø¸´" /></label></td>
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
	mainMenu[4].className = "current";
	function resetliul(){
		for(var i = 0; i< 5; i++){
			mainMenu[i].className = "";
		}
	}
</script>
<jsp:include  page="footer.jsp"/>
