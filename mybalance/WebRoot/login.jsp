<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#t1{
			border:1px solid gray;
			width:900px;
		}
	</style>
  </head>
  
  <body>
    <h1 align = "center">用户登录</h1>
    <hr>
    <form action="${pageContext.request.contextPath }/servlet/Controller?op=confirmLogin" method="post">
    	<table id = "t1" align = "center">
	    	<tr>
				<td nowrap align="right" width="40%">邮箱：</td>
	 			<td nowrap><input type="text" name = "email" value= "${email }"></td>
	 			<td nowrap align="left"><span><font color=red>${error}</font></span></td>
	    	</tr>
	    	<tr>
				<td nowrap align="right">密码：</td>
	 			<td nowrap><input type="password" name = "password"></td>
	 			<td nowrap></td>
	    	</tr>

	    </table>
	    <table align = "center">
	    	<tr>
				<td nowrap align = "center">
					<input type="submit" value="登录">&nbsp;
					<input type="button" value="注册" onclick="window.location.href='register.jsp'">
				</td>
			</tr>
	    </table>
    </form>
  </body>
</html>
