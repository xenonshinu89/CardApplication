
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored = "false"%>

<%@ include file="common/Navigation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Card Details</title>
</head>
<body>
<div id="demo" >
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
<td><h2>Search Card</h2></td>
<td><input id="searchText" type="text" value="${searchVar}" name="searchCardValue"/></td>
<td><a id="searchLink" href="#" style="display:none;"></a><button class="btn btn-warning" onclick="searchCardDetails()">Search Card</button></td>
</tr>
</table>

<table class="table table-striped">
	<tr>
		<td width="30%">CardHolder Name</td>
		<td width="30%">Card Number</td>
		<td width="15%">Expiry Year</td>
		<td width="15%">Expiry Month</td>
		<td width="10%">Update</td>
	</tr>

	<c:forEach items="${userCardDetails}" var="userCardDetails">
		<tr>
			<td id="cardHolderName${userCardDetails.cardId}">${userCardDetails.cardHolderName}</td>
			<td id="cardNumber${userCardDetails.cardId}">${userCardDetails.cardNumber}</td>
			<td><input id="expiryYear${userCardDetails.cardId}" type="text" value="${userCardDetails.expiryDate.split('-')[0]}" name=""/></td>
			<td><input id="expiryMonth${userCardDetails.cardId}" type="text" value="${userCardDetails.expiryDate.split('-')[1]}" name=""/></td>
			<td><a id="link${userCardDetails.cardId}" style="display:none;" href="#"></a><button class="btn btn-warning" onclick="updatePopulate(${userCardDetails.cardId})">Update</button>
			<a class="btn btn-warning" href="deleteCardDetails?cardId=${userCardDetails.cardId}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
</div>

<script>
function updatePopulate(cardId) {
	
  var cId=cardId;
  var cHN=document.getElementById("cardHolderName"+cardId).innerHTML;
  var cN=document.getElementById("cardNumber"+cardId).innerHTML;
  var cEY=document.getElementById("expiryYear"+cardId).value;
  var cEM=document.getElementById("expiryMonth"+cardId).value;
  document.getElementById("link"+cardId).href="updateCardDetails?cardId="+cId+"&cardHolderName="+cHN+"&cardNumber="+cN+
  "&cardExpiryYear="+cEY+"&cardExpiryMonth="+cEM;
  document.getElementById("link"+cardId).click();
  
}

function searchCardDetails(){
	
	var searchText=document.getElementById("searchText").value;
	document.getElementById("searchLink").href="searchCardDetails?searchText="+searchText;
	document.getElementById("searchLink").click();
}
</script>

</body>
</html>