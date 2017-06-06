function validate()
			{
				document.getElementById("fname_msg").innerHTML="";
				document.getElementById("lname_msg").innerHTML="";

				document.getElementById("emailid_msg").innerHTML="";
				document.getElementById("password_msg").innerHTML="";
				document.getElementById("repassword_msg").innerHTML="";
				
				document.getElementById("clgname_msg").innerHTML="";
				document.getElementById("stream_msg").innerHTML="";
				document.getElementById("percentage_msg").innerHTML="";
				document.getElementById("university_msg").innerHTML="";
				
				if(document.forms[0].fname.value.length==0)
				{
					document.getElementById("fname_msg").innerHTML="Enter the firstname";
					document.forms[0].fname.focus();
					return false;
				}
				if(document.forms[0].lname.value.length==0)
				{
					document.getElementById("lname_msg").innerHTML="Enter the lastname";
					document.forms[0].lname.focus();
					return false;
				}
                		if(document.forms[0].id.value.length==0)
				{
					document.getElementById("emailid_msg").innerHTML="Enter the Email-id";
					document.forms[0].id.focus();
					return false;
				}
                		if(document.forms[0].password.value.length==0)
				{
					document.getElementById("password_msg").innerHTML="Enter the Password";
					document.forms[0].password.focus();
					return false;
				}
               			 if(document.forms[0].repassword.value.length==0)
				{
					document.getElementById("repassword_msg").innerHTML="Enter the Re-Password";
					document.forms[0].repassword.focus();
					return false;
				}
				if(document.forms[0].password.value!=document.forms[0].repassword.value)
				{
						alert("Enter correct Password and Re-Password.");
						return false;
				}
				
				var qualification= document.forms[0].Qualification;
				document.getElementById("quali").innerHTML="";

				if(qualification.value=="none")
				{
					document.getElementById("quali").innerHTML="Select your Qualification";
					document.forms[0].Qualification.focus();
					return false;
				}
				
				
				if(document.forms[0].cname.value.length==0)
				{
					document.getElementById("clgname_msg").innerHTML="Enter the College Name";
					document.forms[0].cname.focus();
					return false;
				}
				if(document.forms[0].stream.value.length==0)
				{
					document.getElementById("stream_msg").innerHTML="Enter the stream/Specialisation";
					document.forms[0].stream.focus();
					return false;
				}
				if(document.forms[0].percentage.value.length==0)
				{
					document.getElementById("percentage_msg").innerHTML="Enter the percentage";
					document.forms[0].percentage.focus();
					return false;
				}
				if(document.forms[0].university.value.length==0)
				{
					document.getElementById("university_msg").innerHTML="Enter the university";
					document.forms[0].university.focus();
					return false;
				}
				
				var passedoutYear= document.forms[0].YearOfPassing;
				document.getElementById("yop_msg").innerHTML="";

				if(passedoutYear.value=="select")
				{
					document.getElementById("yop_msg").innerHTML="Select Year Of Passing";
					document.forms[0].YearOfPassing.focus();
					return false;
				}
			}