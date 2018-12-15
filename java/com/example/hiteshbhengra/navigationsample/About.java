package com.example.hiteshbhengra.navigationsample;

import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class About extends AppCompatActivity implements DeviceInformation.OnFragmentInteractionListener, MobileInformation.OnFragmentInteractionListener, AboutVersion.OnFragmentInteractionListener {

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mViewPager = findViewById(R.id.viewpager);
        mPagerAdapter = new com.example.hiteshbhengra.navigationsample.PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
