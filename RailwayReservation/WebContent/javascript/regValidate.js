function regValidate()
{
	var username = document.getElementById("un");
	var password = document.getElementById("pw");
	var cpassword = document.getElementById("cpw");
	var fullname = document.getElementById("fn");
	var address = document.getElementById("adrs");
	var city = document.getElementById("cty");
	var state = document.getElementById("st");
	var pin = document.getElementById("pn");
	var email = document.getElementById("em");
	var phone = document.getElementById("ph");
	var dob = document.getElementById("dob");
	
	if(username.value.length==0)
	{
		alert("User Name cann't be empty");
		username.focus();
		return false;
	}
	if(password.value.length==0)
	{
		alert("Please Enter Password");
		password.focus();
		return false;
	}
	if(cpassword.value.length==0)
	{
		alert("Please Enter Confirm Password");
		cpassword.focus();
		return false;
	}
	if(fullname.value.length==0)
	{
		alert("Full Name cann't be empty");
		fullname.focus();
		return false;
	}
	if(dob.value.length==0)
	{
		alert("Please Enter Date Of Birth");
		dob.focus();
		return false;
	}
	if(address.value.length==0)
	{
		alert("Please Enter Address");
		address.focus();
		return false;
	}
	if(state.value.length==0)
	{
		alert("State cann't be empty");
		state.focus();
		return false;
	}
	if(pin.value.length==0)
	{
		alert("PIN cann't be empty");
		pin.focus();
		return false;
	}
	if(email.value.length==0)
	{
		alert("Please Enrer Email");
		email.focus();
		return false;
	}
	if(phone.value.length==0)
	{
		alert("Please Enter Phone Number");
		phone.focus();
		return false;
	}
	
	if(password.value.length<5)
	{
		alert("Password size must be greater than 5");
		password.focus();
		return false;
	}
	if(!pin.value.length==6)
	{
		alert("PIN Must be 6 digits");
		pin.focus();
		return false;
	}
	if(!phone.value.length==10)
	{
		alert("Phone NUmber Must be 10 digits");
		phone.focus();
		return false;
	}
	
	if(password.value!=cpassword.value)
	{
		alert("Password and Confirm Password must be same");
		password.focus();
		return false;
	}
	
	var patrn2 = /^[a-zA-Z]+$/;
	if(!username.value.match(patrn2))
	{
		alert("User Name must be in characters only");
		username.focus();
		return false;
	}
	if(!state.value.match(patrn2))
	{
		alert("State must be in characters only");
		state.focus();
		return false;
	}
	if(!fullname.value.match(patrn2))
	{
		alert("Full Name must be in characters only");
		fullname.focus();
		return false;
	}
	var patrn1 = /^[0-9]+$/;
	
	if(!pin.value.match(patrn1))
	{
		alert("PIN must be a number only");
		pin.focus();
		return false;
	}
	if(city.value=="none")
	{
		alert("Select any city in the list");
		city.focus();
		return false;
	}
	
	var patrn3 = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+.(com|in|org)$/;
	if(!email.value.match(patrn3))
	{
		alert("Please Enter Proper Email Id");
		email.focus();
		return false;
	}
	
	if(!phone.value.match(patrn1))
	{
		alert("Phone number must be a number only");
		phone.focus();
		return false;
	}
	
	var patrn4 = /^\d{4}-\d{2}-\d{2}$/;
	if(!dob.value.match(patrn4))
	{
		alert("DOB is in YYYY-MM-DD fromat only");
		dob.focus();
		return false;
	}
	return true;
}

