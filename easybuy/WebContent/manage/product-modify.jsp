<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include  page="header.jsp"/>
	<jsp:include  page="sider.jsp"/>
	<div class="main">
		<h2>修改商品</h2>
		<div class="manage">
			<form action="ProductModifyExeServlet" method="post"  enctype="multipart/form-data">
				<table class="form">
					<c:forEach items="${list}" var="p">
					<input type="hidden" class="text" name="pid" value="${p.pid}"/>
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" class="text" name="pname" value="${p.pname}" /></td>
					</tr>
					<tr>
						<td class="field">商品描述：</td>
						<td><input type="text" class="text" name="pdesc" value="${p.pdesc}" /></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="pcatId">
								<c:forEach items="${clist}" var="c">
									<option value="${c.cid}"
										<c:if test="${c.cid==p.pcatId}">selected="selected"</c:if>
									>
									${c.cname }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">特价商品：</td>
						<td>
							<select name="pspecPrice">
								<c:if test="${p.pspecPrice=='1'}">
								<option value="1" selected="selected">是</option>
								<option value="2">否</option>
								</c:if>
								<c:if test="${p.pspecPrice=='2'}">
								<option value="1">是</option>
								<option value="2" selected="selected">否</option>
								</c:if>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">特卖商品：</td>
						<td>
							<select name="pspecBuy">
								<c:if test="${p.pspecBuy=='1'}">
								<option value="1" selected="selected">是</option>
								<option value="2">否</option>
								</c:if>
								<c:if test="${p.pspecBuy=='2'}">
								<option value="1">是</option>
								<option value="2" selected="selected">否</option>
								</c:if>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">商品图片：</td>
						<td><input type="file" class="text" name="pfileName" />
						<input type="hidden" class="text" name="pfileName" value="${p.pfileName }"/>
						</td>
					</tr>
					<tr>
						<td class="field">商品价格：</td>
						<td><input type="text" class="text tiny" name="pprice" value="${p.pprice}"/> 元</td>
					</tr>
					<tr>
						<td class="field">品牌：</td>
						<td><input type="text" class="text" name="pbrand" value="${p.pbrand}"/></td>
					</tr>
					<tr>
						<td class="field">库存：</td>
						<td><input type="text" class="text tiny" name="pstock" value="${p.pstock}"/></td>
					</tr>
					<tr>
						<td class="field">条码号：</td>
						<td><input type="text" class="text" name="pcode" value="${p.pcode}"/></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="修改" /></label></td>
					</tr>
					</c:forEach>
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
