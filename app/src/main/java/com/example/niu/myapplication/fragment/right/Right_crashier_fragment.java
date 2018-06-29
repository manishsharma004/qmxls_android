package com.example.niu.myapplication.fragment.right;

import android.os.Bundle;
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
import com.example.niu.myapplication.fragment.left.Left_crashier_fragment;
import com.example.niu.myapplication.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by NIU on 2018/5/18.
 */

public class Right_crashier_fragment extends BaseFragment implements Left_crashier_fragment.onPendingOrderSucess {

    @BindView(R.id.tv_guadan)
    TextView tvGuadan;
    @BindView(R.id.tv_qudan)
    TextView tvQudan;
    @BindView(R.id.ll_bottom_menu)
    LinearLayout llBottomMenu;

    @BindView(R.id.tl_goods_client)
    TabLayout tlGoodsClient;
    @BindView(R.id.vp_goods_client)
    ViewPager vpGoodsClient;
    Unbinder unbinder;
    @BindView(R.id.tv_qudan_num)
    TextView tvQudanNum;
    Unbinder unbinder1;
    private ArrayList<Fragment> fragmentArrayList;
    private GoodsAndClientFragmentAdapter goodsAndClientFragmentAdapter;

    private Right_client_fragment right_client_fragment;
    private Right_goods_fragment right_goods_fragment;

    private ClientInfoFragment clientInfoFragment;

    private int takeOrderId;

    private boolean isTakeOrder;
    @Override
    protected void initData() {


    }

    @Override
    protected void initView(View rootView) {

        EventBus.getDefault().register(this);

        fragmentArrayList = new ArrayList<>();

        right_client_fragment = new Right_client_fragment();
        right_goods_fragment = new Right_goods_fragment();
        clientInfoFragment = new ClientInfoFragment();
        fragmentArrayList.add(right_goods_fragment);
        fragmentArrayList.add(right_client_fragment);
        goodsAndClientFragmentAdapter = new GoodsAndClientFragmentAdapter
                (getChildFragmentManager()
                        , fragmentArrayList, getContext());
        tlGoodsClient.setupWithViewPager(vpGoodsClient);

        vpGoodsClient.setAdapter(goodsAndClientFragmentAdapter);


    }

    @Override
    protected int getLayout() {

        return R.layout.cashier_right_fragment;
    }


    @OnClick({R.id.tv_guadan, R.id.tv_qudan, R.id.ll_bottom_menu, R.id.tl_goods_client, R.id.vp_goods_client})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_guadan:

                MessageEvent messageEvent = new MessageEvent("pendingOrder");

                EventBus.getDefault().post(messageEvent);


                break;
            case R.id.tv_qudan:
         if (isTakeOrder) {

             MessageEvent messageEvent1 = new MessageEvent("takeOrder");


             messageEvent1.setTypeInt(takeOrderId);


             EventBus.getDefault().post(messageEvent1);



            setQudanNUmVisibity(false);

            isTakeOrder = false;


         }

                break;
            case R.id.ll_bottom_menu:
                break;

            case R.id.tl_goods_client:
                break;
            case R.id.vp_goods_client:
                break;
        }
    }

    private void setQudanNUmVisibity(boolean b) {

    tvQudanNum.setVisibility(b?View.VISIBLE:View.GONE);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);

    }


    @Subscribe(threadMode = ThreadMode.MAIN)

    public void onEvent(MessageEvent messageEvent) {


        if (messageEvent.getType().equals("pendingOrderSucess")) {

            takeOrderId = messageEvent.getTypeInt();
//            ToastUtils.showShortToast("挂单number= "+messageEvent.getTypeInt());
            if (takeOrderId==0){
                setQudanNUmVisibity(true);

                isTakeOrder = true;
        }
        }

    }


    @Override
    public void onPendingOrderSucess(int position) {


        // ToastUtils.showShortToast("挂单number= "+position);
    }


}
