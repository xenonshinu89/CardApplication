<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored = "false" %>
    
<%@ include file="common/Navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
 <h2  style="display:none;">${ sessionScope.userId }  </h2>
 <h2 style="display:none;">${   userDetails.id   }</h2>
 <h2 class="alert alert-success">Welcome ${   sessionScope.uName   } !!</h2>
 
 <table>
	<c:forEach items="${message}" var="message">
		<tr>
			<td class="alert alert-danger">${message}</td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>