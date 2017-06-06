function validate()
{
	document.getElementById("fname_msg").innerHTML="";
	document.getElementById("email_msg").innerHTML="";
	
	if(document.forms[0].fname.value.length==0)
	{
		document.getElementById("fname_msg").innerHTML="Enter the Name";
		document.forms[0].fname.focus();
		return false;
	}
	if(document.forms[0].email.value.length==0)
	{
		document.getElementById("email_msg").innerHTML="Enter the Email Address";
		document.forms[0].email.focus();
		return false;
	}
	var pattern = /^[a-zA-Z0-9.]+@[a-zA-Z0-9]+\.(com|in|net|org)$/;

	if(document.forms[0].email.value.match(pattern)==null)
	{
		document.getElementById("email_msg").innerHTML="Email should of format 'abc@xyz.com'";
		document.forms[0].email.focus();					
		return false;
	}
	return true;
}
