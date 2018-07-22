<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<a class="title" href='<c:url value="/"></c:url>'>Offers</a>

<sec:authorize access="!isAuthenticated()">
	<c:url var="loginUrl" value="/login" />
	<form class="login" action="${loginUrl}" method="post">
		<input type="submit" value="Log in" /> <input
			type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<c:url var="logoutUrl" value="/logout" />
	<form class="login" action="${logoutUrl}" method="post">
		<input type="submit" value="Log out" /> <input
			type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</sec:authorize>