<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="header.jsp"/>
	<jsp:include  page="sider.jsp"/>
	<div class="main">
		<h2>修改新闻</h2>
		<div class="manage">
			<form action="newsupdateServlet" method="post">
				<table class="form" >
				   <tr>
					  	<td><input type="hidden" class="text" name="id" value="${update.EN_ID}" /></td>
					 </tr>
					<tr>
					    <td class="field">新闻标题：</td>
						<td><input type="text" class="text" name="title" value="${update.EN_TITLE}" /></td>
					 </tr>
					<tr>
						<td class="field">新闻内容：</td>
						<td><textarea name="content">${update.EN_CONTENT}</textarea></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="修改" /></label></td>
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
	mainMenu[5].className = "current";
	function resetliul(){
		for(var i = 0; i< 5; i++){
			mainMenu[i].className = "";
		}
	}
</script>
<jsp:include  page="footer.jsp"/>
