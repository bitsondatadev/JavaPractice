<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta name="_csrf" content="${_csrf.token}"/> 
<!-- default header name is X-CSRF-TOKEN --> 
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<div id="messages"></div>


<script type = "text/javascript">
	var timer;
	
	function showReply(i){
		stopTimer();
		$("#replyForm" + i).toggle();
	}
	
	function sendMessage(i, name, email){
		var text = $("#replyTextArea" + i).val();
		$.ajax({
			type : 'POST',
			url : '<c:url value="/sendmessage"/>',
			data : JSON.stringify({"target": i, "text" : text, "name" : name, "email" : email}),
			success : function(data){
				startTimer();
				$("#replyForm" + data.target).toggle();
				$("#alert" + data.target).text("Message Sent!");
			},
			error : function(data){
				alert("Error Sending Message");
			},
			contentType : "application/json",
			dataType : "json",
			headers: {'X-CSRF-Token' : $("meta[name='_csrf']").attr("content")}
		});
	}
	
	function showMessages(data){
		$("#messages").html("");
		
		for(var i = 0; i < data.messages.length; i++){
			var message = data.messages[i];
			var messageDiv = document.createElement("div");
			messageDiv.setAttribute("class", "message");
			
			var subjectSpan = document.createElement("span");
			subjectSpan.setAttribute("class", "subject");
			subjectSpan.appendChild(document.createTextNode(message.subject));
			
			var contentSpan = document.createElement("span");
			contentSpan.setAttribute("class", "messageBody");
			contentSpan.appendChild(document.createTextNode(message.content));
			
			var nameSpan = document.createElement("span");
			nameSpan.setAttribute("class", "name");
			nameSpan.appendChild(document.createTextNode(message.name + "("));
			var link = document.createElement("a");
			link.setAttribute("class", "replyLink");
			link.setAttribute("href", "#")
			link.setAttribute("onclick", "showReply(" + i + ")");
			link.appendChild(document.createTextNode(message.email));
			nameSpan.appendChild(link);
			nameSpan.appendChild(document.createTextNode(")"));
			
			var alertSpan = document.createElement("span");
			alertSpan.setAttribute("class", "alert");
			alertSpan.setAttribute("id", "alert" + i);
			//alertSpan.appendChild(document.createTextNode("Message sent"));
			
			var replyForm = document.createElement("form");
			replyForm.setAttribute("class", "replyForm");
			replyForm.setAttribute("id", "replyForm" + i)
			
			var textArea = document.createElement("textArea");
			textArea.setAttribute("class", "replyArea");
			textArea.setAttribute("id", "replyTextArea" + i)
			
			var replyButton = document.createElement("input");
			replyButton.setAttribute("class", "replyButton");
			replyButton.setAttribute("type", "button");
			replyButton.setAttribute("value", "Reply");
			
			replyButton.onclick = function(j, name, email){
				return function(){
					sendMessage(j, name, email);
				};
			}(i, message.name, message.email);
			
			replyForm.appendChild(textArea);
			replyForm.appendChild(replyButton);

			messageDiv.appendChild(subjectSpan);
			messageDiv.appendChild(contentSpan);
			messageDiv.appendChild(nameSpan);
			messageDiv.appendChild(alertSpan);
			messageDiv.appendChild(replyForm);
			
			$("#messages").append(messageDiv);
		}
		$("#numberMessages").text(data.number);
		//alert(data.number);
	}
	
	function startTimer(){
		timer = window.setInterval(updatePage, 10 * 1000);
	}
	
	function stopTimer(){
		window.clearInterval(timer);
	}
	
	function onLoad(){
		updatePage();
		startTimer();
	}
	
	function updatePage(){
		$.getJSON("<c:url value='/getmessages'/>", showMessages);
	}
	
	$(document).ready(onLoad);
	
</script>