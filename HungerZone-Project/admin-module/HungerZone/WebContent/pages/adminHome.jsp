<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/start/jquery-ui.css" type="text/css" media="all" />

<script type="text/javascript" src="${pageContext.request.contextPath}/static/scripts/hungerzone_script.js"></script>
<head>
<title>Administrator Home</title>
</head>
<body>
<h2 align="center">Welcome To Admin</h2>
<form:form id="form1" method="post" action="homeAction" commandName="adminHome">
<center>
<table width="65%">
	<tr>
		<td><pre>                   </pre></td>
		<td><input type="submit" value="Delete Restaurant" name="deleteRestaurants"/></td>
		<td><button id="addRestaurant">Add Restaurant</button></td>
		<td><input type="submit" value="Logout" name="logout"/></td>
	</tr>
	<tr id="adrs">
		<td><pre>                   </pre></td>
		<td class="adrsRow" colspan="2">
			Address <form:input path="restaurantAddress"/>
		</td>
		<td class="adrsRow"><button id="updateAddress">Update</button></td>
	</tr>
	<tr>
		<td>
			<h3>Restaurants</h3>
			<ul id="restaurantsList" style='list-style: none;'></ul>
		</td>	

		<td id="categories">
			<h3>Categories</h3>
			<form:hidden path="restaurantName"/>
			<button id="addCategory">Add</button>
			<input type="submit" value="Delete" name="deleteCategories"/>
			<ul id="categoriesList" style="list-style: none;"></ul>
		</td>

		<td id="dishes">
			<h3>Dishes</h3>
			<form:hidden path="selectedCategory"/>
			<button id="addDish">Add</button>
			<input type="submit" value="Delete" name="deleteDishes"/>
			<ul id="dishesList" style="list-style: none;"></ul>
		</td>
	</tr>			
</table>
</center>
</form:form>

<div id="newRestaurantDiv">
	<form:form id="newRestaurantForm" action="addRestaurant" method="post" commandName="addRestaurant">
	<table>
		<tr>
			<td>Restaurant Name</td>
			<td><form:input path="restaurantName"/></td>
		</tr>
		<tr>
			<td>Restaurant Address</td>
			<td><form:input path="restaurantAddress"/></td>
		</tr>
	</table>
	</form:form>
</div>

<div id="newRestaurantCategoriesDiv">
	<form:form id="newRestaurantCategoriesForm" action="addRestaurantCategories" method="post" commandName="addRestaurant">
	<table>
	<tr>
			<td>Restaurant:
				<form:input readonly='true' path="restaurantName"/>
				<form:hidden path="restaurantAddress"/>
			</td>
		</tr>
		<tr>
			<th>Select Categories</th>
		</tr>
		<tr>
			<td>
				<ul id="addCategoriesList" style="list-style: none;"></ul>
			</td>
		</tr>
	</table>
	</form:form>
</div>

<div id="newRestaurantCategoryDishesDiv">
	<form:form  id="newRestaurantCategoryDishesForm" action="addRestaurantCategoryDishes" method="post" commandName="addRestaurant">
	<table>
	<tr>
			<td>Restaurant:
				<form:input readonly='true' path="restaurantName"/>
			</td>
		</tr>
		<tr>
			<td>Category:
				<form:input readonly='true' path="selectedCategory"/>
			</td>
		</tr>
		<tr>
			<th>Select Dishes</th>
		</tr>
		<tr>
			<td>
				<ul id="addDishesList" style="list-style: none;"></ul>
			</td>
		</tr>
	</table>
	</form:form>
</div>

</body>
</html>