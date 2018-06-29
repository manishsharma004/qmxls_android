package com.example.niu.myapplication.utils;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by wanglei on 18-6-28.
 */

public class OkHttpDownload {

    private static final String TAG = "OkHttpDownload";
    public static OkHttpDownload instance;
    OkHttpClient okHttpClient ;

    private OkHttpDownload(){


        okHttpClient = new OkHttpClient.Builder()
                .build();
    }
    public static OkHttpDownload getInstance(){

        if (instance==null){

            synchronized (OkHttpClient.class){

                if (instance==null){

                    instance = new OkHttpDownload();
                }

            }

        }
        return instance;
    }

    public void executeRequest(String url, final callBack callBack){

        Log.d(TAG, "executeRequest: URL= "+url);
        if (TextUtils.isEmpty(url)){

            callBack.onResponse(null);
            return;
        }
        Request request = new Request.Builder()
               .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                callBack.onResponse(null);

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                if (callBack!=null){


                    if (response.isSuccessful()){

                        ResponseBody responseBody = response.body();
                        byte[]bytes = responseBody.bytes();
                        Log.d(TAG, "onResponse: sucess = size= "+bytes.length);
                        callBack.onResponse(bytes);

                    }
                }
            }
        });


    }

    public interface callBack{

        void onResponse(byte[]imags);

    }

}
