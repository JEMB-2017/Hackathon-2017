package com.github.jemb.transit20;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by willj on 3/10/2017.
 */

public class AddressVerifier {
	private Geocoder geo;

	public AddressVerifier(Context context) {
		geo = new Geocoder(context);
	}

	public List<Address> getAddresses(String locationName) {
		try {
			return geo.getFromLocationName(locationName, 10);
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	// returns true if the address is valid otherwise returns false
	public boolean isValidAddress(String address) {
		if (Geocoder.isPresent()) {
			try {
				List<Address> addressList = geo.getFromLocationName(address, 1);
				if (!addressList.isEmpty()) {
					return true;
				}
			} catch (java.io.IOException error) {
				String message = error.getMessage();
				Log.e("<error>", message);
			}

		}
		return false;
	}
}
