<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
<p><a href="${pageContext.request.contextPath}/offers">Show current offers.</a></p>
<p><a href="${pageContext.request.contextPath}/createOffer">Add a new offer.</a></p>

<sec:authorize access="!isAuthenticated()">
<c:url var="loginUrl" value="/login"/>
<form action="${loginUrl}" method="post">
<input type="submit" value="Log in"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
<c:url var="logoutUrl" value="/logout"/>
<form action="${logoutUrl}" method="post">
<input type="submit" value="Log out"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</sec:authorize>

<sec:authorize access="hasRole('ADMIN')">
<p><a href="${pageContext.request.contextPath}/admin">Admin</a></p>
</sec:authorize>
</form>
<!-- 
Hi There

<p>Session: <\%= session.getAttribute("name") %></p>

<p>Request: <\%= request.getAttribute("name") %></p>

Being done this way <b>name</b> will get bolded and html won't be escaped.
<p>Request (Expressive Language): ${name}</p>
 -->
</body>
</html>