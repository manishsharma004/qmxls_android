package com.example.niu.myapplication.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.niu.myapplication.App;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.bean.goodsBean;
import com.example.niu.myapplication.utils.DecimalFormatUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;
import static android.view.View.resolveSize;

/**
 * Created by wanglei on 18-5-19.
 */

public class GoodsRecyclerAdapter
        extends RecyclerView.Adapter<GoodsRecyclerAdapter.GoodsViewHolder> {

    private static onItemClick onItemClick;

    private int position;
    private Context mContext;
    private ArrayList<goodsBean>goodsBeanArrayList;

    public void setOnItemClick(onItemClick onItemClick){

        this.onItemClick = onItemClick;

    }
    public GoodsRecyclerAdapter(Context context,
                                ArrayList<goodsBean>goodsBeanList){

        mContext = context;
        goodsBeanArrayList = goodsBeanList;


    }

    public void updateData(ArrayList<goodsBean>goodsBeanList){

        goodsBeanArrayList = goodsBeanList;

        Log.d(TAG, "updateData: goodsBeanArrayList= "+goodsBeanArrayList.size());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final View view = LayoutInflater.from(mContext)
                .inflate(R.layout.recycler_item_goods,parent,false);


        return new GoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GoodsViewHolder holder, final int position) {
        //ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(mContext));
        //ImageLoader.getInstance().displayImage(goodsBeanArrayList.get(position).
        // getGoodsimg(), holder.goodsPic);

        this.position = position;
        Log.d(TAG, "onBindViewHolder: position= "+goodsBeanArrayList.get(position)
        .getGoodsName());
        holder.goodsName.setText(goodsBeanArrayList.get(position)
        .getGoodsName());

        Glide.with(mContext)
                .load(goodsBeanArrayList.get(position).getGoodsimg())
                .asBitmap()
               .placeholder(R.drawable.default_user)
                .error(R.drawable.default_user)
                .listener(new RequestListener<String, Bitmap>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {


                        saveImage(resource,goodsBeanArrayList.get(position));
                        return false;
                    }
                })
                .into(holder.goodsPic);
       // double price = goodsBeanArrayList.get(position).getPrice();
       // DecimalFormat df = new DecimalFormat(".00");
       // ImageLoader.getInstance() .init(ImageLoaderConfiguration.createDefault(mContext));
//
      /*  ImageLoader.getInstance().displayImage(goodsBeanArrayList.
                get(position).getGoodsimg(), holder.goodsPic);*/

        holder.goodsPrice.setText(DecimalFormatUtils.doubleToMoney(goodsBeanArrayList.get(position).getPrice())+goodsBeanArrayList
        .get(position).getUnit());


        if (onItemClick!=null){

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick.onViewClick(holder.itemView,position);
                }
            });
        }
    }

    private void saveImage(Bitmap resource, goodsBean goodsBean) {


        String goodsId = goodsBean.getGoodsId();
        //BitmapDrawable bitmapDrawable = (BitmapDrawable) resource;


 //       Bitmap bitmap = bitmapDrawable.getBitmap();

        String path = App.getBaseApplication().getFilesDir() + File.separator + goodsId+".png";

        File file = new File(path);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            resource.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
            fileOutputStream.close();


            Log.d(TAG, "saveImage: save sucess "+file.getAbsolutePath()+"  filesDir= "+path);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            {

                goodsBean.setLocal_image(path);
                goodsBean.updateAll("goodsid = ?",goodsId);

            }
        }


    }

    @Override
    public int getItemCount() {
        return goodsBeanArrayList.size();
    }

    public static class GoodsViewHolder extends RecyclerView.ViewHolder{



        private ImageView goodsPic;
        private TextView goodsName;
        private TextView goodsPrice;
        public GoodsViewHolder(View itemView) {
            super(itemView);


            goodsName = (TextView) itemView.findViewById(R.id.tv_goods_name);

            goodsPic = (ImageView) itemView.findViewById(R.id.tv_goods_pic);

            goodsPrice = (TextView)itemView.findViewById(R.id.tv_goods_price);

        }
    }

    public interface onItemClick{

        public void onViewClick(View view,int position);

    }
}
