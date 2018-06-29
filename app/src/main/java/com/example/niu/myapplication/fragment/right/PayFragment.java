package com.example.niu.myapplication.fragment.right;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.example.niu.myapplication.BaseFragment;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.adapter.PayFragmentAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

import static com.example.niu.myapplication.fragment.PayFragment.TAG;

/**
 * Created by NIU on 2018/5/18.
 * 管理支付页面
 */

public class PayFragment extends BaseFragment {
    @BindView(R.id.tl_pay_method)
    TabLayout tlPayMethod;
    @BindView(R.id.vp_pay_method)
    ViewPager vpPayMethod;
    Unbinder unbinder;
    private ArrayList<Fragment> fragmentArrayList;
    private PayFragmentAdapter payFragmentAdapter;
    private Fragment thirdFragment;
    private Fragment crashFragment;
    private Fragment payOtherFragment;

    @Override
    protected void initData() {

    }

    public PayFragment() {
       /* thirdFragment = new ThridFragment();
        crashFragment = new CrashFragment();
        payOtherFragment = new PayOtherFragment();*/
    }

    @Override
    protected void initView(View rootView) {

        EventBus.getDefault().register(this);
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

        //默认让其先显示第二个
     //   vpPayMethod.setCurrentItem(1);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        Log.d(TAG, "onHiddenChanged234: hide= " + hidden);

        if (!hidden) {

            if (vpPayMethod != null) {
               // vpPayMethod.setCurrentItem(1);

            }
        } else if (hidden) {
            Log.d(TAG, "onHiddenChanged234678888: hide= " + hidden);

            //EventBus.getDefault().post(new MessageEvent("cancelCollection"));

        }
    }

    @Override
    protected int getLayout() {

        return R.layout.pay_fragment;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)

    public void onEvent(MessageEvent messageEvent) {


    }
}
