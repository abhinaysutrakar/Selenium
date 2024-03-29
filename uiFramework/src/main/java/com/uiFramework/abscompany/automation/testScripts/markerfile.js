
$(document).ready(function() {
  var mapEl = $('#map');
  
  handler = Gmaps.build('Google');
  handler.buildMap({
    provider: {
      disableDefaultUI: true
    },
    internal: {
      id: 'map'
    }
  },
  function() {
    markers = handler.addMarkers([
      {
        "lat": 45.7554626,
        "lng": 21.2240976,
      }
    ], { optimized: optimized }); // It's true or false
    handler.bounds.extendWith(markers);
    handler.map.centerOn({
      lat: 45.7554626,
      lng: 21.2240976
    });
    handler.getMap().setZoom(13);

    if (!optimized) {
      // We're adding a container for the markers.
      // That way we can find all the markers by
      // doing $("#markers img").
      var myoverlay = new google.maps.OverlayView();

      myoverlay.draw = function () {
        this.getPanes().markerLayer.id = 'markers';
      };

      myoverlay.setMap(handler.getMap());
    }
  });
});