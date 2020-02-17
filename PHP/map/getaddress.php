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
			var parts = window.location.search.substr(1).split("&");
			var $_GET = {};
			for (var i = 0; i < parts.length; i++) {
				var temp = parts[i].split("=");
				$_GET[decodeURIComponent(temp[0])] = decodeURIComponent(temp[1]);
			}
			console.log($_GET.lat);
			var map = new ol.Map({
				layers: [
					new ol.layer.Tile({
						source: new ol.source.OSM()
					}),
				],
				target: 'map',
				controls: ol.control.defaults({
					attributionOptions:({
						collapsible: false
					})
				}),
				view: new ol.View({
					center: ol.proj.fromLonLat([$_GET.lng,$_GET.lat]),
					zoom: 14
				})
				
			});

			var layer = new ol.layer.Vector({
				source: new ol.source.Vector({
					features: [
						new ol.Feature({
							geometry: new ol.geom.Point(ol.proj.fromLonLat([$_GET.lng,$_GET.lat]))
						})
					]
				}),
				style: new ol.style.Style({
					image: new ol.style.Circle({
					    radius: 8,
					    fill: new ol.style.Fill({
							color: 'red'
						})
					})
				})
			});
			map.addLayer(layer);

	</script>
	</body>
	</html>