<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登录 - 超市账单管理系统</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body class="blue-style">
	<s:fielderror name="loginFail"></s:fielderror>
	<div id="login">
		<div class="icon"></div>
		<div class="login-box">
			<s:form action="loginUser" namespace="/" method="post">
				<s:textfield label="用户名" name="user.userName" cssClass="input-text"/>
				<s:password label="密码" name="user.userPassword" cssClass="input-text"/>
				<s:submit value="登录" cssClass="input-button"/>
				<s:reset value="重置" cssClass="input-button"/>
			</s:form>
		</div>
	</div>
</body>
</html>
