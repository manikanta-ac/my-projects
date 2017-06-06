<%@page import="com.span.team1.jobPortal.model.UserInfo"%>
<html>
<head>
<title>registration form</title>
<link rel="stylesheet" href="style/style.css">
<script type="text/javascript" src="java script/registerValidate.js"></script>
</head>
<body>	
<%
	String type = "Registration";

	if(request.getParameter("fType")!=null)
	{
		type = request.getParameter("fType");
	}
	String submit = "Register";
	
	if(type.equals("Update Profile"))
		submit = "Update";
	
	
	UserInfo userInfo;
	String qualificationvalue;
	String yearOfPassingValue;
	String yearOfPassing;
	
	if(request.getAttribute("userInfo") == null)
	{
		userInfo = new UserInfo();
		
		userInfo.setId(0);
		userInfo.setFirstName("");
		userInfo.setEmail("");
		userInfo.setQualification("Highest Qualification");
		userInfo.setCollegeName("");
		userInfo.setPercentage("");
		userInfo.setStream("");
		userInfo.setYearOfPassing("");
		
		qualificationvalue = "none";
		yearOfPassing = "Year of Passing";
		yearOfPassingValue = "select";
	}
	else
	{
		userInfo = (UserInfo)request.getAttribute("userInfo");
		qualificationvalue = userInfo.getQualification();
		yearOfPassing = ""+userInfo.getYearOfPassing();
		yearOfPassingValue = ""+userInfo.getYearOfPassing();
		userInfo.getPercentage();
	}
