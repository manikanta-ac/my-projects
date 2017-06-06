<%@page import="com.pratian.db.ReservationDAO"%>
<%@page import="java.util.Date" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/style.css">
<script language="javascript" src="javascript/seatsValidate.js"></script>
</head>
<body>
	<jsp:useBean id="seatsBean" class="com.pratian.bean.SeatsBean"></jsp:useBean>
	<jsp:setProperty property="*" name="seatsBean"/>
	<%
	int routeId = Integer.parseInt(request.getParameter("route"));
	session.setAttribute("routeId", request.get+Parameter("route"));
	String msg = "";
	if(request.getParameter("type")!=null)
	{
		session.setAttribute("type", request.getParameter("type"));
		session.setAttribute("noOfSeats", request.getParameter("noOfSeats"));
		System.out.println("Seats Jsp-----"+session.getAttribute("type")+"-----"+session.getAttribute("noOfSeats"));
		
		if(seatsBean.isAvailable(routeId))
		{
	%>
	<jsp:forward page="passengers.jsp"></jsp:forward>
	<%
		}
		else
		{
			msg = "Seats are not available for this class";
		}
	}
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
	<h3 class="frameheader">No.Of Seats
		Available</h3>
	<%
	String fromCityName = (String)session.getAttribute("fromCity");
	String toCityName = (String)session.getAttribute("toCity");
	
	int seats[] = ReservationDAO.getSeatsAvailableInAllClasses(routeId);
%>

	<table border="1">
		<tr class="login">
			<th>Sleeper Class</th>
			<th>2nd A/C Class</th>
			<th>1st A/C Class</th>
		</tr>
		<tr>
			<td><%= seats[0] %></td>
			<td><%= seats[1] %></td>
			<td><%= seats[2] %></td>
		</tr>
	</table>
	<br>
	<form target="body" method="post" onsubmit="return seatsValidate()">
	<pre>Select any Class that You want:<select id="cls" name="type">
											<option value="none" selected>Select Class</option>
											<option value="firstClass">Sleeper Class</option>
											<option value="bussinessClass">2nd A/C Class</option>
											<option value="economyClass">1st A/C Class</option>
										</select>
		   No.Of Seats:<select id="num" name="noOfSeats">
								<option value="0" selected>Select Number</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
					</select>
<input type="text" class="s1" name="failmsg" readonly style="border=0;" size="35" value="<%= msg %>">					
					<input type="submit" value="submit">
	</pre>
	</form>
	</div>
</body>
</html>