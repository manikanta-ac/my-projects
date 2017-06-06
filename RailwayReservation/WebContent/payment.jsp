<html>
<head>
<link rel='stylesheet' href='style/style.css'>
<script language='javascript' src='javascript/payValidate.js'></script>
</head>
<body>
	<%
	double totalCost = (Double)session.getAttribute("totalCost");
	String s1 = request.getParameter("number");
	String msg = "";
	System.out.println("Number---------"+s1);
	if(s1!=null)
	{
	%>
	<jsp:useBean id="card" class="com.pratian.bean.PaymentBean"></jsp:useBean>
	<jsp:setProperty property="*" name="card"/>
	<%
		if(card.authenticate())
		{
			%>
			<jsp:forward page="success.jsp"></jsp:forward>
			<%
		}
		else
		{
			msg = "Invalid Card Details";
		}
	}
	%>
<form target="body" method='post' onsubmit='return payValidate()'>
<pre class="login">			Total Amount :<%= totalCost %><br> 
	Credit Card Number		<input type='text' name='number' id='num'> 
	Credit Card Holder Name		<input type='text' name='name' id='name'> 
	Credit Card Expiry Date		<select name='month' id='month'>
		<option value='MM' selected>MM</option>
		<option value='1'>1</option>
		<option value='2'>2</option>
		<option value='3'>3</option>
		<option value='4'>4</option>
		<option value='5'>5</option>
		<option value='6'>6</option>
		<option value='7'>7</option>
		<option value='8'>8</option>
		<option value='9'>9</option>
		<option value='10'>10</option>
		<option value='11'>11</option>
		<option value='12'>12</option>
	</select>/<select name='year' id='year'>
		<option value='YY' selected>YY</option>
		<option value='2008'>08</option>
		<option value='2009'>09</option>
		<option value='2010'>10</option>
		<option value='2011'>11</option>
		<option value='2012'>12</option>
		<option value='2013'>13</option>
		<option value='2014'>14</option>
		<option value='2015'>15</option>
		<option value='2016'>16</option>
		<option value='2017'>17</option>
		<option value='2018'>18</option>
		<option value='2019'>19</option>
	</select>
	<input class="s1" type="text" readonly style="border: 0" value="<%= msg %>">
				<input type='submit' value='Pay'>
	</pre>
	</form>
</body>
</html>