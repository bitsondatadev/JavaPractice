<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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