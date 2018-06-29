package com.example.niu.myapplication.fragment.right;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.example.niu.myapplication.App;
import com.example.niu.myapplication.BaseFragment;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.activity.ChooseStoreActivity;
import com.example.niu.myapplication.activity.LoginActivity;
import com.example.niu.myapplication.activity.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by wanglei on 18-5-19.
 */

public class SettingSystemViewFragment extends BaseFragment {
    @BindView(R.id.tv_exit)
    TextView tvExit;
    @BindView(R.id.store_name)
    TextView storeName;
    @BindView(R.id.change_store)
    TextView changeStore;
    Unbinder unbinder;

    @Override
    protected void initData() {

        try {
            String store = App.store.getString("storeinfo");
            if (store!=null){
            storeName.setText(new JSONObject(store).getString("name"));}
            else {
                storeName.setText("企小店");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initView(View rootView) {


    }

    @Override
    protected int getLayout() {
        return R.layout.setting_system_view;
    }


    @OnClick({R.id.tv_exit,R.id.change_store})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_exit:
                App.removeUser();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().startActivity(intent);
                getActivity().finish();
            break;
        case R.id.change_store:
                Intent intent1 = new Intent(getActivity(), ChooseStoreActivity.class);
//                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                 getActivity().startActivity(intent1);
                getActivity().finish();
            break;

        }
    }
}
