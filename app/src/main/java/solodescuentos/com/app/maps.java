package solodescuentos.com.app;


import com.google.android.gms.maps.*;

import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.os.Bundle;


public class maps extends Activity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng casa = new LatLng(-12.196816 ,-76.996825);

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(casa, 19.0f));

        map.addMarker(new MarkerOptions()
                .title("Casa")
                .snippet("The most populous place in Peru.")
                .position(casa));
    }
}