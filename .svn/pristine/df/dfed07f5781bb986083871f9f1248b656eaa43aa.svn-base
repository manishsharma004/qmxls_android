package com.example.niu.myapplication.activity;

import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbConstants;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.niu.myapplication.BaseFragment;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.bean.goodsBean;
import com.example.niu.myapplication.fragment.left.LeftFragmentType;
import com.example.niu.myapplication.fragment.left.Left_crashier_fragment;
import com.example.niu.myapplication.fragment.left.Left_setting_fragment;
import com.example.niu.myapplication.fragment.right.ChangeGoodsCountFragment;
import com.example.niu.myapplication.fragment.right.ClientInfoFragment;
import com.example.niu.myapplication.fragment.right.MessageEvent;
import com.example.niu.myapplication.fragment.right.PayFragment;
import com.example.niu.myapplication.fragment.right.RightFragmentType;
import com.example.niu.myapplication.fragment.right.Right_crashier_fragment;
import com.example.niu.myapplication.fragment.right.SettingPayViewFragment;
import com.example.niu.myapplication.fragment.right.SettingSystemViewFragment;
import com.example.niu.myapplication.fragment.right.UnSelectFragment;
import com.example.niu.myapplication.ui.BaseActivity;
import com.example.niu.myapplication.utils.ScanGun;
import com.example.niu.myapplication.utils.ToastUtils;


import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import me.weyye.hipermission.HiPermission;
import me.weyye.hipermission.PermissionCallback;

import static android.support.v4.widget.DrawerLayout.LOCK_MODE_LOCKED_OPEN;
import static android.support.v4.widget.DrawerLayout.LOCK_MODE_UNLOCKED;

public class MainActivity extends BaseActivity implements View.OnClickListener, UsbDetachedReceiver.UsbDetachedListener{

    private static final String TAG = "MainActivity";
    @BindView(R.id.fl_left_container)
    FrameLayout LeftFramContainer;
    @BindView(R.id.dl_main)
    DrawerLayout drawerLayout;
    @BindView(R.id.right_container)
    FrameLayout rightFragmentContainer;
    @BindView(R.id.ll_main)
    LinearLayout ll_main;
//    @BindView(R.id.ll_main)
//    EditText mMessage;
    private ScanGun mScanGun = null;
    public FragmentManager fragmentManager;
    public  BaseFragment payFragment;
    public  BaseFragment right_crashier_fragment;
    public  BaseFragment left_crashiner_fragment;
    public  BaseFragment left_setting_fragment;
    public  BaseFragment settingSystemViewFragment;
    public  BaseFragment changeGoodsCountFragment;
    public  BaseFragment unSelectGoodsFragment;
    public  BaseFragment settingPayViewFragment;

    public  BaseFragment clientInfoFragment;

