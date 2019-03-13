package com.example.prudhvi.signal;

import com.parse.Parse;
import android.app.Application;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("edf607032d9924f88d3301a4261b036ea4d9ba3d")
                .clientKey("868fa2fd124675b56827530e31d9e4c6d9ddcc5d")
                .server("http://34.201.148.66:80/parse/")
                .build()
        );
    }
}