package com.example.niu.myapplication.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.view.InputDevice;
import android.view.KeyEvent;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2018/6/16.
 */

public class ScanGunKeyEventHelper {
    //延迟500ms，判断扫码是否完成。
    private final static long MESSAGE_DELAY = 500;
    //扫码内容
    private StringBuffer mStringBufferResult = new StringBuffer();
    //大小写区分
    private boolean mCaps;
    private final BluetoothAdapter mBluetoothAdapter;
    private OnScanSuccessListener mOnScanSuccessListener;
    private Handler mHandler = new Handler();
    private String mDeviceName;


    public ScanGunKeyEventHelper(OnScanSuccessListener onScanSuccessListener) {
        mOnScanSuccessListener = onScanSuccessListener;
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//        mStringBufferResult = new StringBuffer();
//        mHandler = new Handler();
//        mScanningFishedRunnable = new Runnable() {
//            @Override
//            public void run() {
//                performScanSuccess();
//            }
//        };
    }
    private final Runnable mScanningFishedRunnable = new Runnable() {
        @Override
        public void run() {
            performScanSuccess();
        }
    };
    /**
     * 扫描枪是否连接
     *
     * @return
     */
    public boolean hasScanGun() {
        if (mBluetoothAdapter == null) {
            return false;
        }
        Set<BluetoothDevice> blueDevices = mBluetoothAdapter.getBondedDevices();
        if (blueDevices == null || blueDevices.size() <= 0) {
            return false;
        }
        for (Iterator<BluetoothDevice> iterator = blueDevices.iterator(); iterator.hasNext(); ) {
            BluetoothDevice bluetoothDevice = iterator.next();

            if (bluetoothDevice.getBluetoothClass().getMajorDeviceClass() == BluetoothClass.Device.Major.PERIPHERAL) {
                mDeviceName = bluetoothDevice.getName();
                return isInputDeviceExist(mDeviceName);
            }
        }
        return false;
    }

    /**
     * 输入设备是否存在
     *
     * @param deviceName
     * @return
     */
    private boolean isInputDeviceExist(String deviceName) {
        int[] deviceIds = InputDevice.getDeviceIds();

        for (int id : deviceIds) {
            if (InputDevice.getDevice(id).getName().equals(deviceName)) {
                return true;
            }
        }
        return false;
    }

    //返回扫描结果
    private void performScanSuccess() {
        String barcode = mStringBufferResult.toString();
        if (mOnScanSuccessListener != null)
            mOnScanSuccessListener.onScanSuccess(barcode);
        mStringBufferResult.setLength(0);
    }

    //key事件处理
    public void analysisKeyEvent(KeyEvent event) {

        int keyCode = event.getKeyCode();

        //字母大小写判断
        checkLetterStatus(event);

        if (event.getAction() == KeyEvent.ACTION_DOWN) {

            char aChar = getInputCode(event);;

            if (aChar != 0) {
                mStringBufferResult.append(aChar);
            }

            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                //若为回车键，直接返回
                mHandler.removeCallbacks(mScanningFishedRunnable);
                mHandler.post(mScanningFishedRunnable);
            } else {
                //延迟post，若500ms内，有其他事件
                mHandler.removeCallbacks(mScanningFishedRunnable);
                mHandler.postDelayed(mScanningFishedRunnable, MESSAGE_DELAY);
            }

        }
    }

    //检查shift键
    private void checkLetterStatus(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (keyCode == KeyEvent.KEYCODE_SHIFT_RIGHT || keyCode == KeyEvent.KEYCODE_SHIFT_LEFT) {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                //按着shift键，表示大写
                mCaps = true;
            } else {
                //松开shift键，表示小写
                mCaps = false;
            }
        }
    }


    //获取扫描内容
    private char getInputCode(KeyEvent event) {

        int keyCode = event.getKeyCode();

        char aChar;

        if (keyCode >= KeyEvent.KEYCODE_A && keyCode <= KeyEvent.KEYCODE_Z) {
            //字母
            aChar = (char) ((mCaps ? 'A' : 'a') + keyCode - KeyEvent.KEYCODE_A);
        } else if (keyCode >= KeyEvent.KEYCODE_0 && keyCode <= KeyEvent.KEYCODE_9) {
            //数字
            aChar = (char) ('0' + keyCode - KeyEvent.KEYCODE_0);
        } else {
            //其他符号
            switch (keyCode) {
                case KeyEvent.KEYCODE_PERIOD:
                    aChar = '.';
                    break;
                case KeyEvent.KEYCODE_MINUS:
                    aChar = mCaps ? '_' : '-';
                    break;
                case KeyEvent.KEYCODE_SLASH:
                    aChar = '/';
                    break;
                case KeyEvent.KEYCODE_BACKSLASH:
                    aChar = mCaps ? '|' : '\\';
                    break;
                default:
                    aChar = 0;
                    break;
            }
        }

        return aChar;

    }

    public interface OnScanSuccessListener {
        public void onScanSuccess(String barcode);
    }

    public void setOnBarCodeCatchListener(OnScanSuccessListener onScanSuccessListener) {
        mOnScanSuccessListener = onScanSuccessListener;
    }

    public void onDestroy() {
        mHandler.removeCallbacks(mScanningFishedRunnable);
        mOnScanSuccessListener = null;
    }

    /**
     * 是否为扫码枪事件(部分机型KeyEvent获取的名字错误)
     *
     * @param event
     * @return
     */
    @Deprecated
    public boolean isScanGunEvent(KeyEvent event) {
        return event.getDevice().getName().equals(mDeviceName);
    }


}

//
////Activity中重写dispatchKeyEvent方法，截取Key事件。
///**
// * Activity截获按键事件.发给ScanGunKeyEventHelper
// *
// * @param event
// * @return
// */
//@Override
//public boolean dispatchKeyEvent(KeyEvent event) {
//
//        if (isScanGunEvent(event)) {
//        mScanGunKeyEventHelper.analysisKeyEvent(event);
//        return true;
//        }
//        return super.dispatchKeyEvent(event);
//        }
//
///**
// * 显示扫描内容
// * @param barcode 条形码
// */
//@Override
//public void onScanSuccess(String barcode) {
//        //TODO 显示扫描内容
//        }
//        }
