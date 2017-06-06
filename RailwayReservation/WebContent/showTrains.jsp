<%@page import="com.pratian.db.*"%>
<%@page import="com.pratian.model.*"%>
<%@page import="java.util.*"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
<h3 class="frameheader" style="margin-right: 70%">Plan My Travel</h3>
	<div class="login" align="right" style="margin-right: 70%">

  From City: <p class="s1"><%= session.getAttribute("fromCity") %></p> 
  To City:   <p class="s1"><%= session.getAttribute("toCity") %></p>
  
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
<form target="body" action="seats.jsp">
<table>
		<tr class="login">
			<th align="left">RouteId &nbsp;&nbsp;&nbsp; distanceInKms   Departure Time   Arrival Time   Source   Destination</th>
		</tr>
		<tr>
			<td><%String fromCityName = (String)session.getAttribute("fromCity");
	String toCityName = (String)session.getAttribute("toCity");

	City fromCity = new City(ReservationDAO.getCityIdByName(fromCityName),fromCityName);
	City toCity = new City(ReservationDAO.getCityIdByName(toCityName),toCityName);
	
	if(ReservationDAO.getRoutes(fromCity, toCity).size()!=0)
	{
		for(Route route:ReservationDAO.getRoutes(fromCity, toCity))
		{
			%><pre><input type="radio" name="route" value="<%= route.getRouteId() %>"><%
			out.println(route.getRouteId()+"\t\t"+route.getDistanceInKms()+"\t\t"+
						ReservationDAO.getDepartureTimeByRouteId(route.getRouteId())+"\t\t"+
						ReservationDAO.getArrivalTimeByRouteId(route.getRouteId())+"\t"+
						ReservationDAO.getCityNameById(route.getFromCity().getCityId())+"\t"+
						ReservationDAO.getCityNameById(route.getToCity().getCityId()));
		}%></pre></td>
		</tr>
	</table>
	<pre>				<input type="submit" value="submit"> </pre>
	<%
		}
		else
		{
			out.println("Sorry.......! No Trains Available for this route");
		}
	%>
</form>
</div>	
</body>
</html>