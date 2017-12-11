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
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
</script>
</head>
<body>
	<div class="main">
			<div class="optitle clearfix">
				<div class="title">用户管理&gt;&gt;</div>
	
			</div>
			
			<s:form action="uploadPhotoUser" namespace="/" method="post" enctype="multipart/form-data">
				<div class="content">
					<table class="box">
						<s:textfield label="用户名" name="user.userName" cssClass="text"/>
						<s:password label="密码" name="user.userPassword" cssClass="text"/>
						<s:radio label="性别" name="user.userSex" list="#{'M':'男','F':'女' }" value="'M'" ></s:radio>
						<s:textfield label="年龄" name="user.userAge" cssClass="text"/>
						<s:textfield label="电话" name="user.telephone" cssClass="text"/>
						<s:textfield label="地址" name="user.address" cssClass="text"/>
						<s:radio label="权限" name="user.type" list="#{1:'经理',0:'普通用户' }" value="1" ></s:radio>
						<s:file label="头像" name="userPhoto"></s:file>
						<s:submit value="添加" cssClass="input-button"></s:submit>
					</table>
				</div>
			</s:form>
		</div>
</body>
</html>
