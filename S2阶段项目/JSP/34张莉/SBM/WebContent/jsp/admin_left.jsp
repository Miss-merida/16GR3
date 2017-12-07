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
<body class="frame-bd">
	<ul class="left-menu">
		<li>
			<a href="jsp/admin_bill_list.jsp" target="mainFrame">
				<img src="images/btn_bill.gif" />
			</a>
		</li>
		
		<c:if test="${user.type == 0}">
			<li>
				<a href="jsp/providerAdmin.jsp"  target="mainFrame">
					<img src="images/btn_suppliers.gif" />
				</a>
			</li>
			<li>
				<a href="jsp/userAdmin.jsp"  target="mainFrame">
					<img src="images/btn_users.gif" />
				</a>
			</li>
		</c:if>
		<li>
			<a href="user?cmd=exit">
				<img src="images/btn_exit.gif" />
			</a>
		</li>
	</ul>
</body>
</html>
