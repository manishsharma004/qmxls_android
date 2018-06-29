package com.example.niu.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.weyye.hipermission.HiPermission;
import me.weyye.hipermission.PermissionCallback;

/**
 * 毅耘科技
 * Created by NIU on 2018/5/18.
 */

public abstract class BaseFragment extends Fragment{


    public Activity activity;
    public View rootView;
    public boolean isFragmentShow;
    private Unbinder mUnBinder;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater,container,savedInstanceState);
        rootView = inflater.inflate(getLayout(),container,false);
        mUnBinder = ButterKnife.bind(this,rootView);
//        EventBus.getDefault().register(this);
        initView(rootView);
        initData();

        return rootView;

    }

    protected abstract void initData();

    protected abstract void initView(View rootView);

    protected abstract int getLayout();

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        isFragmentShow = !hidden;
    }

    @Override
    public void onDestroy() {
        if(mUnBinder!=null){

            mUnBinder.unbind();
        }
       // EventBus.getDefault().unregister(this);
        super.onDestroy();

    }


    public boolean isShow(){
        return isFragmentShow;

    }

}

