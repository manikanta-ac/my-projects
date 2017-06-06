<%@page import="com.span.team1.jobPortal.dao.JobPortalDAO"%>
<HTML>
<HEAD>
<link rel="stylesheet" href="style/style.css">
</HEAD>

<BODY>
	<%
		String email = (String) request.getParameter("userName");
		String userName = JobPortalDAO.getUserName(email);
		session.setAttribute("userName", userName);
	%>
	<div align="right" class="companyName">
		<pre>Welcome <%= userName %>...!</pre>s
	</div>
	<br>
	<hr>
	<ul class="buttonmenu">
		<li><a href="JobHistory" target="frame2" >Job History</a></li>
		<li><a href="RecommendedJobs" target="frame2">Recommended Jobs</a></li>
		<li><a href="job_search.jsp" target="frame2">Search Jobs</a></li>
		<li><a href="view_profile.jsp" target="frame2">View Profile</a></li>
		<li><a href="edit_profile.jsp" target="frame2">Edit Profile</a></li>
	</ul>
</BODY>
</HTML>
