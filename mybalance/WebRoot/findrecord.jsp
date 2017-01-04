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
    
    <title>My JSP 'findrecord.jsp' starting page</title>
    
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
		#t2{
			border:1px solid gray;
			border-collapse:collapse;
			font-size:15px;
			text-align:center;
		}
		#t2 td{
			border:1px solid gray;
		}
		#t2 tr:hover{
			background-color: ffccff;
		}
		a{
			text-decoration: none;
		}
	</style>
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/Birthday-Calendar.js"></script>
	
	<script type="text/javascript">
	  	function checkAll(flag){
	  		var ids = document.getElementsByName("ids");
	  		for(var i = 0; i < ids.length; i++){
	  			ids[i].checked = flag;
	  		}
	  	}
	  	
	  	function deleteAllSelected(){
	  		var ids = document.getElementsByName("ids");
	  		var s = "";
	  		for(var i = 0; i < ids.length; i++){
	  			if(ids[i].checked){
	  				s += ids[i].value + ",";
	  			}
	  		}
	  		window.location = "${pageContext.request.contextPath }/servlet/Controller?op=deleteAllSelected&idsStr="+s;
	  		
	  	}
  	
  	</script>
  
  </head>
  
  <body>
    <h1 align = "center">查找记录</h1>
    <hr>
     <form action="${pageContext.request.contextPath }/servlet/Controller?op=confirmFindRecord" method="post">
    	<table id = "t1" align = "center">
    	<tr>
			<td nowrap align="right" width="40%">起始时间：</td>
 			<td nowrap><input type="text" name = "beginTime" onfocus="new Calendar().show(this)" readonly="readonly" value= "${beginTime }"></td>
 			<td nowrap></td>
    	</tr>
    	<tr>
			<td nowrap align="right">结束时间：</td>
 			<td nowrap><input type="text" name = "endTime" onfocus="new Calendar().show(this)" readonly="readonly" value= "${endTime }"></td>
 			<td nowrap></td>
    	</tr>
		</table>
		<table align = "center">
	    	<tr>
				<td nowrap align = "center">
					<input type="submit" value="查找">&nbsp;
					<input type="button" value="取消" onclick="window.location.href='balancesheet.jsp'">
				</td>
			</tr>
	    </table>
	</form>
    <table id = "t1" align = "center">
    	<%-- <tr>
    		<td>
    			<a href="${pageContext.request.contextPath }/addrecord.jsp">添加记录</a>&nbsp;
    			<a href="javascript:deleteAllSelected()">删除已选</a>&nbsp;
    			<a href="${pageContext.request.contextPath }/servlet/Controller?op=gotoBalanceSheet">显示全部</a>&nbsp;
    		</td>
    	</tr> --%>
    	<tr>
    		<td>
    			<table width = "100%" id = "t2">
    				<tr>
    					<td nowrap><input type = "checkbox" id = "selectAll" onclick="checkAll(this.checked)">全选</td>
    					<td nowrap>资产</td>
    					<td nowrap>收入</td>
    					<td nowrap>支出</td>
    					<td nowrap>结余</td>
    					<td nowrap>描述</td>
    					<td nowrap>时间</td>
    					<!-- <td nowrap>操作</td> -->
    				</tr>
    				<c:choose>
    					<c:when test="${empty recordFinded }">
    						<tr>
    							<td colspan="8" align="center">没有数据</td>
    						</tr>
    					</c:when>
	    				<c:otherwise>
	    					<c:forEach items="${recordFinded }" var="record">
	    						<tr>
	    							<td><input type = "checkbox" name = "ids" value="${record.id }"></td>
			    					<td nowrap>${record.assets }</td>
			    					<td nowrap>${record.income }</td>
			    					<td nowrap>${record.expend }</td>
			    					<td nowrap>${record.balance }</td>
			    					<td nowrap>${record.remark }</td>
			    					<td nowrap>${record.optime }</td>
			    					<%-- <td nowrap>
	 					    			<a href="${pageContext.request.contextPath }/servlet/Controller?op=updateRecord&id=${record.id}">修改</a>&nbsp;
	    								<a href="${pageContext.request.contextPath }/servlet/Controller?op=deleteRecord&id=${record.id}">删除</a>
			    					</td> --%>
	    						</tr>
	    					</c:forEach>
	    				</c:otherwise>
    				</c:choose>
    			</table>
    		</td>
    	</tr>
    </table>
    
  </body>
</html>
