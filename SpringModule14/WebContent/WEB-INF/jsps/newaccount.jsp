<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	$("#password").keyup(checkPasswordMatch);
    $("#confirmpass").keyup(checkPasswordMatch);
	$("#details").submit(function(){
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();
		return password == confirmpass;
	});
});
function checkPasswordMatch(){
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();
	if(password.length > 6 && confirmpass.length > 6){
		if(password == confirmpass){
			$("#matchpass").text("<fmt:message key='MatchedPasswords.user.password' />");
			$("#matchpass").addClass("valid");
			$("#matchpass").removeClass("error");
		}else{
			$("#matchpass").text("<fmt:message key='UnmatchedPasswords.user.password' />");
			$("#matchpass").addClass("error");
			$("#matchpass").removeClass("valid");
		}
	}
	
}


</script>
<title>Create New Account</title>
</head>
<body>

<h3>Create New Account</h3>

<sf:form id="details" method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">
	<table class="formTable">
	<tr><td class="label">Username: </td><td><sf:input class="control" type="text" path="username" name="name" /><div class="error"><sf:errors path="username"></sf:errors></div></td></tr>
	<tr><td class="label">Email: </td><td><sf:input class="control" type="text" path="email" name="email" /><div class="error"><sf:errors path="email"></sf:errors></div></td></tr>
	<tr><td class="label">Password: </td><td><sf:input id="password" class="control" type="password" path="password" name="password" /><br/><div class="error"><sf:errors path="password"></sf:errors></div></td></tr>
	<tr><td class="label">Confirm Password: </td><td><input id="confirmpass" class="control" type="password" name="confirmpass" /><div id="matchpass"></div></td></tr>
	<tr><td class="label"></td><td><input class="control" type="submit" value="Create Account" /></td></tr>
	</table>
</sf:form>


</body>
</html>