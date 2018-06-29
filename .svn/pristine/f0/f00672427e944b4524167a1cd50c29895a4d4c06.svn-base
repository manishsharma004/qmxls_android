package com.example.niu.myapplication.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.niu.myapplication.App;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.bean.goodsBean;
import com.example.niu.myapplication.bean.storeBean;
import com.example.niu.myapplication.utils.DecimalFormatUtils;
import com.example.niu.myapplication.utils.Displayer;
import com.example.niu.myapplication.utils.Hint;
import com.example.niu.myapplication.utils.ImageLoaderUtils;
import com.example.niu.myapplication.utils.RandomUntil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

/**
 * Created by wanglei on 18-5-19.
 */

public class StoreRecyclerAdapter
        extends RecyclerView.Adapter<StoreRecyclerAdapter.StoreViewHolder> {

    private static onItemClick onItemClick;

    private int position;
    private Context mContext;
    private ArrayList<storeBean>storeBeanArrayList;

    public void setOnItemClick(onItemClick onItemClick){

        this.onItemClick = onItemClick;

    }
    public StoreRecyclerAdapter(Context context,
                                ArrayList<storeBean>storeBeanList){

        mContext = context;
        storeBeanArrayList = storeBeanList;


    }
    public void updateData(ArrayList<storeBean>storeBeanList){

        storeBeanArrayList = storeBeanList;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final View view = LayoutInflater.from(mContext)
                .inflate(R.layout.xuan_store_item,parent,false);


        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final StoreViewHolder holder, final int position) {
        this.position = position;
        //圆形图片
        DisplayImageOptions
        options3 = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.default_user)
                .showImageForEmptyUri(R.drawable.default_user)
                .showImageOnFail(R.drawable.default_user)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .bitmapConfig(Bitmap.Config.ARGB_8888)   //设置图片的解码类型
                .displayer(new Displayer(0))
                .build();
        holder.storeType.setText("   "+storeBeanArrayList.get(position)
        .getStoreType()+"   ");
        holder.storeName.setText(storeBeanArrayList.get(position)
        .getStoreName());
        holder.storeStatus.setText(storeBeanArrayList.get(position)
        .getStoreStatus());
        int i= RandomUntil.getNum(1,4);
        if (i==1){
            holder.storeType.setBackgroundResource(R.drawable.selector_blue);
        }
//        if (i==2){
//            holder.storeType.setBackgroundResource(R.drawable.selector_red);
//        }
        if (i==2){
            holder.storeType.setBackgroundResource(R.drawable.selector_reds);
        } if (i==3){
            holder.storeType.setBackgroundResource(R.drawable.selector_submit);
        }
//        Hint.Short(mContext,RandomUntil.getNum(1,10)+"");
        if (storeBeanArrayList.get(position).getStoreImg()!=null) {
            ImageLoader.getInstance() .init(ImageLoaderConfiguration.createDefault(mContext));
//
            ImageLoader.getInstance().displayImage(storeBeanArrayList.get(position).getStoreImg(), holder.storePic,options3);
        }
        if (onItemClick!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick.onViewClick(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return storeBeanArrayList.size();
    }

    public static class StoreViewHolder extends RecyclerView.ViewHolder{



        private ImageView storePic;
        private TextView storeName;
        private TextView storeType;
        private TextView storeStatus;
        public StoreViewHolder(View itemView) {
            super(itemView);


            storeName = (TextView) itemView.findViewById(R.id.tv_store_name);

            storePic = (ImageView) itemView.findViewById(R.id.iv_store_icon);

            storeType= (TextView)itemView.findViewById(R.id.tv_store_type);

            storeStatus= (TextView)itemView.findViewById(R.id.store_status);

        }
    }

    public interface onItemClick{

        public void onViewClick(View view, int position);

    }
}
