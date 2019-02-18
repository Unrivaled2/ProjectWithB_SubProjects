package com.jiangyychn.csdndemo_mapplace;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

public class App extends Application {

    public static LocationService locationService;

    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(this);
        locationService = new LocationService(getApplicationContext());
    }
}
