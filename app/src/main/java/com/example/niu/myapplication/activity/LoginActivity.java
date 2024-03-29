package com.example.niu.myapplication.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.niu.myapplication.App;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.utils.Hint;
import com.example.niu.myapplication.utils.Judge;
import com.example.niu.myapplication.utils.Xutils;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Headers;

//18355
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private ChangePwdActivity.TimeCount timeCount;
    Button bt_login;
    EditText et_login_pwd,et_login_mobile;
    String Mobile="";
    String Pwd="";
    TextView tv_login_go_register,tv_login_forget_pwd;
    public Handler handler = new Handler();
    ZLoadingDialog dialog = new ZLoadingDialog(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.login_activity);
        bt_login= (Button) findViewById(R.id.bt_login);

        tv_login_go_register= (TextView) findViewById(R.id.tv_login_go_register);
        tv_login_forget_pwd= (TextView) findViewById(R.id.tv_login_forget_pwd);

        et_login_pwd= (EditText) findViewById(R.id.et_login_pwd);
        et_login_mobile= (EditText) findViewById(R.id.et_login_mobile);
        et_login_mobile.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(i==keyEvent.KEYCODE_ENTER && keyEvent.getAction()==KeyEvent.ACTION_DOWN && keyEvent.getCharacters()!=null){
                    et_login_mobile.setText(keyEvent.getCharacters());
                    return true;
                }
                return false;

            } });

        bt_login.setOnClickListener(this);
        tv_login_go_register.setOnClickListener(this);
        tv_login_forget_pwd.setOnClickListener(this);

//        mobile
//                userpwd

        if (App.store.getString("mobile")!=null){
            et_login_mobile.setText(App.store.getString("mobile"));
            et_login_pwd.setText(App.store.getString("userpwd"));
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.bt_login){
            Pwd = et_login_pwd.getText().toString();
            Mobile = et_login_mobile.getText().toString();
            if (!Judge.isMobile(Mobile)){
                Hint.Short(this,"请输入正确的手机号！");
             return;
            }
            dialog.setLoadingBuilder(Z_TYPE.STAR_LOADING)//设置类型
                    .setLoadingColor(Color.BLACK)//颜色
                    .setHintText("Loading...")
                    .show();
            new Thread(new Runnable(){
                @Override
                public void run() {
                    sendlogin();
                }
            }).start();
        }
        if (v.getId()==R.id.tv_login_go_register){
            startActivity(new Intent(LoginActivity.this,ReisterActivity.class));
        } if (v.getId()==R.id.tv_login_forget_pwd){
            startActivity(new Intent(LoginActivity.this,ChangePwdActivity.class));

//            AidlUtil.getInstance().putString("欢迎使用企迈云商！");
    }
    }

public void sendlogin(){
    String url = App.API_URL+"seller/account/login";
    Map<String,String> stringMap = new HashMap<>();
    stringMap.put("mobile", Mobile);
    stringMap.put("password",Pwd);
    stringMap.put("inviteCode", "");

    Xutils.getInstance().Loginpost(url, stringMap, new Xutils.XCallBack() {
        @Override
        public void onResponse(String str) {
//            final String str = result.body().string();
            dialog.cancel();
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

                    App.store.remove("cookie_auth").clear().commit();
//                   App.store("gesture")
                    App.store.put("cookie_auth",cookie_auth);
                    App.store.put("mobile",mobile);
                    App.store.put("userpwd",Pwd);
                    App.store.put("username",username);
                    App.store.put("organization_name",organization_name);
                    App.store.put("organization_id",organization_id);
                    App.store.commit();
                    startActivity(new Intent(LoginActivity.this,ChooseStoreActivity.class));

                    //登录成功finish当前页面
                    finish();

                }else {
                    Hint.Short(LoginActivity.this,message);
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
     * 设置请求头
     * @param headersParams
     * @return
     */
    private Headers SetHeaders(Map<String, String> headersParams){
        Headers headers=null;
        okhttp3.Headers.Builder headersbuilder=new okhttp3.Headers.Builder();

        if(headersParams != null)
        {
            Iterator<String> iterator = headersParams.keySet().iterator();
            String key = "";
            while (iterator.hasNext()) {
                key = iterator.next().toString();
                headersbuilder.add(key, headersParams.get(key));
                Log.d("get http", "get_headers==="+key+"===="+headersParams.get(key));
            }
        }
        headers=headersbuilder.build();

        return headers;
    }
}
