<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<jsp:include page="header.jsp"/>
	<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>��ӭע��������<c:if test="${regstatus ==1}">����Ϣ��д������������д��</c:if></h1>
			<ul class="steps clearfix">
				<li class="current"><em></em>��дע����Ϣ</li>
				<li class="last"><em></em>ע��ɹ�</li>
			</ul>
			<form id="regForm" method="post" action="registservlet" onsubmit="return checkForm(this);">
				<table>
					<tr>
						<td class="field">�û�����</td>
						<td><input class="text" type="text" name="userName" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">�Ա�</td>
						<td>��<input style="width:20px;" class="text" type="radio" value="��" name="sex" onfocus="FocusItem(this)" onblur="CheckItem(this);" />
							Ů<input style="width:20px;" class="text" type="radio" name="sex" value="Ů" onfocus="FocusItem(this)" onblur="CheckItem(this);" />
						<span></span></td>
					</tr>
					<tr>
						<td class="field">���գ�</td>
						<td><input type="text" name="birth" class="Wdate" readonly="readonly" value="${use.birthday }" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  />
						<span></span></td>
					</tr>
					<tr>
						<td class="field">��¼���룺</td>
						<td><input class="text" type="password" id="passWord" name="passWord" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">ȷ�����룺</td>
						<td><input class="text" type="password" name="rePassWord" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">�ջ���ַ��</td>
						<td><input class="text" type="text" name="address" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">��֤�룺</td>
						<td><input class="text verycode" type="text" name="veryCode" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><img id="veryCode" src="" /><span></span></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" value="�ύע��" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<jsp:include page="footer.jsp"/>
