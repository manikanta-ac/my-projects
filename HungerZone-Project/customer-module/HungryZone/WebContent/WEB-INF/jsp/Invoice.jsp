<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/themes/pepper-grinder/jquery-ui.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/jquery-ui.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#form").dialog({
			autoOpen : false,
			height : 500,
			width : 900,
			resizable: false,
			dragable: false,
			modal : true,
			title : "Invoice",
			buttons : {
				Payment : function() {

				},
				Cancel : function() {
					$(this).dialog("close");
				}

			}
		});
		$("#newUser").button().click(function() {
			$("#form").dialog("open");
		});
	});
</script>
</head>
<body>
	<div id="form">
		<form:form name="userRegistration" modelAttribute="invoice">
			<table align="center" style="border-width: 5px; border-style: solid;">
				<tr>
					<th height="20px">Order Items</th>
					<th height="20px">Price</th>
					<th height="20px">Quantity</th>
					<th height="20px">Sub Total</th>
				</tr>
				<tr>
					<td>Veg Pakoda</td>
					<td>100</td>
					<td>5</td>
					<td>500</td>
				</tr>
				<tr>
					<td>Paneer Manchurian</td>
					<td>200</td>
					<td>2</td>
					<td>400</td>
				</tr>
				<tr>
					<td>Instructions <form:textarea path="instructions" />
					</td>
					<td>
					<br>
						<br>
						<table>

							<tr>
								<td>Total</td>
								<td>900</td>
							</tr>
							<tr>
								<td>Discount</td>
								<td>0.0</td>
							</tr>
							<tr>
								<td>Taxes</td>
								<td>0.0</td>
							</tr>
							<tr>
								<td>Container Charges</td>
								<td>0.0</td>
							</tr>
							<tr>
								<td>Delivery Charges</td>
								<td>0.0</td>

							</tr>


						</table>

					</td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
<td>By Placing this Order You agree to the <a href="#">Term and Condition</a></td>
<td>Amount Payable</td>
<td>900.00</td>
				</tr>
				<tr></tr>
				<tr></tr>	
			<td>Cash On Delivery</td>	<td><form:checkbox path="cashOnDelivery"/></td>
				<tr>

				</tr>

			</table>
		</form:form>
	</div>
	<div>
		<button id="newUser">Order</button>
	</div>
</body>
</html>