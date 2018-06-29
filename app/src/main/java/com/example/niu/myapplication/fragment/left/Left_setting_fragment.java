package com.example.niu.myapplication.fragment.left;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
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

public class Left_setting_fragment extends BaseFragment {

    @BindView(R.id.tv_pay_setting)
    TextView tvPaySetting;
    @BindView(R.id.tv_system_setting)
    TextView tvSystemSetting;
    @BindView(R.id.view_system_setting)
    View viewSystemSetting;
    @BindView(R.id.view_pay_setting)
    View viewPaySetting;
    Unbinder unbinder;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView) {


       /* rootView.findViewById(R.id.tv_system_setting)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.showShortToast("test");
                    }
                });*/
    }

    @Override
    protected int getLayout() {

        return R.layout.setting_item_fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @SuppressLint("ResourceAsColor")
    @OnClick({R.id.tv_system_setting, R.id.view_system_setting, R.id.tv_pay_setting, R.id.view_pay_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {


            case R.id.tv_system_setting:

                //ToastUtils.showShortToast("tv_system_setting");
                ((MainActivity) activity).showSettingSystemViewLayout();

                tvSystemSetting.setTextColor(R.color.TvBlue);

                viewSystemSetting.setBackgroundColor(R.color.TvBlue);
                tvPaySetting.setTextColor(R.color.TvBlack);
                viewPaySetting.setBackgroundColor(R.color.TvGray);

                break;
            case R.id.tv_pay_setting:
                // ToastUtils.showShortToast("tv_pay_setting");

                ((MainActivity) activity).showSettingPayViewLayout();
                tvPaySetting.setTextColor(R.color.TvBlue);
                viewPaySetting.setBackgroundColor(R.color.TvBlue);
                tvSystemSetting.setTextColor(R.color.TvBlack);
                viewSystemSetting.setBackgroundColor(R.color.TvGray);
                break;

        }
    }
}
