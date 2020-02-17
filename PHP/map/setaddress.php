	<!DOCTYPE html>
	<html lang="en">
	<head>
		<title>Draw Features</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.2.1/css/ol.css" type="text/css">
		<style>
			#map {
				height: 100%;
			}
			html, body {
				height: 100%;
				margin: 0;
				padding: 0;
			}
		</style>
		<script src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.2.1/build/ol.js"></script>
	</head>
	<body>
		<div id="map" class="map"></div>
		<script type="text/javascript">
			var lat=null;
			var lon=null;
			function getLat(){
				return lat;
			}
			function getLng(){
				return lng;
			}
			var raster = new ol.layer.Tile({
				source: new ol.source.OSM()
			});
			var source = new ol.source.Vector({wrapX: false});
			var vector = new ol.layer.Vector({
				source: source,
				style: new ol.style.Style({
					
					image: new ol.style.Circle({
						radius: 8,
						fill: new ol.style.Fill({
							color: 'red'
						})
					})
				})
			});
			var map = new ol.Map({
				layers: [raster, vector],
				target: 'map',
				view: new ol.View({
					center: ol.proj.fromLonLat([90.4125,23.8103]),
					zoom: 15
				})
			});
			var modify = new ol.interaction.Modify({source: source});
			map.addInteraction(modify);
			var draw = new ol.interaction.Draw({
					source: source,
					type: "Point"
			});
			map.addInteraction(draw);
			map.on('contextmenu', function(evt){
				remove();
				
				var coords = ol.proj.toLonLat(evt.coordinate);
				lat = coords[1];
				lon = coords[0];
				var locTxt = "Latitude: " + lat + " Longitude: " + lon;
			});
			function remove(){
				var features = source.getFeatures();
				var lastFeature = features[features.length-1];
				source.clear();
				console.log(lastFeature);
				source.addFeature(lastFeature);
			}
			map.on('click', function(evt){
				remove();
				var coords = ol.proj.toLonLat(evt.coordinate);
				lat = coords[1];
				lon = coords[0];
			});
	</script>
	</body>
	</html>