    @Override
    protected void initData() {

        // 设置key事件最大间隔，默认20ms，部分低端扫码枪效率低
        ScanGun.setMaxKeysInterval(50);
        mScanGun = new ScanGun(new ScanGun.ScanGunCallBack() {
            @Override
            public void onScanFinish(String scanResult) {
                ToastUtils.showShortToast(scanResult);
                Log.d(TAG, "onScanFinish: scanResult= "+scanResult);
//                Toast.makeText(MainActivity.this, "数据： "+scanResult, Toast.LENGTH_SHORT).show();
                MessageEvent messageEvent = new MessageEvent("ThridFragmentPay");
                messageEvent.setAuthCode(scanResult);
                //messageEvent.setAuthCode("6914068019529");

                String values = scanResult.substring(0,2);
                if (((values.contains("10")
                        ||values.contains("28")
                //18 91 62 51
                        ||values.contains("11")
                        ||values.contains("12")
                        ||values.contains("13")
                        ||values.contains("14")
                        ||values.contains("15")
                        ||values.contains("18")
                        ||values.contains("91")
                        ||values.contains("51")
                        ||values.contains("62"))
                        &&(scanResult.length()==18))){


                } if (values.equals("62")&&scanResult.length()==19){



                }



                EventBus.getDefault().post(messageEvent);

            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        mScanGun.isMaybeScanning(keyCode, event);
        return super.onKeyDown(keyCode,event);
    }
    public Fragment getVisibleFragment(){
        FragmentManager fragmentManager = MainActivity.this.getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        for(Fragment fragment : fragments){
            if(fragment != null && fragment.isVisible())
                return fragment;
        }
        return null;
    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        // 拦截物理键盘事件
        if (event.getKeyCode() > 6) {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                if(event.getKeyCode()==KeyEvent.KEYCODE_DEL){//将键盘的删除键传递下去
                    return super.dispatchKeyEvent(event);
                }
                this.onKeyDown(event.getKeyCode(), event);
            }
        }else{
            if(event.getKeyCode()==KeyEvent.KEYCODE_BACK){//将键盘的返回事件传递下去
                return super.dispatchKeyEvent(event);
            }
        }
        return true;
    }



    @Override
    public void onClick(View v) {
//        final String mMessageContent = mMessage.getText().toString();
//        if (!TextUtils.isEmpty(mMessageContent)) {
//            mThreadPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        mFileOutputStream.write(mMessageContent.getBytes());
//                        mHandler.sendEmptyMessage(SEND_MESSAGE_SUCCESS);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
    }

    @Override
    public void usbDetached() {
        finish();
    }




    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    @Override
    protected void initView(View rootView) {

        /*fragmentManager = getSupportFragmentManager();
        settingSystemViewFragment = new SettingSystemViewFragment();
        left_setting_fragment = new Left_setting_fragment();
        //添加左右边fragment
        left_crashiner_fragment = new Left_crashier_fragment();
        right_crashier_fragment = new Right_crashier_fragment();
        payFragment = new PayFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_left_container, left_crashiner_fragment)
                .add(R.id.right_container, right_crashier_fragment)
                .commit();*/


        /*DrawerLayout.SimpleDrawerListener simpleDrawerListener = new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerOpened(View drawerView) {

                Log.d("TAG", "onDrawerOpened: clickable= ");
                drawerView.setClickable(true);
            }
        };
        drawerLayout.addDrawerListener(simpleDrawerListener);
*/

//        fragmentManager = getSupportFragmentManager();


        Log.d(TAG, " before initView: "+(getSupportFragmentManager().beginTransaction().isEmpty())

        +"   "+getSupportFragmentManager().getBackStackEntryCount());
        fragmentManager = getSupportFragmentManager();
        addAllLeftFragent(fragmentManager.beginTransaction());
        addAllRightFragent(fragmentManager.beginTransaction());



        showLeftFragment(LeftFragmentType.LEFT_CRASHIER);
        showRightFragment(RightFragmentType.RIGHT_CRASHIER);
//        getVisibleFragment();

    }
       @Override
    protected int setLayoutId() {
        return R.layout.cashier_activity;
    }

    public void showPayFragment() {

        showRightFragment(RightFragmentType.PAY);

    }


    public void openSlideMenu() {

        drawerLayout.openDrawer(Gravity.START);
        //drawerLayout.setDrawerLockMode(LOCK_MODE_LOCKED_OPEN);

        // WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        //layoutParams.alpha = 1f;
        //drawerLayout.setScrimColor(0x00ffffff);
        //drawerLayout.setAlpha(1f);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void showSettingLayout() {
        /*ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams)
                ll_main.getLayoutParams();
        drawerLayout.setScrimColor(0x00ffffff);
        layoutParams.setMarginStart(200);
        drawerLayout.setDrawerLockMode(LOCK_MODE_LOCKED_OPEN);
        ll_main.setLayoutParams(layoutParams);*/


        //.setVisibility(View.GONE);
        //动态算出侧滑菜单大小，设置给linearlayout margin
        //动态设置左右两侧的权重
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams)
                ll_main.getLayoutParams();
        drawerLayout.setScrimColor(0x00ffffff);
        int slideWidth = drawerLayout.getChildAt(1).getMeasuredWidth();

        Log.d("TAG", "showSettingLayout: width = "+slideWidth);
        layoutParams.setMarginStart(slideWidth);
        ll_main.setLayoutParams(layoutParams);
        drawerLayout.setDrawerLockMode(LOCK_MODE_LOCKED_OPEN);
        drawerLayout.setClickable(true);
        //drawerLayout.closeDrawers();
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.
                LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT
        ,1f);


        LeftFramContainer.setLayoutParams(layoutParams1);
  //180 1592 18 160 6:53 1:9



       /* LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT
                ,3f);
        LeftFramContainer.setLayoutParams(layoutParams2);*/
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT
                ,9f);
        rightFragmentContainer.setLayoutParams(layoutParams3);


        //LinearLayout.LayoutParams layoutParams1 =

        /*getSupportFragmentManager().beginTransaction()
                .hide(left_crashiner_fragment)
                .hide(right_crashier_fragment)
                .add(R.id.fl_left_container, left_setting_fragment)
                .add(R.id.right_container, settingSystemViewFragment)
                .commit();*/

