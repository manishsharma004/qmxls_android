package com.example.niu.myapplication.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.niu.myapplication.BaseFragment;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.utils.Hint;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by NIU on 2018/5/18.
 */

public class Right_goods_fragment extends BaseFragment {

    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.rl_search_item1)
    RelativeLayout rlSearchItem1;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.et_goods_search)
    EditText etGoodsSearch;
    @BindView(R.id.rl_search_item2)
    RelativeLayout rlSearchItem2;
    @BindView(R.id.rv_goods)
    RecyclerView rvGoods;
    @BindView(R.id.ll_goods_items)
    LinearLayout llGoodsItems;
    @BindView(R.id.ll_empty)
    LinearLayout llEmpty;
    @BindView(R.id.tv_all_goods)
    TextView tvAllGoods;
//    @BindView(R.id.tv_order_one)
//    TextView tvOrderOne;
//    @BindView(R.id.tv_order_two)
//    TextView tvOrderTwo;

    @Override
    protected void initData() {
        etGoodsSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(i==keyEvent.KEYCODE_ENTER && keyEvent.getAction()==KeyEvent.ACTION_DOWN && keyEvent.getCharacters()!=null){
                    etGoodsSearch.setText(keyEvent.getCharacters());
                    Hint.Short(getActivity(),keyEvent.getCharacters());
                    return true;
                }
                return false;

            } });

        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(etGoodsSearch,0);
    }

    @Override
    protected void initView(View rootView) {
        rlSearchItem1 = rootView.findViewById(R.id.rl_search_item1);
        rlSearchItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "item1", Toast.LENGTH_SHORT).show();

            }
        });

        showSoftInputFromWindow(getActivity(),etGoodsSearch);
    }

    @Override
    protected int getLayout() {
        return R.layout.cashier_right_item_goods;
    }




    /**
     * EditText获取焦点并显示软键盘
     */
    public static void showSoftInputFromWindow(Activity activity, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }


    @OnClick({R.id.tv_cancel, R.id.rl_search_item1,  R.id.rl_search_item2, R.id.rv_goods, R.id.ll_goods_items, R.id.ll_empty, R.id.tv_all_goods})
    public void onViewClicked(View view) {
        Toast.makeText(activity, "item1111", Toast.LENGTH_SHORT).show();

        switch (view.getId()) {
            case R.id.tv_cancel:

                etGoodsSearch.setText("");
                rlSearchItem2.setVisibility(View.GONE);
                rlSearchItem1.setVisibility(View.VISIBLE);

                break;
            case R.id.rl_search_item1:

                rlSearchItem1.setVisibility(View.GONE);
                rlSearchItem2.setVisibility(View.VISIBLE);
                break;

//            case R.id.et_goods_search:
//                break;
            case R.id.rl_search_item2:
                break;
            case R.id.rv_goods:
                break;
            case R.id.ll_goods_items:
                break;
            case R.id.ll_empty:
                break;
            case R.id.tv_all_goods:
                break;

        }
    }
}
