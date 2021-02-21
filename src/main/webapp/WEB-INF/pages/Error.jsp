<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false"%>

<%@ include file="/WEB-INF/pages/common/commonStyling.jsp"%>     

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
<nav role="navigation" class="navbar navbar-inverse">
	<div class="container-fluid">
		
		<ul class="nav navbar-nav">
			<li><a href="logout">Signin</a></li>
		</ul>
	</div>
</nav>

<table class="table table-striped">
	<c:forEach items="${message}" var="message">
		<tr>
			<td class="alert alert-danger">${message}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>