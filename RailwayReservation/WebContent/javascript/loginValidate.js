function loginValidate()
{
	var username = document.getElementById("un");
	var password = document.getElementById("pw");
	
	if(username.value.length==0)
	{
		alert("Please Enter User Name");
		username.focus();
		return false;
	}
	if(password.value.length==0)
	{
		alert("Student Name cann't be empty");
		password.focus();
		return false;
	}
	
	return true;
}