function passengerValidate()
{
	var num = document.getElementById("seats").value;
	var passengerId;
	var passengerName;
	var dob;
	
	for(var i=1;i<=num;i++)
	{
	passengerId = document.getElementById("pid"+i);
	passengerName = document.getElementById("pnm"+i);
	dob = document.getElementById("dob"+i);
	
	if(passengerId.value.length==0)
	{
		alert("Passenger Id cann't be empty");
		passengerId.focus();
		return false;
	}
	var patrn1 = /^[0-9]+$/;
	
	if(!passengerId.value.match(patrn1))
	{
		alert("passengerId must be a number only");
		passengerId.focus();
		return false;
	}
	if(passengerName.value.length==0)
	{
		alert("Passenger Name cann't be empty");
		passengerName.focus();
		return false;
	}
	var patrn2 = /^[a-zA-Z]+$/;
	if(!passengerName.value.match(patrn2))
	{
		alert("Passenger Name must be in characters only");
		passengerName.focus();
		return false;
	}
	if(dob.value.length==0)
	{
		alert("Date Of Birth cann't be empty");
		dob.focus();
		return false;
	}
	var patrn4 = /^\d{4}-\d{2}-\d{2}$/;
	if(!dob.value.match(patrn4))
	{
		alert("DOB is in YYYY-MM-DD fromat only");
		dob.focus();
		return false;
	}
	}
	return true;
}

function defaults()
{
	var num = document.getElementById("num");
	
	for(var i=1;i<=num;i++)
	{
		var dob = document.getElementById("dob"+i);
		dob.value = "YYYY-MM-DD";
	}
}
