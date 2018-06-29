package com.example.niu.myapplication.fragment.right;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.niu.myapplication.BaseFragment;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.activity.MainActivity;
import com.example.niu.myapplication.utils.AidlUtil;
import com.example.niu.myapplication.utils.DecimalFormatUtils;
import com.example.niu.myapplication.utils.ESCUtil;
import com.example.niu.myapplication.utils.Hint;
import com.example.niu.myapplication.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.support.constraint.Constraints.TAG;
import static android.view.View.getDefaultSize;

/**
 * 现金收款
 * Created by NIU on 2018/5/18.
 */

public class CrashFragment extends BaseFragment {
    @BindView(R.id.tv_actual_money)
    TextView tvActualMoney;
    @BindView(R.id.tv_client_pay)
    TextView tvClientPay;
    @BindView(R.id.tv_charge)
    TextView tvCharge;
    @BindView(R.id.tv_key_1)
    TextView tvKey1;
    @BindView(R.id.tv_key_4)
    TextView tvKey4;
    @BindView(R.id.tv_key_7)
    TextView tvKey7;
    @BindView(R.id.tv_key_00)
    TextView tvKey00;
    @BindView(R.id.tv_key_2)
    TextView tvKey2;
    @BindView(R.id.tv_key_5)
    TextView tvKey5;
    @BindView(R.id.tv_key_8)
    TextView tvKey8;
    @BindView(R.id.tv_key_0)
    TextView tvKey0;
    @BindView(R.id.tv_key_3)
    TextView tvKey3;
    @BindView(R.id.tv_key_6)
    TextView tvKey6;
    @BindView(R.id.tv_key_9)
    TextView tvKey9;
    @BindView(R.id.tv_key_point)
    TextView tvKeyPoint;
    @BindView(R.id.tv_key_clear)
    TextView tvKeyClear;
    @BindView(R.id.tv_key_del)
    TextView tvKeyDel;
    @BindView(R.id.tv_key_sure)
    TextView tvKeySure;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    Unbinder unbinder;

    //用户给的金额
    StringBuilder inputContent;

    //找零

    double charge = 0.00;
    private double goodsPrice;

    @Override
    protected void initData() {

        inputContent = new StringBuilder();
        Log.d(TAG, "initData: 111 " + (inputContent == null) + "  111" + inputContent.toString());
    }

    @Override
    protected void initView(View rootView) {

        if (tvActualMoney != null) {
            //所有金额相关的都应该处理保留小数点后两位
            tvActualMoney.setText(DecimalFormatUtils.doubleToMoneyWithOutSymbol(goodsPrice));
        }
        Log.d(TAG, "initView: totalPrice= " + goodsPrice);
    }

    @Override
    protected int getLayout() {
        return R.layout.pay_crash;
    }


