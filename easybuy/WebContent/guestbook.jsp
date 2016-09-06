<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
	<div id="main" class="wrap">
	<jsp:include page="sider.jsp"/>
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			  <c:if test="${list==null}">
                                              暂无留言信息
             </c:if>
             <c:if test="${list!=null}">
			  <ul>
			   <c:forEach items="${list}" var="prd">
				<li style="border:1px solid #ccc">
					<dl>
						<dt>${prd.EC_CONTENT}</dt>
						<dd class="author">${prd.EC_NICK_NAME} <span class="timer">${prd.EC_CREATE_TIME} </span></dd>
						<dd><b>回复：</b>${prd.EC_REPLY}&nbsp <span class="timer">${prd.EC_REPLY_TIME} </span></dd>
					</dl>
				</li>
			   </c:forEach> 
			 </ul>
			 </c:if>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					<li align="center"> ${pageStr }</li>
				</ul>
			</div>
			<div id="reply-box">
				<form method="post" action="fcommentaddServlet">
					<table>
						<tr>
							<td class="field">昵称：</td>
							<td><input class="text" type="text" name="guestName" /></td>
						</tr>
						<tr>
							<td class="field">留言标题：</td>
							<td><input class="text" type="text" name="guestTitle" /></td>
						</tr>
						<tr>
							<td class="field">留言内容：</td>
							<td><textarea name="guestContent"></textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit" name="submit" value="提交留言" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<jsp:include page="footer.jsp"/>