<%@page import="java.util.List" %>
<%@page import="com.span.team1.jobPortal.model.*"%>
<html>
<head>
<title>Job Search Results</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
<%
	String userName = (String) session.getAttribute("userName");
	String jobsType = (String) request.getAttribute("jobsType");
%>
	<p class="companyName" align="right">Hi <%= userName %>...</p>
	<form>
		<table class="table" cellspacing=5 cellpadding=12>
			<caption class="tableCaption" align="left"><%= jobsType %><hr></caption>
			<tr>
				<th class="fieldName">Posted Date</th>
				<th class="fieldName">Company</th>
				<th class="fieldName">Location</th>
				<th class="fieldName">Position</th>
				<th class="fieldName">Experience</th>
				<th class="fieldName">Qualification</th>
				<th class="fieldName">Last Date</th>
				<th class="fieldName">Details</th>
			</tr>
			<%
			List<Job> jobs = (List<Job>)request.getAttribute("jobs");
				for(Job job:jobs)
				{
			%>
			<tr>
				<td><%= job.getPostedDate() %></td>
				<td><%= job.getCompanyName() %></td>
				<td><%= job.getVenueLocation() %></td>
				<td><%= job.getPosition() %></td>
				<td><%= job.getExperience() %>Years</td>
				<td><%= job.getQualifications() %></td>
				<td><%= job.getLastDate() %></td>
				<td><a href="job_details.jsp?jobId=<%= job.getJobId() %>&jobsType=<%= jobsType %>"><img class="image4" align="right" alt="view job" src="images/view.jpg"></a></td>
			</tr>
			<%
				}
			%>
		</table>
	</form>
</body>
</html>