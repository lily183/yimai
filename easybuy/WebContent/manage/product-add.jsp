<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<jsp:include  page="header.jsp"/>
	<jsp:include  page="sider.jsp"/>
	<div class="main">
		<h2>�����Ʒ</h2>
		<div class="manage">
			<form action="ProductAddServlet" method="post" enctype="multipart/form-data">
				<table class="form">
					<tr>
						<td class="field">��Ʒ���ƣ�</td>
						<td><input type="text" class="text" name="pname" placeholder="��������Ʒ����" /></td>
					</tr>
					<tr>
						<td class="field">��Ʒ������</td>
						<td><input type="text" class="text" name="pdesc" placeholder="����������" /></td>
					</tr>
					<tr>
						<td class="field">�������ࣺ</td>
						<td>
							<select name="pcatId">
								<c:forEach items="${clist}" var="c">
									<option value="${c.cid}">${c.cname }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">�ؼ���Ʒ��</td>
						<td>
							<select name="pspecPrice">
								<option value="1" selected="seclected">��</option>
								<option value="2">��</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">������Ʒ��</td>
						<td>
							<select name="pspecBuy">
								<option value="1" selected="seclected">��</option>
								<option value="2">��</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">��ƷͼƬ��</td>
						<td><input type="file" class="text" name="pfileName" /></td>
					</tr>
					<tr>
						<td class="field">��Ʒ�۸�</td>
						<td><input type="text" class="text tiny" name="pprice" /> Ԫ</td>
					</tr>
					<tr>
						<td class="field">Ʒ�ƣ�</td>
						<td><input type="text" class="text" name="pbrand" /></td>
					</tr>
					<tr>
						<td class="field">��棺</td>
						<td><input type="text" class="text tiny" name="pstock" /></td>
					</tr>
					<tr>
						<td class="field">����ţ�</td>
						<td><input type="text" class="text" name="pcode" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="���" /></label></td>
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