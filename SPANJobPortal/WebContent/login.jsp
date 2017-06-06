<HTML>
<HEAD>
<link rel="stylesheet" href="style/style.css" />
<script type="text/javascript" src="java script/loginValidate.js"> </script>
</HEAD>

<BODY>
	<form action="Login" onSubmit="return validate()" target="frame2">
		<table>
		<caption class="tableCaption">Login Here</caption>

			<tr>
			<td></td>
				<td><span id="name_error"/></td>
			</tr>
			<tr>
				<td class="fieldName">Email-id:</td>
				<td><input type="text" name="userName" id="un"></td>
			</tr>
			<tr>
			<td></td>
				<td><span id="pwd_error"/></td>
			</tr>
			<tr>
				<td class="fieldName">Password:</td>
				<td><input type="password" name="password" id="pd"></td>
			</tr>

			<tr align="center">
				<td><br><input type="submit" value="Login"/>
				</td>
				<td><br><input type="reset" value="Reset"/>
				</td></form>
			</tr>
			<tr>
			<td><br></td>
			</tr>
			<tr>
				<td></td>
				<td align="left">
						<form action="register.jsp" target="frame2">
							<input type="submit" value="Click Here To Register">
						</form>						
				</td>
			</tr>
			<tr>
			<td><br></td>
			</tr>
		</table>
		<fieldset>
			<legend class="fieldName">News:</legend>
			<marquee>Openings at Span Infotech.</marquee>
		</fieldset>
</BODY>
</HTML>
