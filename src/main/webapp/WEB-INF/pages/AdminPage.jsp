<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false"%>
    
<%@ include file="/WEB-INF/pages/common/commonStyling.jsp"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
<nav role="navigation" class="navbar navbar-inverse">
	<div class="container-fluid">
		
		<ul class="nav navbar-nav">
			<li><a href="logout">Logout</a></li>
		</ul>
	</div>
</nav>

<h2 style="display:none;">${ sessionScope.userId }  </h2>
<h2 class="alert alert-success">Welcome ${   sessionScope.uName   } !!</h2>

<table class="table table-striped">
	<c:forEach items="${message}" var="message">
		<tr>
			<td class="alert alert-danger">${message}</td>
		</tr>
	</c:forEach>
</table>

<table class="table table-striped">
	<tr>
		<td width="15%">Card Id</td>
		<td width="15%">CardHolder Name</td>
		<td width="15%">Card Number</td>
		<td width="15%">Expiry Year</td>
		<td width="15%">Expiry Month</td>
		<td width="20%">Added By</td>
	</tr>

	<c:forEach items="${allUserCardDetails}" var="allUserCardDetails">
		<tr>
			<td >${allUserCardDetails[0]}</td>
			<td >${allUserCardDetails[1]}</td>
			<td >${allUserCardDetails[2]}</td>
			<td >${String.valueOf(allUserCardDetails[3]).split('-')[0]}</td>
			<td >${String.valueOf(allUserCardDetails[3]).split('-')[1]}</td>
			<td >${allUserCardDetails[5]}</td>
		</tr>
	</c:forEach>
</table>


</body>
</html>