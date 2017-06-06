<html>
<head>
<link rel="stylesheet" href="style/style.css">
<script type="text/javascript" src="java script/feedbackValidate.js"> </script>
</head>
<body>
	<form action="Feedback"  onSubmit="return validate()"  target="frame2"
		method="post">
		<!-- <div>
			<img src="images/logo.jpg" height="130" width="130"
				style="image-orientation: 90deg;"><img src="images/feedh.jpg"
				height="130" width="1100">
		</div> -->
		<hr>
		<div align="left">
			<p>
				<img src="images/images2.jpg" height="400" width="400">
			</p>
		</div>
		<table class="feedback_table" align="right">
			<br>
			<br>
			<br>
			<p
				style="font-family: arial; color: #318CE7; font-size: 20px; margin-top: 20px; text-align: center;">
				Please take a moment to fill out this short survey form. Our goal is
				to provide you with the best possible information and service. Your
				opinion is very important to us and will help us to better meet your
				needs.
			<h5 style="color: green;">Your information is not shared or
				rented with third parties.</h5>
			</p>


			<tr>
				<td></td>
				<td><span id="fname_msg" />
				</td>
			</tr>
			<tr>
				<td align="center"><label class="fieldName"> Name</label>
				</td>
				<td><input type="text" name="fname"
					style="height: 30px; width: 250px">
				</td>

			</tr>
			<tr>
				<td></td>
				<td><span id="email_msg" />
				</td>
			</tr>
			<tr>
				<td align="center"><label class="fieldName">Emailaddress*
				</label>
				</td>
				<td><input type="text" name="email"
					style="height: 30px; width: 250px">
				</td>
			</tr>
			<tr>
				<td align="center"><label class="fieldName">Post Your
						Comments</label>
				</td>
				<td><textarea rows="5" cols="40" name="comments"></textarea>
				</td>
			</tr>
			<tr>
				<td align="center"><label class="fieldName">Ratings</label>
				</td>
				<td><input type="radio" name="Ratings" value="1">1 <input
					type="radio" name="Ratings" value="2">2 <input type="radio"
					name="Ratings" value="3">3 <input type="radio"
					name="Ratings" value="4">4 <input type="radio"
					name="Ratings" value="5">5</td>
			</tr>
			<tr>
				<td align="center"></td>
				<td><input type="submit" Value="Post Comments"
					style="height: 30px; width: 120px" style="background-color:#318CE7">
					<input type="reset" Value="Reset"
					style="height: 30px; width: 120px" style="background-color:#318CE7">
				</td>
			</tr>
		</table>
		<hr>
	</form>
</body>
</html>