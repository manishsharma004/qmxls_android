package com.example.niu.myapplication.fragment.right;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.niu.myapplication.BaseFragment;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.activity.MainActivity;
import com.example.niu.myapplication.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 其他支付方式
 * Created by NIU on 2018/5/18.
 */

public class PayOtherFragment extends BaseFragment {


    @BindView(R.id.iv_pay_wechat)
    ImageView ivPayWechat;
    @BindView(R.id.iv_pay_zhifubao)
    ImageView ivPayZhifubao;
    @BindView(R.id.iv_pay_pos)
    ImageView ivPayPos;
    Unbinder unbinder;
    @BindView(R.id.tv_sure_tag)
    TextView tvSureTag;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;

    private int selected = 0;
    private static final int TYPE_WECHAT = 1;
    private static final int TYPE_ZHIFUBAO = 2;
    private static final int TYPE_POS = 3;


    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView) {
//        EventBus.getDefault().register(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.pay_other;
    }



    @OnClick({R.id.iv_pay_wechat, R.id.iv_pay_zhifubao, R.id.iv_pay_pos

    ,R.id.tv_sure_tag,R.id.tv_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_pay_wechat:

                ivPayWechat.setImageResource(R.drawable.pay_wechat_checked);
                ivPayZhifubao.setImageResource(R.drawable.pay_zhifubao_uncheck);
                ivPayPos.setImageResource(R.drawable.pay_pos_unchecked);
                selected = TYPE_WECHAT;
                break;
            case R.id.iv_pay_zhifubao:
                ivPayWechat.setImageResource(R.drawable.pay_wechat_uncheck);
                ivPayZhifubao.setImageResource(R.drawable.pay_zhifubao_check);
                ivPayPos.setImageResource(R.drawable.pay_pos_unchecked);
                selected = TYPE_ZHIFUBAO;

                break;
            case R.id.iv_pay_pos:
                ivPayWechat.setImageResource(R.drawable.pay_wechat_uncheck);
                ivPayZhifubao.setImageResource(R.drawable.pay_zhifubao_uncheck);
                ivPayPos.setImageResource(R.drawable.pay_pos_checked);
                selected = TYPE_POS;

                break;


            case R.id.tv_sure_tag:

                if (selected==0){

                    //Toast.makeText(activity,"请先选择一个标记",Toast.LENGTH_SHORT).show();

                    ToastUtils.showShortToast("请先选择一个标记");
                    return;
                }

                //  确认标记....
                MessageEvent  messageEvent = new MessageEvent("BiaojiPay");
                if (selected==1){
                    messageEvent.setIsPay("微信");
                }  if (selected==2){
                    messageEvent.setIsPay("支付宝");
                }  if (selected==3){
                    messageEvent.setIsPay("POS机");
                }
                EventBus.getDefault().postSticky(messageEvent);

                MessageEvent  messageEvent1 = new MessageEvent("allDelete");
                EventBus.getDefault().post(messageEvent1);
                ((MainActivity)activity).showRightCrashierLayout();
                break;
            case R.id.tv_cancel:
                ((MainActivity)activity).showRightCrashierLayout();
                //设置左侧整单取消与收款可点击
                EventBus.getDefault().post(new MessageEvent("cancelCollection"));

                break;

            default:

                break;

        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEvent(MessageEvent messageEvent) {
//
//
//    }
}
