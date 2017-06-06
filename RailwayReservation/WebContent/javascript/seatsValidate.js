function seatsValidate()
{
	var type = document.getElementById("cls");
	
	if(type.value=="none")
	{
		alert("Select Any Class");
		type.focus();
		return false;
	}
	var num = document.getElementById("num");
	
	if(num.value=="0")
	{
		alert("Select Number of Seats");
		num.focus();
		return false;
	}
	return true;
}