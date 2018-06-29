package com.example.niu.myapplication.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.niu.myapplication.BaseFragment;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by wanglei on 18-5-19.
 */

public class SlideFragment extends BaseFragment {

    @BindView(R.id.tv_slide_crashier)
    TextView tvSlideCrashier;
    @BindView(R.id.tv_slide_setting)
    TextView tvSlideSetting;
    Unbinder unbinder;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView) {
      /*  textViewItem1 = (TextView) rootView.findViewById(R.id.tv_item1);
        textViewItem2 = (TextView) rootView.findViewById(R.id.tv_item2);

        textViewItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        textViewItem2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {

            }
        });*/

    }

    @Override
    protected int getLayout() {
        return R.layout.slide_pop_view;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @OnClick({R.id.tv_slide_crashier, R.id.tv_slide_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_slide_crashier:
                ((MainActivity) activity).showCrashierLayout();
                break;
            case R.id.tv_slide_setting:
                ((MainActivity) activity).showSettingLayout();
                break;
        }
    }
}
