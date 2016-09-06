<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<div id="footer">
	Copyright &copy; 2010 LOL All Rights Reserved. ICP-1000001
</div>
</body>
<!--<script type="text/javascript" src="scripts/menu.js"></script>  
-->
<script type="text/javascript">
	var mainMenu = document.getElementById("mainMenu").getElementsByTagName("li");
	var subMenu = document.getElementById("subMenu").getElementsByTagName("ul");
     for(var i = 0; i < 5; i++){
		mainMenu[i].onclick= (function(num) {
			  return function(){
			  resetliul();
		      this.className = "current";
			  console.log(num);
			  subMenu[num].style.display="block";
			  }
		   })(i);

			//正则表达式
		 	/*
		 	resetliul();
		 	this.className = "current";
		    console.log(num);
		    console.log(subMenu[0]);
	        subMenu[num].style.display="block";
		 	
		 	
		 	var pattern=new RegExp('首页');
			console.log(pattern.test(inner));
			if(pattern.test(inner)){
				   alert("这是首页");
				   subMenu[0].style.display="block";
				}*/
	}
	
	function resetliul(){
		for(var i = 0; i< 5; i++){
			mainMenu[i].className = "";
			subMenu[i].style.display="none";
	}
	}
</script> 
</html>
