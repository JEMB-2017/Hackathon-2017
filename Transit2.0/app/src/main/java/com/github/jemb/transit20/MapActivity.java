package com.github.jemb.transit20;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;


public class MapActivity extends AppCompatActivity {
	private GoogleMap map;
	LocationManager locMan = (LocationManager) getSystemService(LOCATION_SERVICE);
	protected class MapCallback implements OnMapReadyCallback {
		@Override
		public void onMapReady(GoogleMap googleMap) {

			map = googleMap;
			if(checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == PackageManager.PERMISSION_GRANTED) {
				map.setMyLocationEnabled(true);
			}
			else
			{
				Log.e("bad error","sorry the application doesnt have Fine Location access");
			}

		}
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        initMap(new MapCallback());

    }
    private void initMap(OnMapReadyCallback c)
    {
        MapFragment fragment = (MapFragment)getFragmentManager().findFragmentById(R.id.mainMap);
        fragment.getMapAsync(c);
    }


}
