<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@  taglib  uri="http://java.sun.com/jsp/jstl/functions"   prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
<jsp:include  page="header.jsp"/>
	<jsp:include  page="sider.jsp"/>
	<div class="main">
		<h2>�޸��û�</h2>
		<div class="manage">
			<form action="../UserUpdateServlet" method="post">
				<table class="form">
					<tr>
						<td class="field">�û�����</td>
						<td>
						<input type="hidden" value="${use.id }" name="id"/>
						<input type="text" class="text" name="userName" value="${use.usename}"  /></td>
					</tr>
					<tr>
						<td class="field">������</td>
						<td><input type="text" class="text" name="name" value="${use.name}" /></td>
					</tr>
					<tr>
						<td class="field">���룺</td>
						<td><input type="text" class="text" name="passWord" value="${use.password}" /></td>
					</tr>
					<tr>
						<td class="field">�Ա�</td>
						<td><input type="radio" name="sex" value="${use.sex}" checked="checked" />��
						 <input type="radio" name="sex" value="${use.sex}" />Ů</td>
					</tr>
					<tr>
						<td class="field">�������ڣ�</td>
						<td>
							<input type="text" name="birth" class="Wdate" readonly="readonly" value="${use.birthday}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  />
						</td>
					</tr>
					<tr>
						<td class="field">�ֻ����룺</td>
						<td><input type="text" class="text" name="mobile" value="${use.mobil}" /></td>
					</tr>
					<tr>
						<td class="field">�ͻ���ַ��</td>
						<td><input type="text" class="text" name="address" value="${use.address}" /></td>
					</tr>
					<tr>
						<td class="field">ͷ��</td>
						<td><input type="file" class="text" name="photo" /></td>
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
	mainMenu[1].className = "current";
	function resetliul(){
		for(var i = 0; i< 5; i++){
			mainMenu[i].className = "";
		}
	}
</script>
<jsp:include  page="footer.jsp"/>
