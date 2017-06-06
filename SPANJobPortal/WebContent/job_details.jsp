<%@page import="com.span.team1.jobPortal.dao.JobPortalDAO"%>
<%@page import="com.span.team1.jobPortal.model.Job"%>
<html>
<head>
<title>Job Details</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<%
	String userName = (String) session.getAttribute("userName");
	int jobId = Integer.parseInt((String)request.getParameter("jobId"));
	Job job = JobPortalDAO.getJob(jobId);
	
	String jobsType = (String) request.getParameter("jobsType");
%>
	<p class="companyName" align="right">
		Hi
		<%= userName %>...
	</p>
	<form action="ApplyingJob" method="post">
		<table class="table" cellspacing=5 cellpadding=2>
			<caption class="tableCaption" align="left">
				Job Details
				<hr>
			</caption>
			<tr>
				<td class="fieldName">Job Posted Date:</td>
				<td class="filedValue"><%= job.getPostedDate() %></td>
			</tr>
			<tr>
				<td class="fieldName">Company Name:</td>
				<td class="filedValue"><%= job.getCompanyName() %></td>
			</tr>
			<tr>
				<td class="fieldName">Company Profile:</td>
				<td class="filedValue"><%= job.getCompanyProfile() %></td>
			</tr>
			<tr>
				<td class="fieldName">Industry:</td>
				<td class="filedValue"><%= job.getIndustry() %></td>
			</tr>
			<tr>
				<td class="fieldName">Job Role/Position:</td>
				<td class="filedValue"><%= job.getPosition() %></td>
			</tr>
			<tr>
				<td class="fieldName">Salary:</td>
				<td class="filedValue"><%= job.getSalary() %> PM</td>
			</tr>
			<tr>
				<td class="fieldName">Key Skills:</td>
				<td class="filedValue"><%= job.getSkills() %></td>
			</tr>
			<tr>
				<td class="fieldName">Educational Qualifications:</td>
				<td class="filedValue"><%= job.getQualifications() %></td>
			</tr>
			<tr>
				<td class="fieldName">Experience:</td>
				<td class="filedValue"><%= job.getExperience() %>Years</td>
			</tr>
			<tr>
				<td class="fieldName">Job Location:</td>
				<td class="filedValue"><%= job.getJobLcation() %></td>
			</tr>
			<tr>
				<td class="fieldName">Venue Location:</td>
				<td class="filedValue"><%= job.getVenueLocation() %></td>
			</tr>
			<% if(!jobsType.equals("Applied Jobs"))
				{
			%>
			<tr>
				<td class="fieldName">Last Date To Apply:</td>
				<td class="filedValue"><%= job.getLastDate() %></td>
			</tr>
			<%
				} 
			%>
		</table>
		<% if(!jobsType.equals("Applied Jobs"))
			{
		%>
		<pre>
				<input type="submit" value="Apply Now"> 		
		</pre>
		<%
			} 
		%>
		<input type="hidden" name="jobId" value="<%= jobId %>"> <input
			type="hidden" name="companyURL" value="<%= job.getCompanyURL() %>">
	</form>
	<img class="image2" align="right" alt="company logo"
		src="images/SPANLogo.jpg">
</body>
</html>