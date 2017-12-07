<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Insert title here</title>
</head>
<body>
	<div class="menu">
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<form method="post" action="account?cmd=updateAccount">
			<div class="content">
				<input type="hidden" name="accountId" value="${param.accountId }">
				<table class="box">
					<tr>
						<td class="field">账单编号：</td>
						<td>${param.accountId}</td>
					</tr>
					<tr>
						<td class="field">供应商：</td>
						<td>
						<select name="providerId">
							<c:forEach items="${providers }" var="provider">
								<option selected="selected" value="${provider.providerId }">${provider.providerName }</option>
							</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<td class="field">是否付款：</td>
						<td><select name="isPayed">
								<option selected="selected" value="1">是</option>
								<option value="0">否</option>
						</select></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="button" name="button" value="返回" class="input-button"
					onclick="history.back();" />
				<input type="submit" name="submit" value="修改" class="input-button" />
				<a style="text-decoration: none;" class="input-button" href="account?cmd=deleteAccount&&accountId=${param.accountId }">删除</a>
			</div>
		</form>
	</div>
</body>
</html>