%>
	<form action="Registration?type=<%= type %>" onSubmit="return validate()" method="post" target="frame2">
		<p class="welcomeText">Welcome to <%= type %>:</p>

		<table class="personal_table" align="center" border="0" >
		<caption class="tableCaption">Personal Details</caption>
			<tr>
				<td><label class="fieldName"> First name:* </label></td>
				<td><input type="text" name="fname" value="<%= userInfo.getFirstName()%>"/></td>
 				<td><span id="fname_msg"/></td>
			</tr>

			<tr>
				<td class="fieldName"><label> Last name:* </label></td>
				<td><input type="text" name="lname"/></td>
                <td><span id="lname_msg"/></td>
			</tr>
			<tr>
				<td class="fieldName"><label> Email Id:* </label></td>
				<td><input type="text" name="id" value="<%= userInfo.getEmail()%>"/></td>
                 <td><span id="emailid_msg"/></td>
			</tr>
			<tr>
				<td class="fieldName"><label> Password:* </label></td>
				<td><input type="password" name="password"/></td>
                <td><span id="password_msg"/></td>
			</tr>
			<tr>
				<td class="fieldName"><label>Retype Password:* </label></td>
				<td><input type="password" name="repassword"/></td>
                <td><span id="repassword_msg"/></td>
			</tr>
			<tr>
				<td class="fieldName">Date of Birth</td>
				<td><select name="Date">
						<option value="selected">day</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
				</select> <select name="Month" >
						<option value="selected">month</option>
						<option value="Jan">Jan</option>
						<option value="Feb">Feb</option>
						<option value="Mar">Mar</option>
						<option value="Apr">Apr</option>
						<option value="May">May</option>
						<option value="Jun">Jun</option>
						<option value="July">July</option>
						<option value="Aug">Aug</option>
						<option value="Sept">Sept</option>
						<option value="Oct">Oct</option>
						<option value="Nov">Nov</option>
						<option value="Dec">Dec</option>
				</select> <select name="Year">
						<option value="selected">year</option>
						<option value="1985">1985</option>
						<option value="1986">1986</option>
						<option value="1987">1987</option>
						<option value="1988">1988</option>
						<option value="1989">1989</option>
						<option value="1990">1990</option>
						<option value="1991">1991</option>
						<option value="1992">1992</option>
						<option value="1993">1993</option>
						<option value="1994">1994</option>
						<option value="1995">1995</option>
						<option value="1996">1996</option>
						<option value="1997">1997</option>
						<option value="1998">1999</option>
						<option value="1999">1999</option>
				</select></td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="fieldName"><label> Address </label></td>
				<td><textarea rows="4" cols="20"></textarea></td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="fieldName"><label>Country </label></td>
				<td><select name="country">
						<option value="selected">Select Country</option>
						<option value="India">India</option>
						<option value="America">America</option>
						<option value="Australia">Australia</option>
				</select></td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="fieldName"><label>State </label></td>
				<td><select name="state">
						<option value="selected">Select State</option>
						<option value="karnataka">Karnataka</option>
						<option value="ap">Andhra Prdesh</option>
						<option value="kl">Kerala</option>
						<option value="tn">Tamilnadu</option>
						<option value="uttarakhand">Uttarakhand</option>
				</select></td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="fieldName"><label> City </label></td>
				<td><select name="nationality">
						<option value="select">Select City</option>
						<option value="haldwani">Haldwani</option>
						<option value="dehradun">Dehradun</option>
						<option value="nainital">Nainital</option>
				</select></td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="fieldName"><label> Pincode </label></td>
				<td><input type="number" /></td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="fieldName"><label> Gender </label></td>
				<td><input type="radio" name="sex" value="male" />Male <input
					type="radio" name="sex" value="female" />Female</td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
			<tr>
				<td class="fieldName"><label> Marital Status </label></td>
				<td><select name="status">
						<option value="Single">Single</option>
						<option value="Married">Married</option>
				</select></td>
			</tr>
	</table>
	
	
	<table class="academic_table" align="center" border="0" cellspacing=2 cellpadding=2>
		<caption class="tableCaption">Academic details</caption>
			<tr>
				<td class="fieldName"><label> Highest Qualification </label></td>
				<td><select name="Qualification">
						<option value="<%= qualificationvalue%>" selected><%= userInfo.getQualification()%></option>
						<option value="B.A">B.A</option>
						<option value="B.Arch">B.Arch</option>
						<option value="B.B.A">B.B.A</option>
						<option value="B.Com">B.Com</option>
						<option value="B.E/B.Tech">B.E/B.Tech</option>
						<option value="B.Ed">B.Ed</option>
						<option value="B.Sc">B.Sc</option>
						<option value="BCA">BCA</option>
						<option value="MCA">MCA</option>
						<option value="M.Sc">M.Sc</option>
				</select></td>
				<td><span id="quali"/></td>
			</tr>
			<tr>
				<td class="fieldName"><label> College Name </label></td>
				<td><input type="text" name="cname" value="<%= userInfo.getCollegeName() %>"/></td>
				<td><span id="clgname_msg"/></td>
			</tr>
			<tr>
				<td class="fieldName"><label> Stream/Specialisation </label></td>
				<td><input type="text" name="stream" value="<%= userInfo.getStream() %>"/></td>
				<td><span id="stream_msg"/></td>
			</tr>
			<tr>
				<td class="fieldName"><label> Percentage </label></td>
				<td><input type="number" name="percentage" value="<%= userInfo.getPercentage()%>"/></td>
				<td><span id="percentage_msg"/></td>
			</tr>
			<tr>
				<td class="fieldName"><label> University </label></td>
				<td><input type="text" name="university" /></td>
				<td><span id="university_msg"/></td>
			</tr>
			<tr>
				<td class="fieldName"><label> Year of Passing </label></td>
				<td><select name="YearOfPassing">
						<option value="<%= yearOfPassingValue%>"><%= yearOfPassing%></option>
						<option value="2005">2005</option>
						<option value="2006">2006</option>
						<option value="2007">2007</option>
						<option value="2008">2008</option>
						<option value="2009">2009</option>
						<option value="2010">2010</option>
						<option value="2011">2011</option>
						<option value="2012">2012</option>
						<option value="2013">2013</option>
						<option value="2014">2014</option>
				</select></td>
				<td><span id="yop_msg"/></td>
			</tr>
			
		</table>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<input class="submit" type="submit" value="<%= submit %>">
	</form>
	
</body>
</html>