function searchValidate()
{
	var fromCity = document.getElementById("fc");
	var toCity = document.getElementById("tc");
	
	if(fromCity.value.length==0)
	{
		alert("Please Enter From City");
		fromCity.focus();
		return false;
	}
	if(toCity.value.length==0)
	{
		alert("Please Enter To City");
		toCity.focus();
		return false;
	}
	
	return true;
}