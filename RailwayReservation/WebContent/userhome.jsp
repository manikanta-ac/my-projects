<%@page import="java.util.Date" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
<%
	session.setAttribute("userName", request.getParameter("userName"));
%>
<iframe src=search.jsp frameborder="0" scrolling="no" height="100%" width="29%"> </iframe>

<ul class="userhome" type="square">
<p class="userheader" ><%= new Date() %>	&nbsp; &nbsp; <a href="userhome.jsp" style="text-decoration: none;">Home</a> &nbsp; &nbsp;
<a href="signout.jsp" style="text-decoration: none;">Sign out</a>	&nbsp; &nbsp; Welcome <%= session.getAttribute("userName") %>.....!</p>
<li>Passengers are advised not to carry inflammable / dangerous / explosive articles as part of their luggage and also to desist from smoking in the trains.</li> 
<li>Dear Customer, to help improve the quality of service, you are requested to please sign-out your account before closing the web-page.</li> 
<li>Always keep correct information in your profile, garbage/junk values in profile may lead to deactivation</li> 
<li>You are not a member of Shubh Yatra - Scheme for Frequent Travellers. To become a member, Click to register now!</li> 
<li>Class 3E Suspended in Train No. 12259/12260(DURONTO EXPRESS). Click here to know more</li> 
<li>Food charges are not included in ticket fare for the tickets booked on/after 28th Nov 09 in train numbers 12289 & 12290.</li> 
<li>Time table of several trains are updated from 1st July 2011, Please check exact train starting time from boarding station before embarking on your journey.</li>
<li>For normal I-Ticket, booking is permitted at least two clear calendar days in advance of date of journey.</li> 
<li>For e-Ticket, booking can be done upto chart Preparation approximately 4 to 6 hours before departure of train.For morning trains with departure time upto 12.00 hrs charts are prepared on the previous night.</li> 
<li>Opening day booking (120th day in advance, excluding the date of journey) will be available only after 8 AM, along with the counters.</li>
</ul>
</body>
</html>