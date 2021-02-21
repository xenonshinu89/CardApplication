<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored = "false"%>
    
<%@ include file="/WEB-INF/pages/common/commonStyling.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Card Details Application</title>
	</head>

	<body>
	<h2>Login Page!</h2>
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
	<form action="loginPage" method="post">
	<div class="form-group">
		User Name : <input type="text" name="username" />
	</div>
	<div class="form-group">
		Password  : <input type="password" name="password"/>
	</div>
	<div class="form-group">
		<input class="btn btn-warning" type="submit" />
	</div>
	</form>
	<a class="btn btn-warning" href="registerPage">Register New User!!</a>
	</div>
	</div>
	<div class="col-sm-4"></div>
	</div>
	</body>
</html>
