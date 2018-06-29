package com.example.niu.myapplication.fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.niu.myapplication.App;
import com.example.niu.myapplication.BaseFragment;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.activity.ChooseStoreActivity;
import com.example.niu.myapplication.activity.LoginActivity;
import com.example.niu.myapplication.utils.Hint;
import com.example.niu.myapplication.utils.Xutils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindInt;
import butterknife.BindView;

/**
 * Created by NIU on 2018/5/18.
 */

public class ThridFragment extends BaseFragment {

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View rootView) {

    }

public void Sendpay(String auth_code,String order_no,String pay_type){
    String url =App.API_URL+"reta/cashier/do-pay";
    Map<String,String> stringMap = new HashMap<>();
            stringMap.put("pay_type", pay_type);
    stringMap.put("order_no","order_no");
    stringMap.put("auth_code", auth_code);

    Xutils.getInstance().get(url, stringMap, new Xutils.XCallBack() {
        @Override
        public void onResponse(String str) {
            try {
                JSONObject mjsonObjects = new JSONObject(str);
                String result = mjsonObjects.getString("status");
                String message = mjsonObjects.getString("message");
                if (result.equals("true")) {
                    JSONObject mjsonObject =mjsonObjects.getJSONObject("data");
                    String username =mjsonObject.getString("username");
                    String mobile =mjsonObject.getString("mobile");
                    String cookie_auth =mjsonObject.getString("cookie_auth");
                    String organization_name =mjsonObject.getString("organization_name");
                    String organization_id =mjsonObject.getString("organization_id");
                    App.store.put("cookie_auth",cookie_auth);
                    App.store.put("mobile",mobile);
                    App.store.put("username",username);
                    App.store.put("organization_name",organization_name);
                    App.store.put("organization_id",organization_id);
                    App.store.commit();
                    startActivity(new Intent(getActivity(),ChooseStoreActivity.class));
                }else {
                    Hint.Short(getActivity(),message);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    });

}


    @Override
    protected int getLayout() {
        return R.layout.pay_third;
    }

}
