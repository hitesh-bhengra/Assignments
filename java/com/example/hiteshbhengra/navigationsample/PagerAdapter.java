package com.example.hiteshbhengra.navigationsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.MenuItem;

import com.example.hiteshbhengra.navigationsample.AboutVersion;
import com.example.hiteshbhengra.navigationsample.DeviceInformation;
import com.example.hiteshbhengra.navigationsample.MobileInformation;

public class PagerAdapter extends FragmentStatePagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        if(position == 0)
            frag = new DeviceInformation();
        else if(position == 1)
            frag = new MobileInformation();
        else if(position ==2)
            frag = new AboutVersion();
        

        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
