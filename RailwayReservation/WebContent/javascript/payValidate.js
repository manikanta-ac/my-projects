function payValidate()
{
	var number = document.getElementById("num");
	var name = document.getElementById("name");
	var month = document.getElementById("month");
	var year = document.getElementById("year");

	if(number.value.length==0)
	{
		alert("Please Enter Card Number");
		number.focus();
		return false;
	}
	else if(!(number.value.length==16))
	{
		alert("Card Number must be 16 digits");
		number.focus();
		return false;
	}
	else if(!number.value.match(/^[0-9]+$/))
	{	
		alert("Card Number consists of numbers only");
		number.focus();
		return false;
	}

	else if(name.value.length==0)
	{
		alert("Please Enter Card Holder Name");
		name.focus();
		return false;
	}

	else if(!name.value.match(/^[a-zA-Z]+$/))
	{
		alert("Card Name consists of characters only");
		name.focus();
		return false;
	}
	else if(month.value=="MM"||year.value=="YY")
	{
		alert("Please Enter Date");
		month.focus();
		return false;
	}
	else
	{	
		return true;
	}
}