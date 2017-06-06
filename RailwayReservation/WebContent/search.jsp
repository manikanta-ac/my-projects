<%@page errorPage="error.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/style.css">
<script language="javascript" src="javascript/searchValidate.js">
	
</script>
</head>
<body>
	<jsp:useBean id="search" class="com.pratian.bean.SearchBean">
	<jsp:setProperty property="*" name="search" />
	</jsp:useBean>
	<%
		String fromCity = request.getParameter("fromCityName");
		String toCity = request.getParameter("toCityName");
		String msg = "";
		System.out.println(fromCity);
		if (fromCity != null) 
		{
			boolean status = search.validateCities();
			if (status) 
			{
				session.setAttribute("fromCity", fromCity);
				session.setAttribute("toCity", toCity);
	%>
	<jsp:forward page="showTrains.jsp"></jsp:forward>
	<%
			}
			else
			{
				msg = "Invalid From City/To City";
			}
		}
	%>
	<h3 class="frameheader">Plan My Travel</h3>
	<div class="login" align="right">
		<form target="body" method="post" onsubmit="return searchValidate()">
			<pre>
     From City <input type="text" id="fc" name="fromCityName"> 
     To City   <input type="text" id="tc" name="toCityName">
			
	<input type="submit" value="Find Trains">  <input type="reset" value="Reset">
	<input type="text" class="s1" readonly style="border:0" size="25" value="<%= msg %>"></pre>
		</form>
	</div>
	<ul style="list-style: none; margin-left: 0%;">
		<li><h3 class="frameheader">Services</h3></li>
		<li><h3 class="frameheader">My Transactions</h3></li>
		<li><h3 class="frameheader">Print Ticket</h3></li>
		<li><h3 class="frameheader">Cancellation</h3></li>
		<li><h3 class="frameheader">User Profile</h3></li>
	</ul>
</body>
</html>