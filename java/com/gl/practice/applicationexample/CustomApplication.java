package com.gl.practice.applicationexample;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

public class CustomApplication extends Application {

    ArrayList<String> mArrayList;

    public CustomApplication() {
        super();
        mArrayList = new ArrayList();
        mArrayList.add("Hitesh");
        mArrayList.add("Yogesh");
        mArrayList.add("Rajat");
        mArrayList.add("Ankita");
        mArrayList.add("Simran");
        Log.d("CustomApplicationTest","Constructor method invoked");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("CustomApplicationTest","onCreate() method invoked");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        Log.d("CustomApplicationTest","onTerminate() method invoked");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d("CustomApplicationTest","onLowMemory() method invoked");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        mArrayList.clear();
        Log.d("CustomApplicationTest","ArrayList Cleared");
        Log.d("CustomApplicationTest","onTrimMemory() method invoked");
    }
}
