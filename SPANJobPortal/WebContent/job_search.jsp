<html>
<head>
<title>Job Search</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
<%
	String userName = (String) session.getAttribute("userName");
%>
	<p class="companyName" align="right">Hi <%= userName %>...</p>
	<p class="welcomeText" align="center">Welcome To Job Search</p><br>
	
	<form action="SearchJob" target="frame2" method="post">
		<table class="table" cellspacing=5 cellpadding=12>
			<caption class="tableCaption" align="left">Search Jobs<hr></caption>
			<tr><td class="fieldName">Category:</td>
				<td class="filedValue"><select name="industry">
						<option value="none">Select Category</option>
						<option value="IT/Software">IT/Software</option>
						<option value="Core Technical">Core Technical</option>
						<option value="Marketing">Marketing</option>
						<option value="Banking">Banking</option>
						<option value="HR">HR</option>
				</select></td>
			</tr>
			<tr>
				<td class="fieldName">Keywords:</td>
				<td class="filedValue"><input type="text" name="keywords"
					id="kw"><br><font size="2" color="gray">Skills,Designation,...</font></td>
			</tr>
			<tr>
				<td class="fieldName">Experience:</td>
				<td class="filedValue"><select name="experience">
						<option value="none">Select No.of Years</option>
						<option value="0-1">0-1</option>
						<option value="1-2">1-2</option>
						<option value="2-3">2-3</option>
						<option value="3-4">3-4</option>
						<option value="4-5">4-5</option>
				</select><font size="2" color="gray">Years</font></td>
			</tr>
			<tr>
				<td class="fieldName">Educational Qualifications:</td>
				<td class="filedValue"><select name="quali">
						<option value="none">Select Degree</option>
						<option value="B.Tech">B.Tech</option>
						<option value="BE">BE</option>
						<option value="MCA">MCA</option>
						<option value="M.Tech">M.Tech</option>
						<option value="MBA">MBA</option>
						<option value="Bcom">Bcom</option>
						<option value="BSc">BSc</option>
						<option value="CA">CA</option>
				</select></td>
			</tr>
			<tr>
				<td class="fieldName">Salary:</td>
				<td class="filedValue"><select name="salary">
						<option value="none">Select Range</option>
						<option value="0-1">0-1</option>
						<option value="1-2">1-2</option>
						<option value="2-3">2-3</option>
						<option value="3-4">3-4</option>
						<option value="4-5">4-5</option>
				</select><font size="2" color="gray">Lpa</font></td>
			</tr>
			<tr>
				<td class="fieldName">Location:</td>
				<td class="filedValue"><input type="text" name="location" id="kw">
				<br>
				<font size="2" color="gray">Separate multiple locations by comma</font></td>
			</tr>
		</table>
		<pre>
				<input type="submit" value="Search Jobs"> 		<input type="reset"
				value="Reset">
		</pre>
	</form>
	<img class="image3" align="right" alt="post your requirements" src="images/search.jpg">
</body>
</html>