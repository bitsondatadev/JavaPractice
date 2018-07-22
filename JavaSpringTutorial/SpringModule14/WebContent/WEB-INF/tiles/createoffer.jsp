<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
function onDeleteClick(event){
	
	var doDelete = confirm("Are you sure you want to delete this offer?");
	
	if(doDelete == false){
		event.preventDefault();
	}
}

function onReady(){
	$("#delete").click(onDeleteClick);
}

$(document).ready(onReady);
</script>

<sf:form method="post"
	action="${pageContext.request.contextPath}/doCreate"
	commandName="offer">
	<sf:input type="hidden" name="id" path="id" />
	<table class="formTable">
		<tr>
			<td class="label">Your Offer:</td>
			<td><sf:textarea class="control" path="text" rows="10" cols="10"
					name="text" /><br />
			<sf:errors path="text" cssClass="error"></sf:errors></td>
		</tr>
		<tr>
			<td class="label"></td>
			<td><input class="control" type="submit" value="Save Offer" /></td>
		</tr>
		<c:if test="${offer.id != 0}">
			<tr>
				<td class="label"></td>
				<td><input class="control delete" name="delete" id="delete" type="submit"
					value="Delete This Offer" /></td>
			</tr>
		</c:if>
	</table>
</sf:form>
