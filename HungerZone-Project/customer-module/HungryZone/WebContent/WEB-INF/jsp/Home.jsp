<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/themes/pepper-grinder/jquery-ui.css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/jquery-ui.min.js"></script>

<script>
	$(function() {
		$("#tabs").tabs();
		setInterval("slideShow()", 2000);
		$("#aboutus").dialog({
			autoOpen : false,
			height : 300,
			width : 350,
			modal : true,
			title : "About us",
			buttons : {
				close : function() {
					$(this).dialog("close");
				}
			}
		});
		$("#about").click(function() {
			$("#aboutus").dialog("open");
		});
		$("#contactus").dialog({
			autoOpen : false,
			height : 300,
			width : 350,
			modal : true,
			title : "Contact us",
			buttons : {
				
				close : function() {
					$(this).dialog("close");
				}
			}
		});
		$("#contact").click(function() {
			$("#contactus").dialog("open");
		});
	});
	$("#about").click(function() {
		$("#aboutus").dialog("open");
	});

	function slideShow() {
		var curPic = $("#tabs-1 div.current");

		var nxtPic = curPic.next();

		if (nxtPic.length == 0) {

			nxtPic = $("#tabs-1 div:first");
		}
		curPic.removeClass("current").addClass("prev");

		nxtPic.css({
			opacity : 0.0
		}).addClass("current").animate({

			opacity : 1.0
		}, 1000, function() {
			curPic.removeClass("prev");

		});
	}
</script>
<style>
#tabs-1 {
	height: 600px;
	width: 800px;
}

#tabs-1 div.current {
	z-index: 2;
}

#tabs-1 div {
	position: absolute;
	z-index: 0;
}

#tabs-1 div.prev {
	z-index: 1;
}
</style>
</head>
<body>
<c:out value="${msg}"></c:out>
	<img
		src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\head.png"
		align="top" height="100" width="1200" />

	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">Home</a></li>
			<li><a href="#tabs-2" id="about">About us</a></li>
			<li><a href="#tabs-3" id="contact">Contact us</a></li>
			<li><a href="#tabs-4" id="feedbk">Feed Back</a></li>
		</ul>
		<center>
			<div id="tabs-1">
				<div>
					<img width="600" height="300"
						src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\32.jpg" />
				</div>
				<div>
					<img width="600" height="300"
						src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\3-Indian-Thali.jpg" />
				</div>
				<div>
					<img width="600" height="300"
						src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\Bar_Sugo_Restaurant_Norwalk_CT_8.jpg" />
				</div>
				<div>
					<img width="600" height="300"
						src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\bkgd0.jpg" />
				</div>
				<div>
					<img width="600" height="300" alt="Chinese"
						src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\jjambbong.jpg" />
				</div>
				<div>
					<img width="600" height="300"
						src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\indian_food.jpg" />
				</div>
				<div>
					<img width="600" height="300"
						src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\indian-cuisine-2.jpg" />
				</div>
				<div>
					<img width="600" height="300"
						src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\Item057.jpg" />
				</div>
				<div>
					<img width="600" height="300"
						src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\japanese_food_by_ribonread127.jpg" />
				</div>
				<div>
					<img width="600" height="300"
						src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\japanese-food.jpg" />
				</div>
				<div>
					<img width="600" height="300"
						src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\jun-06_cranberry-pimms_b_330x330.jpg" />
				</div>
				<div>
					<img width="600" height="300"
						src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\mexican-food-brisbane.jpg" />
				</div>
				<div>
					<img width="600" height="300"
						src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\o-EASY-ITALIAN-RECIPES-facebook.jpg" />
				</div>
				<div>
					<img width="600" height="300"
						src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\pizza-free-wallpaper_1920x1200_82157.jpg" />
				</div>
				<div>
					<img width="600" height="300"
						src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\t1larg.mexican.food.ts.jpg" />
				</div>
				<div>
					<img width="600" height="300"
						src="\\10.10.214.40\UserProfiles\umesh.kumar\.V2\Desktop\Umesh_K\Important notes\Assignments\Project\HungryZone\WebContent\images\uy9vi95h_4p81_1.jpg" />
				</div>

			</div>
		</center>
		<div id="tabs-2">
			<div id="aboutus">Wellcome to HungerZone world!!<br>Here, your choice and your money, we only means.</div>
		</div>
		<div id="tabs-3">
			<div id="contactus">@Java Sip Batch<br>Span InfoTech India Pvt. Ltd.<br>Bansankari Bangalore</div>
		</div>
		<div id="tabs-4">
			<div id="feedback">
				<form:form id="form" method="get" action="feedback"
					modelAttribute="feedback">
					<table align="center"
						style="border-width: 5px; border-style: solid;">
						<tr>
							<form:label path="userName" style="font-size: 15px">UserName</form:label>
							<form:input path="userName"  />
						</tr>
						<tr><form:label path="email" style="font-size: 15px">Email</form:label>
							<form:input path="email" />
						</tr>
						<tr><form:label path="messege" style="font-size: 15px">Feedback</form:label>
							<form:textarea path="messege" />
						</tr>
						<tr><input type="submit" value="submit" align="right"/></tr>
					</table>
					
				</form:form>
				
			</div>
		</div>
	</div>

</body>
</html>