package com.example.niu.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.niu.myapplication.App;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.ui.BaseActivity;
import com.example.niu.myapplication.utils.Hint;
import com.example.niu.myapplication.utils.Xutils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ChangePwdActivity extends BaseActivity {
    private TimeCount timeCount;
    @BindView(R.id.et_change_mobile)
    EditText etChangeMobile;
    @BindView(R.id.et_change_yzm)
    EditText etChangeYzm;
    @BindView(R.id.et_change_pwd)
    EditText etChangePwd;
    @BindView(R.id.bt_get_yzm)
    Button btChangeYzm;
    @BindView(R.id.bt_change_pwd)
    Button btChangePwd;
    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unbinder = ButterKnife.bind(this);
    }



    @Override
    protected void initData() {
        timeCount = new TimeCount(60000, 1000,btChangeYzm);
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.change_activity;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.bt_change_pwd,R.id.bt_get_yzm})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.bt_change_pwd:
//                finish();
                if (TextUtils.isEmpty(etChangeMobile.getText().toString())){
                    Hint.Short(ChangePwdActivity.this,"The phone number cannot be empty!");
                    return;
                }
                if (TextUtils.isEmpty(etChangeYzm.getText().toString())){
                Hint.Short(ChangePwdActivity.this,"verification code must be filled!");
                return;
            }
            if (TextUtils.isEmpty(etChangePwd.getText().toString())){
                Hint.Short(ChangePwdActivity.this,"password can not be blank!");
                return;
            }
                sendPwd(etChangeMobile.getText().toString(),etChangePwd.getText().toString(),etChangeYzm.getText().toString());

                break; case R.id.bt_get_yzm:
//                finish();
                if (TextUtils.isEmpty(etChangeMobile.getText().toString())){
                    Hint.Short(ChangePwdActivity.this,"The phone number cannot be empty!");
                    return;
                }
                sendCode();
                break;

    }
}
    public void sendCode(){
        String url = App.API_URL+"seller/account/send-sms";
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("mobile", etChangeMobile.getText().toString());
        Xutils.getInstance().post(url, stringMap, new Xutils.XCallBack() {
            @Override
            public void onResponse(String str) {
//
                try {
                    JSONObject mjsonObjects = new JSONObject(str);
                    String result = mjsonObjects.getString("status");
                    String message = mjsonObjects.getString("message");
                    if (result.equals("true")) {
                        JSONObject mjsonObject =mjsonObjects.getJSONObject("data");
                        Hint.Short(ChangePwdActivity.this,"SMS has been sent, please check");
                        timeCount.start();
//                        Hint.Short(ReisterActivity.this,mjsonObject.getString("expiredAt"));
                    }else {
                        Hint.Short(ChangePwdActivity.this,message);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

        });

    }
    public void sendPwd(String mobile ,String password,String codeValue){
        String url = App.API_URL+"seller/account/reset-password";
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("mobile", mobile);
        stringMap.put("new_password",password);
        stringMap.put("codeValue", codeValue);

        Xutils.getInstance().post(url, stringMap, new Xutils.XCallBack() {
            @Override
            public void onResponse(String str) {
//
                try {
                    JSONObject mjsonObjects = new JSONObject(str);
                    String result = mjsonObjects.getString("status");
                    String message = mjsonObjects.getString("message");
                    if (result.equals("true")) {
                        startActivity(new Intent(ChangePwdActivity.this,LoginActivity.class));
                         finish();
                    }else {
                        Hint.Short(ChangePwdActivity.this,message);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

        });

    }
    /**
     *  点击发送按钮后手机会接收到验证码，倒计时60s
     * @ClassName: TimeCount
     * @date 2017年1月10日
     */
    public class TimeCount extends CountDownTimer {

        private Button btn_count;

        public TimeCount(long millisInFuture, long countDownInterval,Button btn_count) {
            super(millisInFuture, countDownInterval);
            this.btn_count = btn_count;
        }

        @Override
        public void onTick(long millisUntilFinished) {
            btn_count.setEnabled(false);
            btn_count.setText(millisUntilFinished / 1000 + "second");
        }

        @Override
        public void onFinish() {
            btn_count.setEnabled(true);
            btn_count.setText("Resend");

        }

    }

}
