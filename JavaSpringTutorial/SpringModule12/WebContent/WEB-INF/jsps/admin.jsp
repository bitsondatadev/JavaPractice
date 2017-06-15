<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
<title>Insert title here</title>
</head>
<body>
<h3>Authorized Users Only</h3>
<table class="formtable">

<tr><td>Username</td><td>Email</td><td>Role</td><td>Enabled</td></tr>

<c:forEach var="user" items="${users}">
<tr>
<td><c:out value="${user.username}"></c:out></td>
<td><c:out value="${user.email}"></c:out></td>
<td><c:out value="${user.authority}"></c:out></td>
<td><c:out value="${user.enabled}"></c:out></td>
</tr>
</c:forEach>
</table>
</body>
</html>