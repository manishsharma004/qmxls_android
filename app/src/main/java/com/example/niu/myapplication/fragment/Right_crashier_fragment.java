package com.example.niu.myapplication.fragment;

import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.niu.myapplication.BaseFragment;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.adapter.GoodsAndClientFragmentAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by NIU on 2018/5/18.
 */

public class Right_crashier_fragment extends BaseFragment {

   @BindView(R.id.tv_guadan)
    TextView tvGuadan;
     @BindView(R.id.tv_qudan)
    TextView tvQudan;
    @BindView(R.id.ll_bottom_menu)
    LinearLayout llBottomMenu;
    TabItem tiGoods;
    TabItem tiClient;
    @BindView(R.id.tl_goods_client)
    TabLayout tlGoodsClient;
    @BindView(R.id.vp_goods_client)
    ViewPager vpGoodsClient;
    Unbinder unbinder;
    private ArrayList<Fragment> fragmentArrayList;
    private GoodsAndClientFragmentAdapter goodsAndClientFragmentAdapter;

    private Right_client_fragment right_client_fragment;
    private Right_goods_fragment right_goods_fragment;

    @Override
    protected void initData() {


    }

    @Override
    protected void initView(View rootView) {
       tiClient = (TabItem) rootView.findViewById(R.id.ti_client);
       //tiGoods =(TabItem) rootView.findViewById(R.id.ti_goods);
       fragmentArrayList = new ArrayList<>();

        right_client_fragment = new Right_client_fragment();
        right_goods_fragment = new Right_goods_fragment();

        fragmentArrayList.add(right_goods_fragment);
        fragmentArrayList.add(right_client_fragment);
        goodsAndClientFragmentAdapter = new GoodsAndClientFragmentAdapter(getChildFragmentManager()
                , fragmentArrayList, getContext());
        tlGoodsClient.setupWithViewPager(vpGoodsClient);

        vpGoodsClient.setAdapter(goodsAndClientFragmentAdapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.cashier_right_fragment;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
    }


}
