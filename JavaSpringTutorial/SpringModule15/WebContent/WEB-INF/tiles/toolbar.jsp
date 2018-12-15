<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	

<c:choose>
	<c:when test="${hasOffer}">
			<a href="${pageContext.request.contextPath}/createoffer">Edit or delete your current Offer</a>
	</c:when>
	<c:otherwise>
		<a href="${pageContext.request.contextPath}/createoffer">Add a new offer.</a>
	</c:otherwise>
</c:choose>
&nbsp;
<sec:authorize access="hasRole('ADMIN')">
		<a href="${pageContext.request.contextPath}/admin">Admin</a>
</sec:authorize>
&nbsp;
<sec:authorize access="isAuthenticated()">
		<a href="${pageContext.request.contextPath}/messages">Messages (<span id="numberMessages">0</span>)</a>
</sec:authorize>