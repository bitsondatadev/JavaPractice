<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h3>Send Message</h3>

<sf:form method="post" commandName="message">
	
	<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
	<input type="hidden" name="_eventId" value="send" />
	
	<table class="formTable">
		<tr>
			<td class="label">Your Name:</td>
			<td><sf:input class="control" type="text" path="name"
					name="name" value="${fromName}" />
				<div class="error">
					<sf:errors path="name"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Your Email:</td>
			<td><sf:input class="control" type="text" path="email"
					name="email" value="${fromEmail}"/>
				<div class="error">
					<sf:errors path="email"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Subject:</td>
			<td><sf:input class="control" type="text" path="subject"
					name="subject" />
				<div class="error">
					<sf:errors path="subject"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Your Message:</td>
			<td><sf:textarea class="control" type="text" path="content"
					name="content" />
				<div class="error">
					<sf:errors path="content"></sf:errors>
				</div></td>
		</tr>

		<tr>
			<td class="label"></td>
			<td><input class="control" type="submit" value="Send Message" /></td>
		</tr>
	</table>
</sf:form>
