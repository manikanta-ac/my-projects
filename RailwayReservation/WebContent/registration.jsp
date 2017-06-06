<HTML>
<HEAD>
<TITLE>Registration</TITLE>
<script language="javascript" src="javascript/regValidate.js"></script>
</HEAD>

<BODY>
	<jsp:useBean id="reg" class="com.pratian.bean.RegistrationBean"></jsp:useBean>
	<%
		String username = request.getParameter("username");
		if(username!=null)
		{
	%>
	<jsp:setProperty property="createdDate" name="reg" value="2012-12-22"/>
	<jsp:setProperty property="active" name="reg" value="true" />
	<jsp:setProperty property="*" name="reg" />
	<%	
			reg.addAccount();
		}
	%>
		
	<form onsubmit="return regValidate();">
		<pre>				User Name	<input type="text" id="un" name="username">
				Password	<input type="password" id="pw" name="password">
				Confirm Password<input type="password" id="cpw" name="cpassword">
				Full Name	<input type="text" id="fn" name="fullName">
				Gender		<input type="radio" id="gen" name="gender" value="m" checked="checked">Male 	<input type="radio" id="gen" name="gender" value="f">Female
				DateOfBith	<input type="text" id="dob" name="dateOfBirth">
				Address  	<textarea id="adrs" name="address" rows=4 cols=15></textarea>
				City		<select id="cty" name="city">
									<option value="none" selected>Select city</option>
									<option value="Bangalore">Bangalore</option>
									<option value="Hyderabad">Hyderabad</option>
									<option value="Chennai">Chennai</option>
									<option value="Mumbai">Mumbai</option>
									<option value="New Delhi">New Delhi</option>
							</select>
				State		<input type="text" id="st" name="state">
				PIN		<input type="text" id="pn" name="pin">
				Email       	<input type="text" id="em" name="emailId">
				Phone Number	<input type="text" id="ph" name="phone">
				<input type="submit" value="register">&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="reset" value="reset">
		</pre>
	</form>
	
	<%		
		String s1 = request.getParameter("username");
		if(s1!=null)
		{
	%>
<jsp:forward page="regSuccess.html"></jsp:forward>
	<%
			}
	%>
	
</BODY>
</HTML>
