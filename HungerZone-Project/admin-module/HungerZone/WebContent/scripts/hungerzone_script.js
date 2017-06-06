$(document).ready(
		function()
		{
			alert("Script Started........!");
			$("#categories").hide();
			$("#dishes").hide();
			$("#adrs").hide();
			
			loadRestaurants();
			loadAllCategories();
			loadAllDishes();
			
			$("#newRestaurantDiv").dialog({
				autoOpen : false,
				height : "auto",
				width : 400,
				modal : true,
				draggable : false,
				resizable : false,
				title : "Add Restaurant",
				show : {
					effect : "highlight",
					duration : 800
				},
				hide : {
					effect : "highlight",
					duration : 800
				},
				buttons : {
					"Add Restaurant" : function() {
						$("#newRestaurantForm").submit();
					},
					Cancel: function() {
				          $( this ).dialog( "close" );
				        }
					}
			});
			
			$("#newRestaurantCategoriesDiv").dialog({
				autoOpen : false,
				height : "auto",
				width : 400,
				modal : true,
				draggable : false,
				resizable : false,
				title : "Add Categories",
				show : {
					effect : "highlight",
					duration : 800
				},
				hide : {
					effect : "highlight",
					duration : 800
				},
				buttons : {
					"Add Categories" : function() {
						$("#newRestaurantCategoriesForm").submit();
					},
					Cancel: function() {
				          $( this ).dialog( "close" );
				        }
					}
			});
			
			$("#newRestaurantCategoryDishesDiv").dialog({
				autoOpen : false,
				height : 550,
				width : 800,
				modal : true,
				draggable : false,
				resizable : false,
				title : "Add Dishes",
				show : {
					effect : "highlight",
					duration : 800
				},
				hide : {
					effect : "highlight",
					duration : 800
				},
				buttons : {
					"Add Dishes" : function() {
						$("#newRestaurantCategoryDishesForm").submit();
					},
					Cancel: function() {
				          $( this ).dialog( "close" );
				        }
					}
			});
			
			$("#addRestaurant").click(
					function()
					{
						$( "#newRestaurantDiv" ).dialog( "open" );
						return false;
					});
			
			$("#addCategory").click(
					function()
					{
						$( "#newRestaurantCategoriesDiv" ).dialog( "open" );
						return false;
					});
			
			$("#addDish").click(
					function()
					{
						$( "#newRestaurantCategoryDishesDiv" ).dialog( "open" );
						return false;
					});
		});	

var myRestuarantName;

$(document).on("click",".restaurant", function()
		{
		alert("Clicked on Restaurant:"+$(this).text());
		
		$("#adrs").show();
		$("#dishes").hide();
		$('#dishesList li').remove();
		$('#categoriesList li').remove();
		
		$(".restaurant").css('background-color','white');
		$(this).css('background-color','BurlyWood');
		
		$("#categories").show();
		$("#categories").css('background-color','BurlyWood');
		
		$(".adrsRow").css('background-color','BurlyWood');
		
		myRestuarantName = $(this).text();
		
		$("#form1 #restaurantName").val(myRestuarantName);
		$("#newRestaurantCategoriesForm #restaurantName").val(myRestuarantName);
		
		loadCategories(myRestuarantName);
});

$(document).on("click",".category", function()
		{
		alert("Clicked on Category:"+$(this).text());
		
		$('#dishesList li').remove();
		
		$(".category").css('background-color','BurlyWood');
		$(this).css('background-color','SlateBlue');
		
		$("#dishes").show();
		$("#dishes").css('background-color','SlateBlue');
		
		$("#form1 #selectedCategory").val($(this).text());
		$("#newRestaurantCategoryDishesForm #restaurantName").val(myRestuarantName);
		$("#newRestaurantCategoryDishesForm #selectedCategory").val($(this).text());
		
		loadDishes(myRestuarantName,$(this).text());
});

function loadRestaurants()
{
	alert('Loading Restaurants...!');
	$.get('loadRestaurants', function(data) 
		{
			var restaurantsStr = data;
			var restaurants = restaurantsStr.split(",");
			for ( var i = 0; i < restaurants.length; i++) {
				$('#restaurantsList').append("<li><p class='restaurant'><input type='checkbox' name='selectedRestaurants' value="+restaurants[i]+">"+restaurants[i]+"</p></li>");
			}
		});
	
	$("#updateAddress").click(
			function()
			{
				alert("Updating....!");
				var restName = myRestuarantName;
				var address = $("#form1 #restaurantAddress").val();
				
				$.post('updateAddress/'+restName+'-'+address,function(data)
					   		{
								alert("New Address is:"+data);
							}
				);
				alert("Updated....!");
				return false;
			}
	);
	return false;
}
function loadCategories(restName)
{
	alert("Loading for "+restName);
	$.get('loadCategories/'+restName, function(data) 
		{
			var categoriesStr = data;
			var categories = categoriesStr.split(",");
			for ( var i = 0; i < categories.length-1; i++) {
				$('#categoriesList').append("<li><p class='category'><input type='checkbox' name='selectedCategories' value="+categories[i]+">"+categories[i]+"</p></li>");
			}
			$("#form1 #restaurantAddress").val(categories[categories.length-1]);
		});
}
function loadDishes(restName,catName)
{
	alert("Loading for "+restName+"-"+catName);
	$.get('loadDishes/'+restName+','+catName, function(data) 
		{
			var dishesStr = data;
			var dishes = dishesStr.split(",");
			for ( var i = 0; i < dishes.length; i++) {
				var namePrice = dishes[i].split("-");
				var dishName = namePrice[0];
				var dishPrice = namePrice[1];
				$('#dishesList').append("<li><p class='dish'><input type='checkbox' name='selectedDishes' value="+dishName+">"+dishName+"&nbsp;&nbsp;&nbsp;Rs"+dishPrice+"</p></li>");
			}
		});
}

function loadAllCategories()
{
	alert("Loading All Categories......!");
	$.get('loadAllCategories', function(data) 
			{
				var categoriesStr = data;
				var categories = categoriesStr.split(",");
				for ( var i = 0; i < categories.length; i++) {
					$('#addCategoriesList').append("<li><p><input type='checkbox' name='selectedCategories' value="+categories[i]+">"+categories[i]+"</p></li>");
				}
			});
}

function loadAllDishes()
{
	alert("Loading All Dishes ....!");
	$.get('loadAllDishes', function(data) 
		{
			var dishesStr = data;
			var dishes = dishesStr.split(",");
			for ( var i = 0; i < dishes.length; i++) {
				$('#addDishesList').append("<li><p>"+
				"<input type='checkbox' name='selectedDishes' value="+dishes[i]+">"+dishes[i]+
				"&nbsp;&nbsp;&nbsp; Price:<input type='text' size='6' name='dihesPrices'>Rs</p></li>");
			}
		});
}