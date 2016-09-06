// JavaScript Document
// window.onload=function(){
	 
  function hasclass(obj,cls){
	  //ÊòØÂê¶ÊúâËøô‰∏™class
	  return obj.className.match(new RegExp("(\\s|^)"+cls+"(\\s|$)"));
	   
	  }
  function removeClass(obj,cls){
	  if(hasclass(obj,cls)){
	      //removeclass
		  var reg=new RegExp("(\\s|^)"+cls+"(\\s|$)"); 
		  obj.className=obj.className.replace(reg,"");
	  }
  }
  function addClass(obj,cls){
	  if(!hasclass(obj,cls)){
		 //addclass
		 obj.className+= " " +cls;
	  }
	  }
	  console.log("Ω¯»Îjs");
	 // console.log("currentId");
    var menus=document.getElementById("menu").getElementsByTagName("li");
	var index=document.getElementById("submenus").innerHTML;
	console.log(document.getElementById("submenus").innerHTML);
    for(var i=0;i<menus.length;i++){
	   menus[i].onmouseover=function(){
	      for(var j=0;j<menus.length;j++){
			  removeClass(menus[j],"current");
			  }
		  addClass(this,"current");
		  if(this==menus[1]){
			   document.getElementById("submenus").innerHTML='<ul class="clearfix"><li class="first"><a href="#">1.1</a></li>'+
			'<li><a href="#">1.2</a></li><li><a href="#">1.3</a></li><li><a href="#">1.4</a></li><li><a href="#">1.5</a></li>'+
			'<li><a href="#">1.6</a></li><li><a href="#">1.7</a></li>';
		  }else if(this==menus[2]){
			   document.getElementById("submenus").innerHTML='<ul class="clearfix"><li class="first"><a href="#">2.1</a></li>'+
			'<li><a href="#">2.2</a></li><li><a href="#">2.3</a></li><li><a href="#">2.4</a></li><li><a href="#">2.5</a></li>'+
			'<li><a href="#">2.6</a></li><li><a href="#">2.7</a></li>';
		  }else if(this==menus[3]){
			   document.getElementById("submenus").innerHTML='<ul class="clearfix"><li class="first"><a href="#">3.1</a></li>'+
			'<li><a href="#">3.2</a></li><li><a href="#">3.3</a></li><li><a href="#">3.4</a></li><li><a href="#">3.5</a></li>'+
			'<li><a href="#">3.6</a></li><li><a href="#">3.7</a></li>';
		  }else if(this==menus[4]){
			   document.getElementById("submenus").innerHTML='<ul class="clearfix"><li class="first"><a href="#">4.1</a></li>'+
			'<li><a href="#">4.2</a></li><li><a href="#">4.3</a></li><li><a href="#">4.4</a></li><li><a href="#">4.5</a></li>'+
			'<li><a href="#">4.6</a></li><li><a href="#">4.7</a></li>';
		  }else {
			  document.getElementById("submenus").innerHTML=index;
		  }
	} 
		  
}
		
		
	
	 
 
 //}
 