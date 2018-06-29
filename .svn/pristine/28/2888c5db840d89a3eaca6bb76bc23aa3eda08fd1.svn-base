package com.example.niu.myapplication.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by NIU on 2018/5/18.
 */

public class GoodsAndClientFragmentAdapter extends FragmentPagerAdapter {


     private  ArrayList<Fragment>fragmentArrayList;

     private String []titles = {"商品","客户"};
     private Context mContext;

     public GoodsAndClientFragmentAdapter(FragmentManager fm,
                                         ArrayList<Fragment>fragmentArrayList, Context context) {
        super(fm);

         this.fragmentArrayList =fragmentArrayList;
         this.mContext = context;

    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }
}
