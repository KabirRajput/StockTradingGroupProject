<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Booked Trades</title>
</head>
<body>
    <h2>Account Positions</h2>
    <table class="table table-striped">
        <tr>
			<th scope="col">Asset Symbol</th>
			<th scope="col">Account Id</th>
			<th scope="col">Quantity</th>
        </tr>
       <c:forEach items="${positions}" var="position">
					<tr>
						<td><c:out value="${position.assetSymbol}"></c:out></td>
						<td><c:out value="${position.accountId}"></c:out></td>
						<td><c:out value="${position.quantity}"></c:out></td>
					</tr>
				</c:forEach>
    </table>
</body>
</html>