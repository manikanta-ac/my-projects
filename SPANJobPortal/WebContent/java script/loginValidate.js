function validate()
{
	var username = document.getElementById("un");
	var password = document.getElementById("pd");

	var name_msg = document.getElementById("name_error");
	name_msg.innerHTML="";

	var pwd_msg =  document.getElementById("pwd_error");
	pwd_msg.innerHTML="";

	if(username.value.length==0)
	{
		name_msg.innerHTML="Enter the Username";
		username.focus();
		return false;
	}
	if(password.value.length==0)
	{
		pwd_msg.innerHTML="Enter the Password";
		password.focus();
		return false;
	}

	var pattern = /^[a-zA-Z0-9.]+@[a-zA-Z0-9]+\.(com|in|net|org)$/;

	if(username.value.match(pattern)==null)
	{
		name_msg.innerHTML="Email should of format 'abc@xyz.com'";
		username.focus();
		return false;
	}
	return true;
}