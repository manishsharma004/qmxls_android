package com.example.niu.myapplication.utils;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;

import com.example.niu.myapplication.App;
import com.example.niu.myapplication.R;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.io.File;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/12.
 */

public class Xutils {

    private volatile static Xutils instance;
    private Handler handler;
    private ImageOptions options;

    private Xutils() {
        handler = new Handler(Looper.getMainLooper());
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static Xutils getInstance() {
        if (instance == null) {
            synchronized (Xutils.class) {
                if (instance == null) {
                    instance = new Xutils();
                }
            }
        }
        return instance;
    }

    /**
     * 异步get请求
     *
     * @param url
     * @param maps
     * @param callBack
     */
    public void get(String url, Map<String, String> maps, final XCallBack callBack) {
        RequestParams params = new RequestParams(url);
        if (maps != null && !maps.isEmpty()) {
            for (Map.Entry<String, String> entry : maps.entrySet()) {
                params.addQueryStringParameter(entry.getKey(), entry.getValue());
            }
        }
        params.addHeader("Accept","*/*; v=1.0");
        params.addHeader("Referer", App.API_URL);
        params.addHeader("Qm-From","android");
        params.addHeader("Qm-From-Type","reta");
        params.addHeader("Qm-Account-Token",App.store.getString("cookie_auth"));
        params.addHeader("User-Agent","wechatdevtools appservice port/62739");

        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {

                onSuccessResponse(result, callBack);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                ex.printStackTrace();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    /**
     * 异步post请求
     *
     * @param url
     * @param maps
     * @param callback
     */
    public void post(String url, Map<String, String> maps, final XCallBack callback) {
        RequestParams params = new RequestParams(url);
        if (maps != null && !maps.isEmpty()) {
            for (Map.Entry<String, String> entry : maps.entrySet()) {
                params.addBodyParameter(entry.getKey(), entry.getValue());
            }
        }
        params.addHeader("Accept","*/*; v=1.0");
        params.addHeader("Referer", App.API_URL);
        params.addHeader("Qm-From","android");
        params.addHeader("Qm-From-Type","reta");
        params.addHeader("Qm-Account-Token",App.store.getString("cookie_auth"));
        params.addHeader("User-Agent","wechatdevtools appservice port/62739");
        Log.e("AAAAAAA",params.toString());
        x.http().post(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                onSuccessResponse(result, callback);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    /**
     * 异步post请求
     *
     * @param url
     * @param maps
     * @param callback
     */
    public void Loginpost(String url, Map<String, String> maps, final XCallBack callback) {
        RequestParams params = new RequestParams(url);
        if (maps != null && !maps.isEmpty()) {
            for (Map.Entry<String, String> entry : maps.entrySet()) {
                params.addBodyParameter(entry.getKey(), entry.getValue());
            }
        }
        params.addHeader("Accept","*/*; v=1.0");
        params.addHeader("Referer", App.API_URL);
        params.addHeader("Qm-From","android");
        params.addHeader("Qm-From-Type","reta");
//            .addHeader("Qm-Account-Token","")
        params.addHeader("User-Agent","wechatdevtools appservice port/62739");

        x.http().post(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                onSuccessResponse(result, callback);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


    /**
     * 带缓存数据的异步 get请求
     *
     * @param url
     * @param maps
     * @param pnewCache
     * @param callback
     */
    public void getCache(String url, Map<String, String> maps, final boolean pnewCache, final XCallBack callback) {

        RequestParams params = new RequestParams(url);
        if (maps != null && !maps.isEmpty()) {
            for (Map.Entry<String, String> entry : maps.entrySet()) {
                params.addQueryStringParameter(entry.getKey(), entry.getValue());
            }
        }
        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                onSuccessResponse(result, callback);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                boolean newCache = pnewCache;
                if (newCache) {
                    newCache = !newCache;
                }
                if (!newCache) {
                    newCache = !newCache;
                    onSuccessResponse(result, callback);
                }
                return newCache;
            }
        });
    }

    /**
     * 带缓存数据的异步 post请求
     *
     * @param url
     * @param maps
     * @param pnewCache
     * @param callback
     */
    public void postCache(String url, Map<String, String> maps, final boolean pnewCache, final XCallBack callback) {
        RequestParams params = new RequestParams(url);
        if (maps != null && !maps.isEmpty()) {
            for (Map.Entry<String, String> entry : maps.entrySet()) {
                params.addBodyParameter(entry.getKey(), entry.getValue());
            }
        }

        x.http().post(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                onSuccessResponse(result, callback);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }


            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                boolean newCache = pnewCache;
                if (newCache) {
                    newCache = !newCache;
                }
                if (!newCache) {
                    newCache = !newCache;
                    onSuccessResponse(result, callback);
                }
                return newCache;
            }
        });
    }


    /**
     * 正常图片显示
     *
     * @param iv
     * @param url
     * @param option
     */
    public void bindCommonImage(ImageView iv, String url, boolean option) {
        if (option) {
            options = new ImageOptions.Builder().setLoadingDrawableId(R.mipmap.ic_launcher).setFailureDrawableId(R.mipmap.ic_launcher_round).build();
            x.image().bind(iv, url, options);
        } else {
            x.image().bind(iv, url);
        }
    }

    /**
     * 圆形图片显示
     *
     * @param iv
     * @param url
     * @param option
     */
    public void bindCircularImage(ImageView iv, String url, boolean option) {
        if (option) {
            options = new ImageOptions.Builder().setLoadingDrawableId(R.mipmap.ic_launcher).setFailureDrawableId(R.mipmap.ic_launcher_round).setCircular(true).build();
            x.image().bind(iv, url, options);
        } else {
            x.image().bind(iv, url);
        }
    }


    /**
     * 文件上传
     *
     * @param url
     * @param maps
     * @param file
     * @param callback
     */
    public void upLoadFile(String url, Map<String, String> maps, Map<String, File> file, final XCallBack callback) {
        RequestParams params = new RequestParams(url);
        if (maps != null && !maps.isEmpty()) {
            for (Map.Entry<String, String> entry : maps.entrySet()) {
                params.addBodyParameter(entry.getKey(), entry.getValue());
            }
        }
        if (file != null) {
            for (Map.Entry<String, File> entry : file.entrySet()) {
                params.addBodyParameter(entry.getKey(), entry.getValue().getAbsoluteFile());
            }
        }
        // 有上传文件时使用multipart表单, 否则上传原始文件流.
        params.setMultipart(true);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                onSuccessResponse(result, callback);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }


    /**
     * 文件下载
     *
     * @param url
     * @param maps
     * @param callBack
     */
//    public void downLoadFile(String url, Map<String, String> maps, final XDownLoadCallBack callBack) {
//
//        RequestParams params = new RequestParams(url);
//        if (maps != null && !maps.isEmpty()) {
//            for (Map.Entry<String, String> entry : maps.entrySet()) {
//                params.addBodyParameter(entry.getKey(), entry.getValue());
//            }
//        }
//        params.setAutoRename(true);// 断点续传
//        params.setSaveFilePath(PublicParams.SAVE_FILE_PATH);
//        x.http().post(params, new Callback.ProgressCallback<File>() {
//            @Override
//            public void onSuccess(final File result) {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (callBack != null) {
//                            callBack.onResponse(result);
//                        }
//                    }
//                });
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (callBack != null) {
//                            callBack.onFinished();
//                        }
//                    }
//                });
//            }
//
//            @Override
//            public void onWaiting() {
//
//            }
//
//            @Override
//            public void onStarted() {
//
//            }
//
//            @Override
//            public void onLoading(final long total, final long current, final boolean isDownloading) {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (callBack != null) {
//                            callBack.onLoading(total, current, isDownloading);
//                        }
//                    }
//                });
//            }
//        });
//
//    }


    /**
     * 异步get请求返回结果,json字符串
     *
     * @param result
     * @param callBack
     */
    private void onSuccessResponse(final String result, final XCallBack callBack) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (callBack != null) {
                    callBack.onResponse(result);
                }
            }
        });
    }


    public interface XCallBack {
        void onResponse(String result);
    }


    public interface XDownLoadCallBack extends XCallBack {
        void onResponse(File result);

        void onLoading(long total, long current, boolean isDownloading);

        void onFinished();
    }
}
