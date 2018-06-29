package com.example.niu.myapplication.ui.popwindow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.niu.myapplication.App;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.activity.MainActivity;
import com.example.niu.myapplication.activity.SettingActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by wanglei on 18-5-19.
 */

public final class SlideMenuPopupWindow {

    private static PopupWindow popupWindow;

    private static Context context;
    private static View alphaView;
    private static View popupView;
    private static Activity activity;
    private static TextView tvItem1;
    private static TextView tvItem2;
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void show(Context context,View baseView, int viewId){
        alphaView = LayoutInflater.from(context)
                .inflate(R.layout.alpha_background_view,null);
        setBackGroundAlpha();

           //popupWindow = createPopWindow(context,viewId);
        popupView = LayoutInflater.from(context)
                .inflate(viewId,null);
       /* tvItem1 = (TextView) popupView.findViewById(R.id.tv_item1);
        tvItem2 = (TextView) popupView.findViewById(R.id.tv_item2);*/
        initEvent();
        popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT
                , ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        popupWindow.setWindowLayoutType(WindowManager.LayoutParams.TYPE_TOAST);
        popupWindow.showAtLocation(baseView, Gravity.LEFT,0,0);

        Log.d(TAG, "show: ");

        //LinearLayout linearLayout = new LinearLayout(activity);

    }


    public static void disimiss(){

        if (popupWindow.isShowing()){


            popupWindow.dismiss();
        }

    }
    private static void initEvent() {


      /*  if (tvItem1 != null) {

            tvItem1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    App.getBaseApplication().startActivity(new Intent(context, MainActivity.class));
                }
            });

        }

        if (tvItem2 != null) {

            tvItem2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, SettingActivity.class));
                }
            });
        }*/

    }
    public static void setOnDismissListener(PopupWindow.OnDismissListener dismissListener){

        popupWindow.setOnDismissListener(dismissListener);

    }

    public static void setOnItem1Click(View.OnClickListener onItemClick){
        tvItem1.setOnClickListener(onItemClick);


    }
    public static void setOnItem2Click(View.OnClickListener onItemClick){
        tvItem2.setOnClickListener(onItemClick);


    }
    private static void setBackGroundAlpha() {

/*
        ViewGroup viewGroup = activity.getWindow().getDecorView()
                .findViewById(android.R.id.content);

        viewGroup.addView(alphaView);*/


    }

    private static PopupWindow createPopWindow(Context context,int viewId) {

       // popupWindow = createPopWindow(viewId);
        popupView = LayoutInflater.from(context)
                .inflate(viewId,null);
        popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT
        , ViewGroup.LayoutParams.MATCH_PARENT);
        return popupWindow;
    }


}
