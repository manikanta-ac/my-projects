<%@page import="com.pratian.db.ReservationDAO"%>
<%@page import="java.util.Date" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>	
	<%
	System.out.println("------------Ticket Jsp------------");
	int routeId = Integer.parseInt((String)session.getAttribute("routeId"));
	String type = (String)session.getAttribute("type");
	int noOfSeats = Integer.parseInt((String)session.getAttribute("noOfSeats"));
	
	String fromCityName = (String)session.getAttribute("fromCity");
	String toCityName = (String)session.getAttribute("toCity");
	
	String []passId = new String[noOfSeats];
	String []passName = new String[noOfSeats];
	String []gender = new String[noOfSeats];
	String []dob = new String[noOfSeats];
	
	for(int i=0;i<noOfSeats;i++)
	{
		passId[i] = request.getParameter("passengerId"+(i+1));
		passName[i] = request.getParameter("passengerName"+(i+1));
		gender[i] = request.getParameter("gender"+(i+1));
		dob[i] = request.getParameter("dateOfBirth"+(i+1));
	}
	
	double totalCost = 0;
	
	System.out.println("Total Cost:-----------"+totalCost);
	try  
	{
		for(int i=0;i<noOfSeats;i++)
		{
			totalCost += ReservationDAO.bookTicket(routeId,type,passId[i],passName[i],gender[i], dob[i]);
		}
	} catch (Exception e) 
	{
		e.printStackTrace();
	}
	
	if(totalCost!=0)
	{
		session.setAttribute("totalCost", totalCost);
	}	
	
	String values[] = ReservationDAO.getBookingDetails(routeId);
	String bookingId = values[0];
	String bookingDate = values[1];
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
From City:<%= fromCityName %>		To City:<%= toCityName %>		Route Id:<%= routeId %>         Booking Id:<%= bookingId %>
	<%
		for(int i=0;i<noOfSeats;i++)
		{
	%>
Passenger Id:<%= passId[i] %>      Passenger Name:<%= passName[i] %>  Gender:<%= gender[i] %> 
	<%
		}
	%>
Booking Date:<%= bookingDate %>      No.Of Seats:<%= noOfSeats %> 		Total Cost:<%= totalCost %>
	</pre>

	</div>
	<form target="body" action="payment.jsp" method="post">
	<pre>											<input type="submit" value="Make Payment"> </pre>
	</form>
</body>
</html>