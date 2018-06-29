package com.example.niu.myapplication.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.niu.myapplication.BaseFragment;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.adapter.PayFragmentAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by NIU on 2018/5/18.
 */

public class PayFragment extends BaseFragment {
    @BindView(R.id.tl_pay_method)
    TabLayout tlPayMethod;
    @BindView(R.id.vp_pay_method)
    ViewPager vpPayMethod;
    Unbinder unbinder;
    private ArrayList<Fragment>fragmentArrayList;
    private PayFragmentAdapter payFragmentAdapter;
    private Fragment thirdFragment;
    private Fragment crashFragment;
    private Fragment payOtherFragment;
    public static final String TAG = PayFragment.class.getSimpleName();
    @Override
    protected void initData() {

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        Log.d(TAG, "onHiddenChanged: ");
        if (!hidden){
            if (vpPayMethod!=null)
                vpPayMethod.setCurrentItem(1);

        }

    }
    @Override
    protected void initView(View rootView) {

        thirdFragment = new ThridFragment();
        crashFragment = new CrashFragment();
        payOtherFragment = new PayOtherFragment();
        fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(thirdFragment);
        fragmentArrayList.add(crashFragment);
        fragmentArrayList.add(payOtherFragment);
        payFragmentAdapter = new PayFragmentAdapter(getChildFragmentManager());
        payFragmentAdapter.setFragmentList(fragmentArrayList);
        tlPayMethod.setupWithViewPager(vpPayMethod);
        vpPayMethod.setAdapter(payFragmentAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.pay_fragment;
    }




}
