<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<div id="main" class="wrap">
	<div class="left-side">
		<div class="news-list">
			<h4>最新公告</h4>
			 <ul>
			    <li style="color:#fc7e31"><b>10月1号国庆长假，全场五折优惠，敬请期待！</b></li>
			   <li style="color:#fc7e31"><b>庆中秋佳节，今日起三天，女装一折!</b></li>
			   <li style="color:#fc7e31"><b>潮牌好货，爱购你就来！</b></li>
			 </ul>
		</div>
		<div class="spacer"></div>
		<div class="news-list">
			<h4>新闻动态</h4>
			<c:if test="${list==null}">
                                              暂无新闻信息
                 </c:if>
                 <c:if test="${list!=null}">
                  <ul>
                     <c:forEach items="${list}" var="prd"> 
                       <li><a style="color:#fc7e31" href="fnewsviewServlet?EN_ID=${prd.EN_ID}" target="_blank">${prd.EN_TITLE}</a></li>
                     </c:forEach>
                  </ul>
                 </c:if>
		</div>
	</div>
	<div id="news" class="right-main">
	    
		<h1>${news.EN_TITLE}</h1>
		<div class="content">
	       <p>${news.EN_CONTENT}</p>
		</div>
	</div>
	<div class="clear"></div>
</div>
<jsp:include page="footer.jsp"/>
