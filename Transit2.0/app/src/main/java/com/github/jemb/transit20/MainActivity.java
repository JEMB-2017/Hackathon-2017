package com.github.jemb.transit20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    //AddressVerifier av = new AddressVerifier(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("AddressVerifier", new AddressVerifier(this).isValidAddress("123 lane") + "");
    }
}
