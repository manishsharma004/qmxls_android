package com.example.niu.myapplication.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.niu.myapplication.App;

/**
 * Created by wanglei on 18-5-22.
 */

public class ToastUtils {

    private static final String TAG = "ToastUtils";
    public static Context mContext;
    public static Toast mToast;

    public static void init(Context context){

        mContext = context;
    }

    public static void showLongToast(String text){

         // Log.d(TAG, "showToast: mContext==null "+(mContext==null));
        if (mContext!=null){

            if (mToast==null){
                mToast = Toast.makeText(mContext,text,Toast.LENGTH_LONG);

            }else{
                mToast.setText(text);
                mToast.setDuration(Toast.LENGTH_LONG);

            }

            mToast.show();




        }

    }


    public static void showShortToast(String text){

         // Log.d(TAG, "showToast: mContext==null "+(mContext==null));
        if (mContext!=null){

            if (mToast==null){
                mToast = Toast.makeText(mContext,text,Toast.LENGTH_SHORT);

            }else{
                mToast.setText(text);
                mToast.setDuration(Toast.LENGTH_SHORT);

            }

            mToast.show();




        }else{

            mToast = Toast.makeText(App.getBaseApplication(),"hello",Toast.LENGTH_SHORT);
            mToast.show();

        }

    }
    public static void showToast(String text,int duration){

        //  Log.d(TAG, "showToast: mContext==null "+(mContext==null));
        if (mContext!=null){

            if (mToast==null){
                mToast = Toast.makeText(mContext,text,duration);

            }else{
                mToast.setText(text);
                mToast.setDuration(duration);

            }

            mToast.show();




        }

    }
    public static void showToastWithGravity(String text,int duration,int gravity){

        if (mContext!=null){

            if (mToast==null){
                mToast = Toast.makeText(mContext,text,duration);

            }else{
                mToast.setText(text);

                mToast.setDuration(duration);

            }
            mToast.setGravity(gravity,0,0);
            mToast.show();




        }

    }
}