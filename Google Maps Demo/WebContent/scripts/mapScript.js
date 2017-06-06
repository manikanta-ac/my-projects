var map;
var MY_MAPTYPE_ID = 'custom_style';

function initialize() {
  var mapOptions = {
    zoom: 8,
    center: new google.maps.LatLng(-34.397, 150.644),
    mapTypeControlOptions: {
      mapTypeIds: [google.maps.MapTypeId.ROADMAP, MY_MAPTYPE_ID]
    },
    mapTypeId: MY_MAPTYPE_ID
  };
  map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);
}

google.maps.event.addDomListener(window, 'load', initialize);

function showPlaces(){
	/*var marker = new google.maps.Marker({
	      map: map,
	      title: 'Hello World!'
	  });*/
	
	var featureOpts = [{
	                	   featureType: 'poi.park',
	                	   stylers: [{ color: '#33FF33' }]
	                   },
	                   {
	                	   featureType: 'poi.school',
	                	   stylers: [{ color: '#0000CC' }]
	                   }];
	
		var styledMapOptions = {
		    name: 'Custom Style'
		  };

		  var customMapType = new google.maps.StyledMapType(featureOpts, styledMapOptions);

		  map.mapTypes.set(MY_MAPTYPE_ID, customMapType);
}