        showLeftFragment(LeftFragmentType.LEFT_SETTING);
        showRightFragment(RightFragmentType.SETTING_SYSTEM_VIEW);

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, " finish initView: "+(getSupportFragmentManager().beginTransaction().isEmpty())

                +"   "+getSupportFragmentManager().getBackStackEntryCount());
    }


    public void addAllLeftFragent(FragmentTransaction fragmentTransaction) {

        if (left_setting_fragment == null) {

            Log.d(TAG, "addAllLeftFragent: left_setting_fragment == null");
            left_setting_fragment = new Left_setting_fragment();
        }

        if (getFragmentManager().findFragmentByTag(Left_setting_fragment.class.getName())==null){

            Log.d(TAG, "addAllLeftFragent: findFragmentByTag==null");

            fragmentTransaction.add(R.id.fl_left_container, 
                    left_setting_fragment,Left_setting_fragment.class.getName());


        }




        if (left_crashiner_fragment == null) {

            left_crashiner_fragment = new Left_crashier_fragment();
            fragmentTransaction.add(R.id.fl_left_container, left_crashiner_fragment);
        }

        fragmentTransaction.commit();

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        Log.d(TAG, "onSaveInstanceState: ");
    }

    public void addAllRightFragent(FragmentTransaction fragmentTransaction) {

        //FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        if (right_crashier_fragment == null) {
            right_crashier_fragment = new Right_crashier_fragment();
            fragmentTransaction.add(R.id.right_container, right_crashier_fragment)
            // .addToBackStack(null)
            ;

        }

        if (unSelectGoodsFragment == null) {


            unSelectGoodsFragment = new UnSelectFragment();

            fragmentTransaction.add(R.id.right_container, unSelectGoodsFragment);

        }
        if (settingSystemViewFragment == null) {

            settingSystemViewFragment = new SettingSystemViewFragment();
            fragmentTransaction.add(R.id.right_container, settingSystemViewFragment);


        }

        if (payFragment == null) {
            payFragment = new PayFragment();
            fragmentTransaction.add(R.id.right_container, payFragment)
            //.addToBackStack(null)
            ;


        }
        if (changeGoodsCountFragment == null) {

            changeGoodsCountFragment = new ChangeGoodsCountFragment();
            fragmentTransaction.add(R.id.right_container, changeGoodsCountFragment);

        }
        if (clientInfoFragment == null) {

            clientInfoFragment = new ClientInfoFragment();
            fragmentTransaction.add(R.id.right_container, clientInfoFragment);

        }

        if (settingPayViewFragment==null){

            settingPayViewFragment = new SettingPayViewFragment();

            fragmentTransaction.add(R.id.right_container, settingPayViewFragment);


        }
        fragmentTransaction.commit();
    }

    public void showLeftFragment(LeftFragmentType type) {


        Log.d(TAG, "showLeftFragment: ");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        hideLeftFragment(fragmentTransaction);

        switch (type) {


            case LEFT_SETTING:
                fragmentTransaction.show(left_setting_fragment)
                        .commit()
                ;

                break;
            case LEFT_CRASHIER:
                Log.d(TAG, "showLeftFragment: LEFT_CRASHIER");
                fragmentTransaction.show(left_crashiner_fragment)
                        .commit()
                ;
                break;
        }



    }

    public void showRightFragment(RightFragmentType type) {


        Log.d(TAG, "showRightFragment: ");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        hideRightFragment(fragmentTransaction);
        switch (type) {

            case UNSELECTGOODS:
                fragmentTransaction.show(unSelectGoodsFragment);

                break;

            case PAY:
                fragmentTransaction.show(payFragment);

                break;

            case RIGHT_CRASHIER:

                fragmentTransaction.show(right_crashier_fragment);
                break;

            case SETTING_PAY_VIEW:
                fragmentTransaction.show(settingPayViewFragment);
                break;

            case SETTING_SYSTEM_VIEW:

                fragmentTransaction.show(settingSystemViewFragment);
                break;

            case CHANGE_GOODS_COUNT:

                fragmentTransaction.show(changeGoodsCountFragment);

                break;

            case CLIENTINFO:
                fragmentTransaction.show(clientInfoFragment);



        }
        fragmentTransaction.commit();

    }

    public void hideLeftFragment(FragmentTransaction fragmentTransaction) {


        if (left_crashiner_fragment != null) {

            fragmentTransaction.hide(left_crashiner_fragment);
        }
        if (left_setting_fragment != null) {

            fragmentTransaction.hide(left_setting_fragment);

        }

    }

    public void hideRightFragment(FragmentTransaction fragmentTransaction) {

        if (right_crashier_fragment != null) {

            fragmentTransaction.hide(right_crashier_fragment);
        }
        if (settingSystemViewFragment != null) {

            fragmentTransaction.hide(settingSystemViewFragment);
        }

        if (settingPayViewFragment != null) {

            fragmentTransaction.hide(settingPayViewFragment);

        }
        if (payFragment != null) {

            fragmentTransaction.hide(payFragment);

        }
        if (changeGoodsCountFragment != null) {

            fragmentTransaction.hide(changeGoodsCountFragment);

        }
        if (unSelectGoodsFragment != null) {

            fragmentTransaction.hide(unSelectGoodsFragment);
        }

        if (clientInfoFragment != null) {

            fragmentTransaction.hide(clientInfoFragment);

        }
        if (settingPayViewFragment != null) {

            fragmentTransaction.hide(settingPayViewFragment);

        }
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void showCrashierLayout() {



        drawerLayout.setDrawerLockMode(LOCK_MODE_LOCKED_OPEN);
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.
                LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT
                ,1f);

        LeftFramContainer.setLayoutParams(layoutParams1);

        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.
                LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT
                ,2f);
        rightFragmentContainer.setLayoutParams(layoutParams3);
        showLeftFragment(LeftFragmentType.LEFT_CRASHIER);
        showRightFragment(RightFragmentType.RIGHT_CRASHIER);
        drawerLayout.closeDrawers();
        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) ll_main.getLayoutParams();
        drawerLayout.setScrimColor(0x99000000);
        layoutParams.setMarginStart(0);
        drawerLayout.setDrawerLockMode(LOCK_MODE_UNLOCKED);
        ll_main.setLayoutParams(layoutParams);

    }


    public void onGoodsSelected(goodsBean goodsBean) {

        ((Left_crashier_fragment) left_crashiner_fragment).updateSelectedGoods(goodsBean);


    }


    public void showChangeGoodsFragment() {


        boolean isShow = ((ChangeGoodsCountFragment) changeGoodsCountFragment).isShow();
        Log.d("TAG", "showChangeGoodsFragment: isShow= " + isShow + "" +
                " second = " + ((ChangeGoodsCountFragment) changeGoodsCountFragment).getUserVisibleHint());

//        (ChangeGoodsCountFragment)changeGoodsCountFragment.mU

        //配合ChangeGoodsCountFragment中onHiddenChanged 避免连续点击结账清单中右侧数量会发生变化
        if (!isShow) {

            showRightFragment(RightFragmentType.CHANGE_GOODS_COUNT);

        } else {

                    /*Toast.makeText(this,"请先完成当前操作",Toast.LENGTH_SHORT)
                            .show();*/
            ToastUtils.showShortToast("请先完成当前操作");
        }


    }

    public void showRightCrashierLayout() {

        showRightFragment(RightFragmentType.RIGHT_CRASHIER);

    }

    public  boolean isLeftFragmentShow(LeftFragmentType type) {

        boolean status = false;
        switch (type) {

            case LEFT_SETTING:

                break;

            case LEFT_CRASHIER:

               if (left_crashiner_fragment!=null) {

                   status = left_crashiner_fragment.isShow();
               }

               break;
        }


        return status;

    }


    public  boolean isRightFragmentShow(RightFragmentType type) {

        boolean status = false;
        switch (type) {


            case CHANGE_GOODS_COUNT:

                if (changeGoodsCountFragment!=null){

                    status = changeGoodsCountFragment.isShow();
                }
                break;
            case UNSELECTGOODS:
                if (unSelectGoodsFragment!=null){
                status = unSelectGoodsFragment.isShow();}
                break;

            case PAY:
                if (payFragment!=null){

                    status = payFragment.isShow();
                }
                break;

        }


        return status;
    }


    public void showUnselectGoodsLayout() {

        showRightFragment(RightFragmentType.UNSELECTGOODS);

    }

    public void showClientInfoLayout() {

        //  showRightFragment(RightFragmentType.CLIENTINFO);
    }

    public void showSettingSystemViewLayout(){

        showRightFragment(RightFragmentType.SETTING_SYSTEM_VIEW);

    }

    public void showSettingPayViewLayout(){

        showRightFragment(RightFragmentType.SETTING_PAY_VIEW);

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause: ");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }
    

    @Override
    protected void onDestroy() {
        super.onDestroy();



        Log.d(TAG, "onDestroy: ");
    }
}
