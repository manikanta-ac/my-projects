<html>
<head>
<title>Pratian Raiway Reservation</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
<script language="javascript" src="javascript/loginValidate.js"></script>
</head>
<body>
<jsp:useBean id="login" class="com.pratian.bean.LoginBean"/>
<jsp:setProperty property="*" name="login"/>
<%
	String msg = "";
	boolean status = login.authenticate();
	if(status)
	{
%>
<jsp:forward page="userhome.jsp"></jsp:forward>
<%
	}
	else
	{
		msg = "Incorrect Username/Password";
	}
	String s1=request.getParameter("userName");
	if(s1==null)
	{
		s1="";
		msg="";
	}
%>

<h3 class="frameheader">Login</h3>
<div class="login" align="right">
  <form target="body" method="post" onSubmit="return loginValidate()">
    <pre> UserName	   <input type="text" id="un" name="userName" value="<%= s1 %>"> 
 Password	   <input type="password" id="pw" name="password">
 
               <input type="submit" value="login">  <input type="reset" value="reset">
<input type="text" class="s1" name="failmsg" readonly style="border=0;" size="35" value="<%= msg %>">			   
To Create new Account <p align="center">click here
		<a href="registration.jsp" target="body"><img src="images/create.png" align="center"></a>	
	   </pre>
  </form>
</div>

</body>
</html>