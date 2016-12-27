<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addrecord.jsp' starting page</title>
    
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
        <h1 align = "center">添加记录</h1>
    <hr>
    <form action="${pageContext.request.contextPath }/servlet/Controller?op=addRecord" method="post">
    	<table id = "t1" align = "center">
	    	<tr>
	 			<td nowrap align="right" width="40%">收入：</td>
	 			<td nowrap><input type="text" name = "income"></td>
	 			<td nowrap align="left"><span><font color=red>${error}</font></span></td>
	    	</tr>
	    	<tr>
				<td nowrap align="right">支出：</td>
	 			<td nowrap><input type="text" name = "expend"></td>
	 			<td nowrap></td>
	    	</tr>
	    	 <tr>
				<td nowrap align="right">备注：</td>
	 			<td nowrap><textarea  rows = "5" cols = "21" name = "remark">无备注</textarea></td>
	 			<td nowrap></td>
	    	</tr>
    	</table>
   		<table align = "center">
	    	<tr>
				<td nowrap align = "center">
					<input type="submit" value="添加">&nbsp;
					<input type="button" value="取消" onclick="window.location.href='balancesheet.jsp'">
				</td>
			</tr>
	    </table>
    </form>
  </body>
</html>
