<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/global.css" rel="stylesheet" type="text/css"/>
        <title>File Upload</title>
    </head>
    
    <body>
        <div class="headContainer">
            <div class="header"></div>
        </div>
        
        <div class="mainContainer">
            <div>
                <form id="fileUpload" name="fileUpload" method="post" enctype="multipart/form-data" action="FileUpload">
                    <label>Simple Field : </label><input id="simpleField" name="simpleField" type="text" />
                    <br />
                    <label>Upload Files : </label><input type="file" name="fileUpload" />
                    <br />
                    <input type="submit" value="Submit" />
                    <input type="reset" value="Reset" />
                </form>
            </div>
            <div id="echo">
                <img src="${imgUrl}" />
                <br />
                <span id="fullFilePath">${fullFilePath}</span>
                <br />
                <span id="simpleField">${simpleField}</span>
            </div>
        </div>
        
        <div class="footContainer">
            <div class="footer"></div>
        </div>
    </body>
</html>