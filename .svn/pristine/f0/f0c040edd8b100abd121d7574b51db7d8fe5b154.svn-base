package com.example.niu.myapplication.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.StatFs;
import android.text.format.Formatter;

import com.example.niu.myapplication.activity.MainActivity;
import com.example.niu.myapplication.utils.Hint;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2018/6/16.
 */

public class USBBroadCastReceiver extends BroadcastReceiver {
    Context mContext;
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (action.equals(Intent.ACTION_MEDIA_EJECT)) {
            Hint.Short(mContext,"已断开");
            //USB设备移除，更新UI
        } else if (action.equals(Intent.ACTION_MEDIA_MOUNTED)) {
            Hint.Short(mContext,"；已连接");
            //USB设备挂载，更新UI
        }
    }


    //获得挂载的USB设备的存储空间使用情况

    public static String getUSBStorage(Context context){
        // USB Storage

        //storage/udisk为USB设备在Android设备上的挂载路径.不同厂商的Android设备路径不同。

        //这样写同样适合于SD卡挂载。
        File path = new File("/storage/udisk");

        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        long availableBlocks = stat.getAvailableBlocks();
        String usedSize = Formatter.formatFileSize(context, (totalBlocks-availableBlocks) * blockSize);
        String availableSize = Formatter.formatFileSize(context, availableBlocks * blockSize);
        return usedSize + " / " + availableSize;//空间:已使用/可用的
//
//        try {
//
//            //获得外接USB输入设备的信息
//            Process p=Runtime.getRuntime().exec("cat /proc/bus/input/devices");
//            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            String line = null;
//            while((line = in.readLine())!= null){
//                String deviceInfo = line.trim();
//
//                //对获取的每行的设备信息进行过滤，获得自己想要的。
//
//            }
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }

    }
}
