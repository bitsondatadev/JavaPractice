<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h3>Create New Account</h3>

<sf:form id="details" method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">
	<table class="formTable">
	<tr><td class="label">Username: </td><td><sf:input class="control" type="text" path="username" name="username" /><div class="error"><sf:errors path="username"></sf:errors></div></td></tr>
	<tr><td class="label">Name: </td><td><sf:input class="control" type="text" path="name" name="name" /><div class="error"><sf:errors path="name"></sf:errors></div></td></tr>
	<tr><td class="label">Email: </td><td><sf:input class="control" type="text" path="email" name="email" /><div class="error"><sf:errors path="email"></sf:errors></div></td></tr>
	<tr><td class="label">Password: </td><td><sf:input id="password" class="control" type="password" path="password" name="password" /><br/><div class="error"><sf:errors path="password"></sf:errors></div></td></tr>
	<tr><td class="label">Confirm Password: </td><td><input id="confirmpass" class="control" type="password" name="confirmpass" /><div id="matchpass"></div></td></tr>
	<tr><td class="label"></td><td><input class="control" type="submit" value="Create Account" /></td></tr>
	</table>
</sf:form>
