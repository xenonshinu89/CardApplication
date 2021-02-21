<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false"%>
    
<%@ include file="common/Navigation.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Cards</title>

</head>
<body>

<h2 style="display:none;">${ sessionScope.userId }  </h2>
<h2 class="alert alert-success">Welcome ${   sessionScope.uName   } !!</h2>

<table>
	<c:forEach items="${message}" var="message">
		<tr>
			<td class="alert alert-danger">${message}</td>
		</tr>
	</c:forEach>
	</table>
	
	<div class="row">
  	<div class="col-sm-4"></div>
  	<div class="col-sm-4">
	<div class="container">
	<form action="addCardDetails" method="post">
	<div class="form-group">
		Cardholder Name : <input type="text" name="cardholderName" />
	</div>
	<div class="form-group">
		Card Number  : <input type="text" name="cardNo"/>
	</div>
	<div class="form-group">
		Expiry Date(YY/MM)  :<input type="text" name="year"/>/<input type="text" name="month"/>
	</div>
	<div class="form-group">
		<input type="Submit" value="Add Card"/>
	</div>
	</form>
	</div>
	</div>
	<div class="col-sm-4"></div>
	</div>

</body>
</html>