package com.example.niu.myapplication.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;

import com.example.niu.myapplication.R;

import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.utils.DiskCacheUtils;

import java.io.File;

/**
 * Created by Administrator on 2018/6/26.
 */

public class ImageLoaderUtils {
    private static ImageLoaderConfiguration.Builder icf;
    private static ImageLoader imageloader;
    //ImageLoader的初始化工作
    public static void initImagLoader(Context context)
    {
        imageloader = ImageLoader.getInstance();
        icf = new ImageLoaderConfiguration.Builder(context);
        File file = new File("/mnt/sdcard/cache/");//缓存的位置
        DiskCache diskCache = new UnlimitedDiscCache(file);
        icf.diskCache(diskCache);
        icf.diskCacheSize(10 * 1024 * 1024);
        imageloader.init(icf.build());
    }

    //获得图片缓存

    public static Bitmap getDiscCacheImage(String uri){//这里的uri一般就是图片网址
        File file = DiskCacheUtils.findInCache(uri,  imageloader.getDiskCache());
        try {

            String path= file.getPath();
            return BitmapFactory.decodeFile(path);


        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }


        return null;
    }

    //提供图片地址URL,一个ImageView的控件对象即可将网上图片加载到本控件。
    public static void getImageLoader(String url, ImageView iv, Context context) {
        // TODO Auto-generated method stub
        ImageLoaderUtils.initImagLoader(context);

        DisplayImageOptions dio = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.default_user)// 设置图片在下载期间显示的图片
                .showImageForEmptyUri(R.drawable.default_user)// 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.default_user)// 设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(true)// 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)// 设置下载的图片是否缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(200))// 是否设置为圆角，弧度为多少
                .displayer(new FadeInBitmapDisplayer(0))// 是否图片加载好后渐入的动画时间
                .build();

        imageloader.displayImage(url, iv, dio);
    }
    //String url 网上图片地址，根据图片转换成圆形头像
    public static void getYuanImg(ImageView iv,Context context,String url)
    {
        ImageLoaderUtils.initImagLoader(context);
        Bitmap bm = BitmapUtils.createCircleImage(ImageLoaderUtils.getDiscCacheImage(url));
        iv.setImageBitmap(bm);
    }
}
class BitmapUtils {
    /**
     * 转换图片成圆形
     *
     * @param bitmap 传入Bitmap对象
     * @return
     */
    public static Bitmap createCircleImage(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float roundPx;
        float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
        if (width <= height) {
            roundPx = width / 2;
            top = 0;
            bottom = width;
            left = 0;
            right = width;
            height = width;
            dst_left = 0;
            dst_top = 0;
            dst_right = width;
            dst_bottom = width;
        } else {
            roundPx = height / 2;
            float clip = (width - height) / 2;
            left = clip;
            right = width - clip;
            top = 0;
            bottom = height;
            width = height;
            dst_left = 0;
            dst_top = 0;
            dst_right = height;
            dst_bottom = height;
        }
        Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect src = new Rect((int) left, (int) top, (int) right,
                (int) bottom);
        final Rect dst = new Rect((int) dst_left, (int) dst_top,
                (int) dst_right, (int) dst_bottom);
        final RectF rectF = new RectF(dst);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, src, dst, paint);
        return output;
    }

}