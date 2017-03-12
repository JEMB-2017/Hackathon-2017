package com.github.jemb.transit20;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;


public class MapActivity extends AppCompatActivity {
	private GoogleMap map;
//	LocationManager locMan = (LocationManager) getSystemService(LOCATION_SERVICE);

	protected class MapCallback implements OnMapReadyCallback {
		@Override
		public void onMapReady(GoogleMap googleMap) {
			map = googleMap;

			if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == PackageManager.PERMISSION_GRANTED) {
				map.setMyLocationEnabled(true);
				Log.i("Permission", "Permission granted");
			} else {
				Log.e("bad error", "sorry the application doesnt have Fine Location access");
			}

		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		initMap(new MapCallback());

		Log.i("Permission", ContextCompat.checkSelfPermission(this,
				"android.permission.ACCESS_COARSE_LOCATION") + "");

		if (ContextCompat.checkSelfPermission(this,
				"android.permission.ACCESS_COARSE_LOCATION")
				!= PackageManager.PERMISSION_GRANTED) {

			// Should we show an explanation?
//			if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//			"android.permission.ACCESS_COARSE_LOCATION")){

			// Show an explanation to the user *asynchronously* -- don't block
			// this thread waiting for the user's response! After the user
			// sees the explanation, try again to request the permission.

//			} else {

			// No explanation needed, we can request the permission.

			ActivityCompat.requestPermissions(this,
					new String[]{"android.permission.ACCESS_COARSE_LOCATION"},
					1);

			// MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
			// app-defined int constant. The callback method gets the
			// result of the request.
//			}
		}
	}

	private void initMap(OnMapReadyCallback c) {
		MapFragment fragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mainMap);
		fragment.getMapAsync(c);
	}

}
