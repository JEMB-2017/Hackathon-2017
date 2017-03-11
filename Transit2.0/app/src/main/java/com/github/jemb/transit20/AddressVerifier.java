package com.github.jemb.transit20;
import com.google.*;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.util.Log;

import java.util.List;


/**
 * Created by willj on 3/10/2017.
 */

public class AddressVerifier {
    private Geocoder geo;
    public AddressVerifier(Context context)
    {
        geo = new Geocoder(context);
    }
    // returns true if the address is valid otherwise returns false
    boolean isValidAddress(String address)
    {
        if(geo.isPresent())
        {
            try {
                List<Address> addressList = geo.getFromLocationName(address, 1);
                if(!addressList.isEmpty())
                {
                    return true;
                }
            }
            catch(java.io.IOException error)
            {
                String message = error.getMessage();
                Log.e("<error>",message);
            }

        }
        return false;
    }
}
