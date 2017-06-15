<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<p><a href="${pageContext.request.contextPath}/offers">Show current offers.</a></p>
<p><a href="${pageContext.request.contextPath}/createoffer">Add a new offer.</a></p>

<sec:authorize access="hasRole('ADMIN')">
<p><a href="${pageContext.request.contextPath}/admin">Admin</a></p>
</sec:authorize>
