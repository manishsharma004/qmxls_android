package com.example.niu.myapplication.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by NIU on 2018/5/18.
 */

public class PayFragmentAdapter extends FragmentPagerAdapter {
    public ArrayList<Fragment>fragmentArrayList;

    public String[]titles = {"支付宝/微信","现金","其他方式"};
    public PayFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragmentList(ArrayList<Fragment>fragmentList){

        fragmentArrayList = fragmentList;

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }
}
