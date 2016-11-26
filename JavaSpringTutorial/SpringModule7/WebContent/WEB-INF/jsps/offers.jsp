<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Required JSTL tags!!-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<sql:query var="rs" dataSource="jdbc/springJdniDBConnection">
select id, name, email,text from offers
</sql:query>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Offers</title>
</head>
<body>

<c:forEach var="offer" items="${offers}">
      <p><c:out value="${offer}"></c:out></p>
</c:forEach>

<!-- However using jstl the <b>name</b> is escaped to literals and not bolded. 
<c:out value="${name}"></c:out>

  <h2>Results</h2>

<c:forEach var="row" items="${rs.rows}">
      Id ${row.id}<br/>
    Name ${row.name}<br/>
    Email ${row.email}<br/>
    Text ${row.text}<br/>
</c:forEach>
-->



</body>
</html>