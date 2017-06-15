<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<sf:form method="post" action="${pageContext.request.contextPath}/doCreate" commandName="offer">
	<table class="formTable">
	<tr><td class="label">Name: </td><td><sf:input class="control" type="text" path="name" name="name" /><br/><sf:errors path="name" cssClass="error"></sf:errors></td></tr>
	<tr><td class="label">Email: </td><td><sf:input class="control" type="text" path="email" name="email" /><br/><sf:errors path="email" cssClass="error"></sf:errors></td></tr>
	<tr><td class="label">Your Offer: </td><td><sf:textarea class="control" path="text" rows="10" cols="10" name="text"/><br/><sf:errors path="text" cssClass="error"></sf:errors></td></tr>
	<tr><td class="label"></td><td><input class="control" type="submit" value="Create Offer" /></td></tr>
	</table>
</sf:form>
