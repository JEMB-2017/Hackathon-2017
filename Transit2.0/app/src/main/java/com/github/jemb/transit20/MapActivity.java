package com.github.jemb.transit20;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;


public class MapActivity extends AppCompatActivity {
	private GoogleMap map;
	protected class MapCallback implements OnMapReadyCallback {
		@Override
		public void onMapReady(GoogleMap googleMap) {

			map = googleMap;
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
