package com.example.niu.myapplication.fragment.right;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.niu.myapplication.BaseFragment;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.activity.MainActivity;
import com.example.niu.myapplication.bean.goodsBean;
import com.example.niu.myapplication.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.support.constraint.Constraints.TAG;

/**
 * Created by wanglei on 18-5-20.
 */

public class ChangeGoodsCountFragment extends BaseFragment {
    @BindView(R.id.tv_change_item_name)
    TextView tvChangeItemName;
    @BindView(R.id.tv_change_item_count)
    TextView tvChangeItemCount;
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
    Unbinder unbinder;
    goodsBean goodsBean;
    @BindView(R.id.tl_choose_count)
    Toolbar tlChooseCount;
    Unbinder unbinder1;
    private boolean isShow = true;
    private StringBuilder inputContent;

    boolean firstChange = false;
    @Override
    protected void initData() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    protected void initView(View rootView) {
        tlChooseCount.setNavigationIcon(R.drawable.ic_action_back);
                ((MainActivity)activity).setSupportActionBar(tlChooseCount);

        inputContent = new StringBuilder();
        EventBus.getDefault().register(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.change_goods_item_fragment;
    }


    @Override
    public void onDestroy() {

        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)

    public void onEvent(MessageEvent event) {

        Log.d("wanglei", "onEvent: ");

        if (event.getType().equals("changeCount")) {


            goodsBean = event.getGoodsBean();

            Log.d(TAG, "onEvent: number= " + (goodsBean == null));

        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){

            case android.R.id.home:
                //Toast.makeText(activity, "111ckick ckkdkfjkd", Toast.LENGTH_SHORT).show();

                ((MainActivity)activity).showRightCrashierLayout();
                //隐藏当前界面

                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);


    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d(TAG, "onResume: ");
    }

    public boolean isShow() {

        return isShow;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        isShow = !hidden;

        if (hidden) {

            if (tvChangeItemName!=null){
                tvChangeItemName.setText("");

            }
            if (tvChangeItemCount!=null){

                tvChangeItemCount.setText("");
                goodsBean = null;
                inputContent = new StringBuilder();
            }

        } else {

            if (goodsBean != null) {
                inputContent = new StringBuilder();
               // inputContent.append(goodsBean.getNumber());
                tvChangeItemName.setText(goodsBean.getGoodsName());
                tvChangeItemCount.setText(goodsBean.getNumber() + "");
            }
        }
        Log.d("wanglei", "onHiddenChanged: hideen1111= " + hidden);
    }

    @OnClick({R.id.tv_key_1, R.id.tv_key_4, R.id.tv_key_7, R.id.tv_key_00, R.id.tv_key_2, R.id.tv_key_5, R.id.tv_key_8, R.id.tv_key_0, R.id.tv_key_3, R.id.tv_key_6, R.id.tv_key_9, R.id.tv_key_clear, R.id.tv_key_del, R.id.tv_key_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_key_1:
            case R.id.tv_key_4:
            case R.id.tv_key_7:

            case R.id.tv_key_2:
            case R.id.tv_key_5:
            case R.id.tv_key_8:

            case R.id.tv_key_3:
            case R.id.tv_key_6:
            case R.id.tv_key_9:

                /*if (firstChange){

                    inputContent = new StringBuilder();
                    firstChange = false;
                }*/
                TextView textView = rootView.findViewById(view.getId());

                Log.d(TAG, "onViewClicked: textview = " + textView.getText().toString());

                inputContent.append(textView.getText().toString());


                break;
            case R.id.tv_key_0:
            case R.id.tv_key_00:


                if (inputContent.toString().equals("")) {

                    return;
                } else {

                    inputContent.append("00");
                }
                break;
            case R.id.tv_key_clear:
                if (!inputContent.equals("") || inputContent.toString().length() != 0) {
                    inputContent.delete(0, inputContent.length());
                }
                break;
            case R.id.tv_key_del:

                if (inputContent.toString().length() > 0) {

                    Log.d(TAG, "onViewClicked: inputContent.toString().length()=" + (inputContent.toString().length()));
                    inputContent.delete(inputContent.length() - 1, inputContent.length());

                }
                break;
            case R.id.tv_key_sure:

                //传数据给左边fragment

                if (inputContent.equals("")) {
                    //ToastUtils.showShortToast("请输入有效数字");
                    MessageEvent messageEvent = new MessageEvent("update");
                    goodsBean.setNumber(Integer.parseInt(tvChangeItemCount.getText().toString()));

                    goodsBean.setChangeType("countChange");
                    messageEvent.setGoodsBean(goodsBean);
                    Log.d(TAG, "onViewClicked: number = " + goodsBean.getNumber());
                    EventBus.getDefault().post(messageEvent);
                    ((MainActivity)activity).showRightCrashierLayout();

                    inputContent = new StringBuilder();

                } else

                    {
                    MessageEvent messageEvent = new MessageEvent("update");
                    if (inputContent.toString()!=null&& !inputContent.toString().equals("")) {
                        goodsBean.setNumber(Integer.parseInt(inputContent.toString()));
                    }

                    goodsBean.setChangeType("countChange");
                    messageEvent.setGoodsBean(goodsBean);
                    Log.d(TAG, "onViewClicked: number = " + goodsBean.getNumber());
                    EventBus.getDefault().post(messageEvent);
                    ((MainActivity)activity).showRightCrashierLayout();

                    inputContent = new StringBuilder();
                }

                break;
        }
        if (inputContent.toString().length() == 0) {
            inputContent = new StringBuilder();

        }
        tvChangeItemCount.setText(inputContent);
        isShow = true;
        firstChange = true;
    }




}
