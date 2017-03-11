package com.github.jemb.transit20;

import android.location.Address;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	AddressVerifier addressVerifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		addressVerifier = new AddressVerifier(this);

		Log.i("AddressVerifier", addressVerifier.isValidAddress("123 lane") + "");
		googleServicesAvailable();

//		ArrayList<Address> addressList = (ArrayList<Address>) addressVerifier.getAddresses("Bishop Museum");
//		for (int i = 0; i < addressList.size(); i++) {
//			Log.i("Address", "[" + i + "] " + addressList.get(i).getAddressLine(0));
//			Log.i("Address", "[" + i + "] " + addressList.get(i).getAddressLine(1));
//			Log.i("Address", "[" + i + "] " + addressList.get(i).getAddressLine(2));
//			Log.i("Address", "[" + i + "] " + addressList.get(i).getAddressLine(3));
//			Log.i("Address", "[" + i + "] " + addressList.get(i).getFeatureName());
//		}
	}

	public void onSubmit(View view) {
		ArrayList<Address> addressList = (ArrayList<Address>) addressVerifier.getAddresses(((EditText) findViewById(R.id.destinationInput)).getText().toString());
		for (int i = 0; i < addressList.size(); i++) {
			Log.i("Address", "[" + i + "] " + addressList.get(i).getAddressLine(0));
			Log.i("Address", "[" + i + "] " + addressList.get(i).getAddressLine(1));
			Log.i("Address", "[" + i + "] " + addressList.get(i).getAddressLine(2));
			Log.i("Address", "[" + i + "] " + addressList.get(i).getAddressLine(3));
			Log.i("Address", "[" + i + "] " + addressList.get(i).getFeatureName());
			setContentView(R.layout.activity_map);
		}

	}
	public boolean googleServicesAvailable(){
		GoogleApiAvailability api = GoogleApiAvailability.getInstance();
		int isAvailable = api.isGooglePlayServicesAvailable(this);
		if(isAvailable != ConnectionResult.SUCCESS)
		{
			int duration = Toast.LENGTH_SHORT;
			Toast myToast = Toast.makeText(this,"Google play services are not installed on this device",duration);
			myToast.show();
			return false;

        }
		return true;
	}
}
