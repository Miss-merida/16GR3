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
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="menu">
</div>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<form method="post" action="goods?cmd=getGoodsInfo">
		<div class="content">
			<table class="box">
				<tr>
					<td class="field">商品名称：</td>
					<td><input type="text" name="goodsName" class="text" /></td>
				</tr>
				<tr>
					<td class="field">交易数量：</td>
					<td><input type="text" name="businessNum" class="text" /></td>
				</tr>
				<tr>
					<td class="field">供应商：</td>
					<td>
					<select name="providerId">
						<c:forEach items="${providers }" var="provider">
							<option selected="selected" 
							        value="${provider.providerId }">${provider.providerName }
							</option>
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
			<input type="submit" name="submit" value="确认" class="input-button" />
			<input type="button" name="button" value="返回" class="input-button"
				onclick="history.back();" />
		</div>
	</form>
</div>
</body>
</html>