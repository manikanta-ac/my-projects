<%@page import="com.span.team1.jobPortal.dao.JobPortalDAO"%>
<%@page import="com.span.team1.jobPortal.model.Feed"%>
<%@page import="java.util.List"%>
<html>
<head>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<h2 align="center" style="color: FireBrick;">ThankYou For Giving Valuable Comments..........:)</h2>
	<form>
		<table cellspacing=5 cellpadding=12 width="20%">
			<caption class="tableCaption" align="left">
				Previous Comments
				<hr>
			</caption>
			<%
				List<Feed> feeds = JobPortalDAO.getAllComments();
					for (Feed feed : feeds) {
			%>
			<tr>
				<td><pre><%=feed.getComments()%><br>
									---<%=feed.getName()%></pre>
					<hr>
				</td>
			</tr>
			<%
				}
			%>
		</table>
	</form>


</body>
</html>