<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<jsp:include  page="header.jsp"/>
	<jsp:include  page="sider.jsp"/>
	<div class="main">
		<h2>添加商品</h2>
		<div class="manage">
			<form action="ProductAddServlet" method="post" enctype="multipart/form-data">
				<table class="form">
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" class="text" name="pname" placeholder="请输入商品名称" /></td>
					</tr>
					<tr>
						<td class="field">商品描述：</td>
						<td><input type="text" class="text" name="pdesc" placeholder="请输入描述" /></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="pcatId">
								<c:forEach items="${clist}" var="c">
									<option value="${c.cid}">${c.cname }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">特价商品：</td>
						<td>
							<select name="pspecPrice">
								<option value="1" selected="seclected">是</option>
								<option value="2">否</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">特卖商品：</td>
						<td>
							<select name="pspecBuy">
								<option value="1" selected="seclected">是</option>
								<option value="2">否</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">商品图片：</td>
						<td><input type="file" class="text" name="pfileName" /></td>
					</tr>
					<tr>
						<td class="field">商品价格：</td>
						<td><input type="text" class="text tiny" name="pprice" /> 元</td>
					</tr>
					<tr>
						<td class="field">品牌：</td>
						<td><input type="text" class="text" name="pbrand" /></td>
					</tr>
					<tr>
						<td class="field">库存：</td>
						<td><input type="text" class="text tiny" name="pstock" /></td>
					</tr>
					<tr>
						<td class="field">条码号：</td>
						<td><input type="text" class="text" name="pcode" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="添加" /></label></td>
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