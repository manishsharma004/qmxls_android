package com.example.niu.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.niu.myapplication.R;
import com.example.niu.myapplication.bean.CouponsEntry;
import com.example.niu.myapplication.bean.goodsBean;
import com.example.niu.myapplication.fragment.right.MessageEvent;
import com.example.niu.myapplication.utils.Hint;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

/**
 * Created by wanglei on 18-5-22.
 */

public class CouponsRecyclerAdapter extends RecyclerView.Adapter<CouponsRecyclerAdapter.CouponsViewHolder>{
    boolean isSelectCoupons;
    private OnViewItemClickListener onViewItemClickListener;
    private ArrayList<CouponsEntry>CouponsEntryArrayList;
    private Context mContext;
    public CouponsRecyclerAdapter(Context context,ArrayList<CouponsEntry>EntryArrayList){

        mContext = context;
       this.CouponsEntryArrayList= EntryArrayList;

    }
    public void updateData(ArrayList<CouponsEntry>goodsBeanList) {
        if (goodsBeanList != null && goodsBeanList.size() > 0){
            this.CouponsEntryArrayList = goodsBeanList;
    }
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CouponsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.recycle_item_coupons,parent,false);
        return new CouponsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CouponsViewHolder holder, final int position) {

        holder.tv_validity_period.setText(CouponsEntryArrayList.get(position).getType_id());
        if (CouponsEntryArrayList.get(position).getCoupon_type().equals("0")){
        holder.tv_coupons_style.setText("面值券");
            holder.tv_cheap_money.setText(CouponsEntryArrayList.get(position).getAmount());
            holder.tv_unit.setText("元");
        }else {
            holder.tv_coupons_style.setText("折扣券");
            holder.tv_unit.setText("折");
        }


        holder.llCoupons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSelectCoupons){
                holder.llCoupons.setBackgroundResource(R.drawable.coupons_select);
                    if (CouponsEntryArrayList.get(position).getCoupon_type().equals("0")){
                    MessageEvent messageEvent = new MessageEvent("coupons");
                    messageEvent.setYouhuiquan("1");
                    messageEvent.setYouhuitype("1");
                    messageEvent.setMin_amount_use(CouponsEntryArrayList.get(position).getMin_amount_use());
                    messageEvent.setCheap_money( holder.tv_cheap_money.getText().toString());
                    EventBus.getDefault().postSticky(messageEvent);
                    }else {
                        MessageEvent messageEvent = new MessageEvent("coupons");
                        messageEvent.setYouhuiquan("1");
                        messageEvent.setYouhuitype("2");
                        messageEvent.setCheap_money( holder.tv_cheap_money.getText().toString());
                        EventBus.getDefault().postSticky(messageEvent);
                    }

            }else{
                    holder.llCoupons.setBackgroundResource(R.drawable.coupons_unselect);
                    if (CouponsEntryArrayList.get(position).getCoupon_type().equals("0")){
                    MessageEvent messageEvent = new MessageEvent("coupons");
                    messageEvent.setYouhuiquan("0");
                    messageEvent.setCheap_money(holder.tv_cheap_money.getText().toString());
                    messageEvent.setYouhuitype("1");
                    EventBus.getDefault().postSticky(messageEvent);
                    }else {
                        MessageEvent messageEvent = new MessageEvent("coupons");
                        messageEvent.setYouhuiquan("0");
                        messageEvent.setCheap_money(holder.tv_cheap_money.getText().toString());
                        messageEvent.setYouhuitype("2");
                    }
                }
                isSelectCoupons = !isSelectCoupons;

            }
        });

    }

    @Override
    public int getItemCount() {
        return CouponsEntryArrayList.size();
    }

    public static class CouponsViewHolder extends RecyclerView.ViewHolder{



        RelativeLayout llCoupons;
        TextView tv_validity_period;
        TextView tv_cheap_money;
        TextView tv_vip_name;
        TextView tv_coupons_style;
        TextView tv_info;
        TextView tv_unit;

        public CouponsViewHolder(View itemView) {
            super(itemView);
            llCoupons = (RelativeLayout) itemView.findViewById(R.id.ll_coupons_card);
            tv_cheap_money = (TextView) itemView.findViewById(R.id.tv_cheap_money);
            tv_unit = (TextView) itemView.findViewById(R.id.tv_unit);
            tv_validity_period = (TextView) itemView.findViewById(R.id.tv_validity_period);
            tv_vip_name = (TextView) itemView.findViewById(R.id.tv_vip_name);
            tv_coupons_style = (TextView) itemView.findViewById(R.id.tv_coupons_style);
            tv_info = (TextView) itemView.findViewById(R.id.tv_info);


        }

    }

    public void setViewItemClickListener(OnViewItemClickListener onViewItemClickListener){

        this.onViewItemClickListener = onViewItemClickListener;
    }


    public interface OnViewItemClickListener{

        public void onClick(View view,int position);

    }
//    public void updateData(ArrayList<goodsBean>goodsBeanList){
//
//        goodsBeanArrayList = goodsBeanList;
//
//        notifyDataSetChanged();
//    }
}
