<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
    <h1 align = "center">用户注册</h1>
    <hr>
    <form action="${pageContext.request.contextPath }/servlet/Controller?op=confirmRegister" method="post">
    	<table id = "t1" align = "center">
	    	<tr>
				<td nowrap align="right" width="40%">邮箱：</td>
	 			<td nowrap><input type="text" name = "email" value= "${user.email }"></td>
	 			<td nowrap align="left"><span><font color=red>${user.errors.email }</font></span></td>
	    	</tr>
	    	<tr>
				<td nowrap align="right">密码：</td>
	 			<td nowrap><input type="password" name = "password"></td>
	 			<td align="left"><span><font color=red>${user.errors.password }</font></span></td>
	    	</tr>
	    	<tr>
				<td nowrap align="right">确认密码：</td>
	 			<td nowrap><input type="password" name = "repassword"></td>
	 			<td nowrap align="left"><span><font color=red>${user.errors.repassword }</font></span></td>
	    	</tr>
	    	<tr>
				<td nowrap align="right">姓名：</td>
	 			<td nowrap><input type="text" name = "name" value= "${user.name }"></td>
	 			<td nowrap align="left"><span><font color=red>${user.errors.name }</font></span></td>
	    	</tr>
	    	<tr>
				<td nowrap align="right">电话：</td>
	 			<td nowrap><input type="text" name = "cellphone" value= "${user.cellphone }"></td>
	 			<td nowrap align="left"><span><font color=red>${user.errors.cellphone }</font></span></td>
	    	</tr>
	    </table>
	    <table align = "center">
	    	<tr>
				<td nowrap align = "center">
					<input type="submit" value="注册">&nbsp;
					<input type="button" value="取消" onclick="window.location.href='login.jsp'">
				</td>
			</tr>
	    </table>
    </form>
  </body>
</html>
