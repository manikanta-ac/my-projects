var products = angular.module("products", ["ngRoute"]);

products.config(['$routeProvider', function($routeProvider) {
	$routeProvider
    .when("/product", {
        templateUrl : "product.html",
        controller : "ViewProductController"
    })
    .when("/viewCart", {
        templateUrl : "cart.html",
        controller : "CartController"
    })
}]);

products.controller("ProductController", function($scope) {
	this.prodcuts = [
	                 {
	                	 id: "1",
	                	 name: "Lenovo",
	                	 desc: "Lenovo Laptop",
	                	 cost: "40000"
	                  },
	                  {
	                	 id: "2",
	                	 name: "Lg",
	                	 desc: "Lg Mobile",
	                	 cost: "20000"
		               },
		               {
	                	 id: "3",
	                	 name: "Camel",
	                	 desc: "Camel Notepad",
	                	 cost: "25"
	                    }
	                 ];
	
	$scope.selectedProduct = {};
	this.showProduct = function(prod){
		$scope.selectedProduct = prod;
	};
	$scope.cart = [];
});

products.controller("ViewProductController", function($scope) {
	$scope.addToCart = function(prod) {
		var exists = false;
		var cart = $scope.cart;
		for(var i=0; i< cart.length; i++) {
			if(cart[i].product.id == prod.id) {
				cart[i].quantity += 1;
				exists = true;
				break;
			}
		}
		if(!exists) {
			$scope.cart.push(
					{
						product: prod, 
						quantity: 1
					});
		}
	};
});

products.controller("CartController", function($scope) {
	$scope.removeFromCart = function(id) {
		var cart = $scope.cart;
		for(var i=0; i< cart.length; i++) {
			if(cart[i].product.id == id) {
				cart[i].quantity -= 1;
				if(cart[i].quantity == 0) {
					cart.splice(i, 1);
				}
			}
		}
		$scope.totalCost = getTotal();
	};
	
	$scope.totalCost = getTotal();
	
	function getTotal() {
		var cart = $scope.cart;
		var total = 0;
		for(var i=0; i< cart.length; i++) {
			total += cart[i].product.cost * cart[i].quantity;
		}
		return total;
	}
});