    @OnClick({R.id.tv_actual_money, R.id.tv_client_pay, R.id.tv_charge, R.id.tv_key_1, R.id.tv_key_4, R.id.tv_key_7, R.id.tv_key_00, R.id.tv_key_2, R.id.tv_key_5, R.id.tv_key_8, R.id.tv_key_0, R.id.tv_key_3, R.id.tv_key_6, R.id.tv_key_9, R.id.tv_key_point, R.id.tv_key_clear, R.id.tv_key_del, R.id.tv_key_sure, R.id.tv_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_actual_money:
                break;
            case R.id.tv_client_pay:
                break;
            case R.id.tv_charge:
                break;
            case R.id.tv_key_1:
            case R.id.tv_key_4:
            case R.id.tv_key_7:
            case R.id.tv_key_2:
            case R.id.tv_key_5:
            case R.id.tv_key_8:
            case R.id.tv_key_3:
            case R.id.tv_key_6:
            case R.id.tv_key_9:
                TextView tempTv = (TextView) rootView.findViewById(view.getId());
                if (!isIndexOfMaxRequest(inputContent.toString())) {
                    inputContent.append(tempTv.getText().toString());
                }

                break;
            case R.id.tv_key_00:
            case R.id.tv_key_0:
            case R.id.tv_key_point:
                if (inputContent.toString().length() == 0) {
                    //Toast.makeText(activity,"请输入正确的金额",Toast.LENGTH_SHORT).show();
                    ToastUtils.showShortToast("请输入正确的金额");
                } else {

                    if (!isIndexOfMaxRequest(inputContent.toString())) {
                        TextView tempView = (TextView) rootView.findViewById(view.getId());
                        inputContent.append(tempView.getText().toString());

                    }


                }
                break;

            case R.id.tv_key_clear:

                inputContent = new StringBuilder();
                break;
            case R.id.tv_key_del:

                if (inputContent.length() > 0) {
                    inputContent.delete(inputContent.length() - 1, inputContent.length());
                }
                break;
            case R.id.tv_key_sure:
               if(Double.parseDouble(tvClientPay.getText().toString())>=Double.parseDouble(tvActualMoney.getText().toString()))
               {
                   MessageEvent  messageEvent = new MessageEvent("XianjingPay");
                   messageEvent.setShifu_pay(tvClientPay.getText().toString());
                   messageEvent.setZhaoling_pay(tvCharge.getText().toString());
                   EventBus.getDefault().post(messageEvent);
                   ((MainActivity)activity).showRightCrashierLayout();
                   MessageEvent  messageEvent1 = new MessageEvent("allDelete");
                   EventBus.getDefault().post(messageEvent1);
                   ((MainActivity)activity).showRightCrashierLayout();
                   tvClientPay.setText("0");
                   tvCharge.setText("0.00");
               }else {
                   Hint.Short(getActivity(),"实收金额大于应收金额！");
               }

                break;
            case R.id.tv_cancel:

                ((MainActivity) activity).showRightCrashierLayout();
                //设置左侧整单取消与收款可点击
                EventBus.getDefault().post(new MessageEvent("cancelCollection"));

                break;
        }
        if (inputContent != null) {
            if (inputContent.length() == 0) {

                tvClientPay.setText("0.00");
            } else {

                tvClientPay.setText(inputContent);
            }
        }

        if (inputContent.length() > 0) {

            double money = Double.parseDouble(String.valueOf(inputContent));

            charge = money - goodsPrice;
            tvCharge.setText(DecimalFormatUtils.doubleToMoneyWithOutSymbol(charge));
            if (charge <= 0) {

                tvCharge.setText("0.00");
            }

        } else {
            charge = 0.00;
            tvCharge.setText("0.00");
        }

        //tvCharge.setText(DecimalFormatUtils.doubleToMoneyWithOutSymbol(charge)+"");


    }


    /***
     *
     *
     * @Function 判断小数点后是否超过两位
     */
    private boolean isIndexOfMaxRequest(String content) {


        if (content == null || content.length() == 0) {

            return false;
        }

        int maxLength = content.length();
        int pointIndex = content.indexOf(".");
        if (pointIndex == -1) {

            return false;
        } else {

            if (maxLength - pointIndex <= 2) {
                return false;

            } else {

                return true;
            }

        }


    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {

            clearAllText();
        } else {
            Log.d(TAG, "onHiddenChanged: price= " + goodsPrice);


        }


    }

    private void clearAllText() {

        if (tvActualMoney != null) {

            tvActualMoney.setText("");
            tvCharge.setText("");
            tvClientPay.setText("");

            inputContent = new StringBuilder();
        }


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();


        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventsticky(MessageEvent messageEvent) {
        Log.d(TAG, "onEvent: pay= " + messageEvent.getTotalMoney() + " type= " +
                messageEvent.getType());


        if (messageEvent.getType().equals("pay")) {
            Log.d(TAG, "onEvent: pay= " + messageEvent.getTotalMoney());
            double money = messageEvent.getTotalMoney();
            Log.d(TAG, "onEvent: mo");
            goodsPrice = money;
            //  tvActualMoney.setText(money);


        }

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent messageEvent) {
        Log.d(TAG, "onEvent: pay= " + messageEvent.getTotalMoney() + " type= " +
                messageEvent.getType());


        if (messageEvent.getType().equals("pay")) {
            Log.d(TAG, "onEvent: pay= " + messageEvent.getTotalMoney());
            double money = messageEvent.getTotalMoney();
            Log.d(TAG, "onEvent: mo");
            goodsPrice = money;
            //  tvActualMoney.setText(money);

            if (tvActualMoney != null) {

                tvActualMoney.setText(DecimalFormatUtils.doubleToMoneyWithOutSymbol(goodsPrice));
            }


        }

    }
}
