<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<div id="position" class="wrap">
	�����ڵ�λ�ã�<a href="index.jsp">������</a> &gt; ���ﳵ
</div>
<div class="wrap">
	<div id="shopping">
		<form action="ShoppingServlet" method="post">
			<input type="hidden" name="username" value="${name }" />
			<input type="hidden" name="addr" value="${addr }" />
			<input type="hidden" name="userid" value="${userid }" />
			<table id="tb">
			
			</table>
			<div class="button" id="button"><input onclick="delAllCookie()" type="submit" value="" /></div>
		</form>
	</div>
	<script type="text/javascript">
		
		if(!getCookie("pname")){
			document.getElementById("button").style.display="none";
		}else {
			shopHtml();
		}
		function shopHtml() {
			var pnameCookie = getCookie("pname").split(",");
			var ppriceCookie = getCookie("pprice").split(",");
			var pcodeCookie = getCookie("pcode").split(",");
			var pidCookie = getCookie("pid").split(",");
			var pfileNameCookie = getCookie("pfileName").split(",");
			var str = "";
			str += '<tr>';
			str += '<th>��Ʒ����</th>';
			str += '<th>��Ʒ�۸�</th>';
			str += '<th>��������</th>';
			str += '<th>����</th>';
			str += '</tr>';
			// �ύ����ƷƷ������
			str += '<input type="hidden" id="pcnt" name="pcnt" value="'+pidCookie.length+'">';
			// document.write(pidCookie.length);
			for (var i =0; i< pidCookie.length; i++){
				var pname = pnameCookie[i];
				var pprice = ppriceCookie[i];
				var pcode = pcodeCookie[i];
				var pid = pidCookie[i];
				var pfileName = pfileNameCookie[i];
				// �ض�������Ʒid
				str += '<input type="hidden" id="pid'+i+'" name="pid'+i+'" value="'+pid+'">';
				// �ض���Ʒ�ܼ۸�
				str += '<input type="hidden" id="pcost'+i+'" name="pcost'+i+'" value="'+pprice+'">';
				str += '<tr id="product_id_'+i+'">';
					str += '<td class="thumb"><img src="images/product/'+pfileName+'" /><a href="ProductViewServlet?pid='+pid+'">'+pname+'</a></td>';
					str += '<td class="price" id="price_id_'+i+'">';
						str += '<span>��'+pprice+'</span>';
						str += '<input type="hidden" value="'+pprice+'" />'
					str += '</td>';
					str += '<td class="number">';
						str += '<dl>';
							// �ض�������Ʒ����
							str += '<dt><input id="number_id_'+i+'" type="text" name="cnt'+i+'" value="1" /></dt>';
							str += '<dd onclick="reloadPrice('+i+',true);">�޸�</dd>';
						str += '</dl>';
					str += '</td>';
					str += '<td class="delete"><a href="javascript:delShopping('+i+');">ɾ��</a></td>';
				str += '</tr>';
			}
			document.getElementById("tb").innerHTML=str;
		}
	</script>
</div>
<jsp:include page="footer.jsp"/>
