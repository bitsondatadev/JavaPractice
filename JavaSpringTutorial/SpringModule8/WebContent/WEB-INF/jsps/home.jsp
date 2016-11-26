<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
<p><a href="${pageContext.request.contextPath}/offers">Show current offers.</a></p>
<p><a href="${pageContext.request.contextPath}/createOffer">Add a new offer.</a></p>

<!-- 
Hi There

<p>Session: <\%= session.getAttribute("name") %></p>

<p>Request: <\%= request.getAttribute("name") %></p>

Being done this way <b>name</b> will get bolded and html won't be escaped.
<p>Request (Expressive Language): ${name}</p>
 -->
</body>
</html>