<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
      function doit(flag,id){
    	  if(confirm("确认删除吗?")!=true){
    		  return;
    	  }
      }
</script>
</head>
<body>
<div class="menu">
		<table>
			<tbody>
				<tr>
					<td><form method="post" action="user.do">
							<input name="flag" value="search" class="input-text"
								type="hidden"> 用户名称：<input name="userName"
								class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;
							<input value="查 询" type="submit">
						</form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加用户" class="input-button"
				onclick="window.location='jsp/userAdd.jsp'" type="button"></em>
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
						<td width="80"><div class="STYLE1" align="center">用户名称</div></td>
						<td width="100"><div class="STYLE1" align="center">性别</div></td>
						<td width="100"><div class="STYLE1" align="center">年龄</div></td>

						<td width="150"><div class="STYLE1" align="center">电话</div></td>
						<td width="150"><div class="STYLE1" align="center">地址</div></td>
						<td width="150"><div class="STYLE1" align="center">权限</div></td>
					</tr>

					<tr>
						<td height="23"><span class="STYLE1">1</span></td>
						<td><span class="STYLE1"><a href="#"
								onclick="doit('mod',1)">admin</a></span></td>

						<td><span class="STYLE1"> 女 </span></td>
						<td><span class="STYLE1">0</span></td>
						<td><span class="STYLE1">0</span></td>
						<td><span class="STYLE1"></span></td>
						<td><span class="STYLE1">&nbsp; </span></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>