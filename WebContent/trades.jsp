<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
	<h3>Welcome, Please start a trade</h3>
	<form:form method="POST" action="/insertTrade" modelAttribute="trade">
		<table>
			<tr>
				<td><form:label path="assertSymbol">Symbol</form:label></td>
				<td><form:input path="assertSymbol" /></td>
			</tr>
			<tr>
				<td><form:label path="quantity">Quantity</form:label></td>
				<td><form:input path="quantity" /></td>
			</tr>
			<tr>
				<td><form:label path="pricePerShare">Price/Share</form:label></td>
				<td><form:input path="pricePerShare" /></td>
			</tr>
			<tr>
				<td><form:label path="buyerAccount">
                      Buyer Account Id</form:label></td>
				<td><form:input path="buyerAccount" /></td>
			</tr>
			<tr>
				<td><form:label path="sellerAccount">
                      Seller Account Id</form:label></td>
				<td><form:input path="sellerAccount" /></td>
			</tr>
			<tr>
				<td><form:label path="username">
                     Username</form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>