package com.example.niu.myapplication.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.niu.myapplication.BaseFragment;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.activity.MainActivity;
import com.example.niu.myapplication.fragment.right.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.support.constraint.Constraints.TAG;

/**
 * Created by NIU on 2018/5/18.
 */

public class Left_crashier_fragment extends BaseFragment {
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.ll_top)
    RelativeLayout llTop;
    @BindView(R.id.ll_empty_goods)
    LinearLayout llEmptyGoods;
    @BindView(R.id.rv_goods)
    RecyclerView rvGoods;
    @BindView(R.id.ll_goods_items)
    RelativeLayout llGoodsItems;
    @BindView(R.id.tv_total_money)
    TextView tvTotalMoney;
    @BindView(R.id.tv_total_discount)
    TextView tvTotalDiscount;
    @BindView(R.id.tv_all_cancel)
    TextView tvAllCancel;
    @BindView(R.id.tv_all_collection)
    TextView tvAllCollection;
    @BindView(R.id.rl_youhuiquan)
    RelativeLayout rlYouhuiquan;
    Unbinder unbinder;

    @Override
    protected void initData() {
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected int getLayout() {
        return R.layout.cashier_left_fragment;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_all_collection})
    public void onViewClicked(View view){

        switch (view.getId()) {
            case R.id.tv_all_collection:

                ((MainActivity)getActivity()).showPayFragment();
                break;
        }

    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(MessageEvent messageEvent) {

        }
}
