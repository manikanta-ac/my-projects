<%@page import="com.pratian.db.ReservationDAO"%>
<%@page import="java.util.Date" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/style.css">
<script language="javascript" src="javascript/passengerValidate.js"></script>
</head>
<body onload="defaults()">
	<%
	int routeId = Integer.parseInt((String)session.getAttribute("routeId"));
	int noOfSeats = Integer.parseInt((String)session.getAttribute("noOfSeats"));
	
	String fromCityName = (String)session.getAttribute("fromCity");
	String toCityName = (String)session.getAttribute("toCity");

	String type = (String)session.getAttribute("type");
	System.out.println("Passenger JSP---"+type);	
	%>

	<h3 class="frameheader" style="margin-right: 70%">Plan My Travel</h3>
	<div class="login" align="right" style="margin-right: 70%">

		From City:
		<p class="s1"><%= session.getAttribute("fromCity") %></p>
		To City:
		<p class="s1"><%= session.getAttribute("toCity") %></p>

	</div>
	<ul style="list-style: none; margin-left: 0%; margin-right: 70%;">
		<li><h3 class="frameheader">Services</h3></li>
		<li><h3 class="frameheader">My Transactions</h3></li>
		<li><h3 class="frameheader">Print Ticket</h3></li>
		<li><h3 class="frameheader">Cancellation</h3></li>
		<li><h3 class="frameheader">User Profile</h3></li>
	</ul>
	
	<div class="trainslist">
	<p class="userheader" ><%= new Date() %>	&nbsp; &nbsp; <a href="userhome.jsp" style="text-decoration: none;">Home</a> &nbsp; &nbsp;
	<a href="signout.jsp" style="text-decoration: none;">Sign out</a>	&nbsp; &nbsp; Welcome <%= session.getAttribute("userName") %>.....!</p>
	<h3 class="frameheader">Ticket Details</h3>
	
	<pre class="login">
	From City:<%= fromCityName %>		To City:<%= toCityName %>		Route Id:<%= routeId %>    
	</pre>
	
	<h3 class="frameheader" >Passenger Details</h3>
	<br>
	<form action="ticket.jsp" target="body" method="post" onsubmit="return passengerValidate()">
	<input type="hidden" name="noOfSeats" id="seats" value="<%= noOfSeats %>">
	<table border="1">
		<tr class="login">
			<th>Passenger Id</th>
			<th>Passenger Name</th>
			<th>Gender</th>
			<th>Date Of Birth</th>
		</tr>
		<%
			String pidId;
			String passidName; 
			String passnameId;
			String passnameName;
			String genId;
			String genName;
			String dobId;
			String dobName; 
			
			for(int i=1;i<=noOfSeats;i++)
			{
				pidId = "pid"+i;
				passidName = "passengerId"+i;
				passnameId = "pnm"+i;
				passnameName = "passengerName"+i;
				genId = "gen"+i;
				genName = "gender"+i;
				dobId = "dob"+i;
				dobName = "dateOfBirth"+i;
		%>
		<tr>
			<td><input type="text" id="<%= pidId %>" name="<%= passidName %>"></td>
			<td><input type="text" id="<%= passnameId %>" name="<%= passnameName%>"></td>
			<td><input type="radio" id="<%= genId %>" name="<%= genName %>" value="m" checked="checked">Male 	<input type="radio" id="<%= genId %>" name="<%= genName %>" value="f">Female</td>
			<td><input type="text" id="<%= dobId %>" name="<%= dobName %>"></td>
		</tr>
		<%
			}
		%>
	</table>		
			<input type="submit" value="Submit">   <input type="reset" value="Reset">
	</form>
	</div>
</body>
</html>