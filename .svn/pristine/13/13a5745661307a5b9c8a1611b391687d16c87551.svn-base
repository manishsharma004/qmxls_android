package com.example.niu.myapplication.fragment.right;

import android.os.Bundle;
import android.support.annotation.MainThread;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.niu.myapplication.BaseFragment;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.activity.MainActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 整单取消
 * Created by wanglei on 18-5-22.
 */

public class UnSelectFragment extends BaseFragment {
    @BindView(R.id.tv_not_cancel)
    TextView tvNotCancel;
    @BindView(R.id.tv_sure_cancel)
    TextView tvSureCancel;
    Unbinder unbinder;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView) {

        EventBus.getDefault().register(this);

    }

    @Override
    protected int getLayout() {
        return R.layout.unselectgoods_layout;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

    @OnClick({R.id.tv_not_cancel, R.id.tv_sure_cancel})
    public void onViewClicked(View view) {
        MessageEvent messageEvent;

        switch (view.getId()) {

            case R.id.tv_not_cancel:

                 messageEvent = new MessageEvent("cancelAllDelete");

                EventBus.getDefault().post(messageEvent);
                ((MainActivity)activity).showRightCrashierLayout();


                break;
            case R.id.tv_sure_cancel:

                 messageEvent = new MessageEvent("allDelete");

                EventBus.getDefault().post(messageEvent);
                ((MainActivity)activity).showRightCrashierLayout();

                break;
        }
    }


    @Subscribe(threadMode= ThreadMode.MAIN)
    public void onEvent(MessageEvent messageEvent) {


    }
}
