package com.example.niu.myapplication.fragment.right;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.niu.myapplication.App;
import com.example.niu.myapplication.BaseFragment;
import com.example.niu.myapplication.R;
import com.example.niu.myapplication.activity.ChooseStoreActivity;
import com.example.niu.myapplication.activity.MainActivity;
import com.example.niu.myapplication.adapter.GoodsRecyclerAdapter;
import com.example.niu.myapplication.bean.goodsBean;
import com.example.niu.myapplication.presenter.Constract;
import com.example.niu.myapplication.utils.APPUtil;
import com.example.niu.myapplication.utils.Data;
import com.example.niu.myapplication.utils.DecimalFormatUtils;
import com.example.niu.myapplication.utils.Hint;
import com.example.niu.myapplication.utils.OkHttpDownload;
import com.example.niu.myapplication.utils.Xutils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.crud.DataSupport;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import sunmi.ds.DSKernel;

import static android.support.constraint.Constraints.TAG;

/**
 * 商品列表
 * Created by NIU on 2018/5/18.
 */

@SuppressLint("ValidFragment")
public class Right_goods_fragment extends BaseFragment implements
        GoodsRecyclerAdapter.onItemClick,Constract.MainView {


    public static final int REQUEST = 1;
    public static final int UPDATEUI = 2;
    private static final int PANDUAN = 3;

    @BindView(R.id.rv_goods)
    RecyclerView rv_goods;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.rl_search_item1)
    RelativeLayout rlSearchItem1;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.et_goods_search)
    EditText etGoodsSearch;
    @BindView(R.id.rl_search_item2)
    RelativeLayout rlSearchItem2;
    @BindView(R.id.ll_goods_items)
    LinearLayout llGoodsItems;
    @BindView(R.id.ll_empty)
    LinearLayout llEmpty;
    @BindView(R.id.tv_all_goods)
    TextView tvAllGoods;
//    @BindView(R.id.tv_order_one)
//    TextView tvOrderOne;
//    @BindView(R.id.tv_order_two)
//    TextView tvOrderTwo;
    Unbinder unbinder;

    int totalGoods;
    int index;
    private OnGoodsItemSelect onGoodsItemSelect;
    private LinearLayoutManager linearLayoutManager;
    private GoodsRecyclerAdapter goodsRecyclerAdapter;
    private ArrayList<goodsBean> goodsBeanArrayList;

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){

                case REQUEST:

                    break;


                case PANDUAN:

                    Log.d(TAG, "handleMessage: msg.arf1= "+msg.arg1
                    +"total= "+totalGoods);

                        getDatasFromSQL();


                    break;


                case UPDATEUI:

                    Log.d(TAG, "handleMessage: UPDATEUI");
                    uodateRecycler(goodsBeanArrayList);

                    break;
            }

        }
    };

    private void uodateRecycler(ArrayList<goodsBean> obj) {

        Log.d(TAG, "uodateRecycler: ");
        goodsRecyclerAdapter.updateData(goodsBeanArrayList);
    }

    private void getDatasFromSQL() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                goodsBeanArrayList = (ArrayList<goodsBean>) DataSupport.findAll(goodsBean.class);
                Log.d(TAG, "getDatasFromSQL: goodsBeanArrayList= "+goodsBeanArrayList.size());


                Message message = new Message();
                message.what = UPDATEUI;
                message.obj = goodsBeanArrayList;
                handler.sendMessage(message);
            }
        }).start();
    }


    @Override
    protected void initData() {
        new Thread(new Runnable(){
            @Override
            public void run() {
                if (APPUtil.isNetworkAvalible(getActivity())){
                    initStoreData("",1+"");
                }else {
                    goodsBeanArrayList = (ArrayList<goodsBean>) DataSupport.findAll(goodsBean.class);


                   if (goodsBeanArrayList!=null&& goodsBeanArrayList.size()>0){

                       Message message = new Message();
                       message.what = UPDATEUI;
                     //  message.obj = goodsBeanArrayList;
                     //handler.sendMessage();
                       handler.sendMessage(message);
                      // goodsRecyclerAdapter.updateData(goodsBeanArrayList);

                   }
                }
            }
        }).start();
        linearLayoutManager = new GridLayoutManager(activity, 3);
        goodsBeanArrayList = new ArrayList<>();

        goodsRecyclerAdapter = new GoodsRecyclerAdapter(activity, goodsBeanArrayList);

        goodsRecyclerAdapter.setOnItemClick(this);
        rv_goods.setLayoutManager(linearLayoutManager);
        rv_goods.setAdapter(goodsRecyclerAdapter);
    }

    @Override
    protected void initView(View rootView) {

        EventBus.getDefault().register(this);




    }

    @Override
    protected int getLayout() {
        return R.layout.cashier_right_item_goods;
    }

    @Override
    public void onViewClick(View view, int position) {

        //onGoodsItemSelect.onGoodsSelect(goodsBeanArrayList.get(position));

        MessageEvent messageEvent = new MessageEvent("update");

        messageEvent.setGoodsBean(goodsBeanArrayList.get(position));
        EventBus.getDefault().post(messageEvent);

        /*Toast.makeText(activity,"position= "+position,Toast.LENGTH_SHORT)
                .show();*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.rl_search_item1, R.id.tv_cancel, R.id.et_goods_search, R.id.rl_search_item2, R.id.ll_goods_items, R.id.ll_empty, R.id.tv_all_goods})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_search_item1:
                rlSearchItem1.setVisibility(View.GONE);
                rlSearchItem2.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_cancel:
                rlSearchItem1.setVisibility(View.VISIBLE);
                rlSearchItem2.setVisibility(View.GONE);

                break;
            case R.id.et_goods_search:
                break;
            case R.id.rl_search_item2:
                break;
            case R.id.ll_goods_items:
                break;
            case R.id.ll_empty:
                break;
            case R.id.tv_all_goods:
                initStoreData("",1+"");

                break;
//            case R.id.tv_order_one:
//                break;
//            case R.id.tv_order_two:
//                break;
        }
    }
   public void initStoreData(String keywords,String page){
       goodsBeanArrayList = new ArrayList<>();
       String url = App.API_URL+"reta/decoration/goods";
       Map<String,String> stringMap = new HashMap<>();
       stringMap.put("page", page);
       stringMap.put("page_size", Integer.MAX_VALUE+"");
       Xutils.getInstance().get(url, stringMap, new Xutils.XCallBack() {
           @Override
           public void onResponse(String str) {
               try {
                   Log.e("AAAAAAA",str);
                   JSONObject mjsonObjects = new JSONObject(str);
                   String result = mjsonObjects.getString("status");
                   String code = mjsonObjects.getString("code");
                   String message = mjsonObjects.getString("message");
                   if (result.equals("true")) {
                       JSONObject mjsonObject =mjsonObjects.getJSONObject("data");
                       JSONArray mjsonObjectss =mjsonObject.getJSONArray("items");

                       if (mjsonObjectss.length()>0){

                           goodsBean mgoods;
                           totalGoods = mjsonObjectss.length();
                           Log.d(TAG, "onResponse: totalGoods= "+totalGoods);
                           for (int i=0;i<totalGoods;i++) {
                           Double cny = Double.parseDouble(mjsonObjectss.getJSONObject(i).getString("sell_price"));//6.2041    这个是转为double类型
                           DecimalFormat df = new DecimalFormat("0.00");
                           String CNY = df.format(cny); //6.20   这个是字符串，但已经是我要的两位小数了
                           Log.i(TAG, CNY);
                           Double cny2 = Double.parseDouble(CNY); //6.20
                           String unit = mjsonObjectss.getJSONObject(i).getString("unit");
                           if (unit != null && !unit.equals(""))
                           {

                           }else {
                               unit="件";
                           }
                           try {
                               String store = App.store.getString("storeinfo");
                               if (store!=null){

                                   String  storeid = new JSONObject(store).getString("id");
                                   String mobile = App.store.getString("mobile");
                                   mgoods = new goodsBean();
                                   mgoods.setGoodsimg(mjsonObjectss.getJSONObject(i).getString("image"));
                                   mgoods.setGoodsName(mjsonObjectss.getJSONObject(i).getString("name"));
                                   mgoods.setPrice(cny2);
                                   mgoods.setNumber(mjsonObjectss.getJSONObject(i).getInt("sort"));
                                   mgoods.setGoodsId(mjsonObjectss.getJSONObject(i).getString("sell_price"));
                                   mgoods.setUnit("/"+unit);
                                   mgoods.setStoreid(storeid);
                                   mgoods.setStoremobile(mobile);
                                   mgoods.setProduct_no( mjsonObjectss.getJSONObject(i)
                                           .getJSONArray("product_no").get(0).toString());

                                   Log.d(TAG, "onResponse: url= "+mgoods.getGoodsimg());
                                   //downLoadImageAndSaveSQL(mgoods);

                                   mgoods.setLocal_image(null);

                                   List<goodsBean> goodsBeanList=
                                     DataSupport.where("goodsid=?",mgoods.getGoodsId())
                                            .find(goodsBean.class);
                                    if (goodsBeanList.size()<=0){

                                      mgoods.save();
                                    }
                                      goodsBeanArrayList.add(mgoods);

                                   /*goodsBeanArrayList.add(new goodsBean(mjsonObjectss.getJSONObject(i).getString("image"),mjsonObjectss.getJSONObject(i).getString("name")
                                           , cny2, mjsonObjectss.getJSONObject(i).getInt("sort"), mjsonObjectss.getJSONObject(i).getString("sell_price"), "/"+unit
                                           ,storeid,mobile,mjsonObjectss.getJSONObject(i).getString("product_no"),""));
*/
                                   //                                   DataSupport.saveAll();
                               }
                           } catch (JSONException e) {
                               e.printStackTrace();
                           }


                       }

                           goodsRecyclerAdapter.updateData(goodsBeanArrayList);
//                           App.store.getString("storeinfo").
//                          if (issave){
////                              issave
//                              Hint.Short(getActivity(),"保存成功");
//                          }else {
//                              Hint.Short(getActivity(),"保存失败");
//                          }


//                           DataSupport.sa`(mgoodsBean);
                       }else {
                           Hint.Short(getActivity(),"暂无商品！");
                       }

                   }else {
                       Hint.Short(getActivity(),message+">>>"+code);
                       if (code.equals("9001")){
                           Hint.Short(getActivity(),"登录超时");
                       }
                   }

                   Log.d(TAG, "onResponse: save finish");
               } catch (JSONException e) {
                   e.printStackTrace();
               }


           }

           @Override
           protected Object clone() throws CloneNotSupportedException {
               return super.clone();
           }

       });

    }

    private void downLoadImageAndSaveSQL(final goodsBean goodsBean) {

       final ArrayList<goodsBean>goodsBeanArrayList = null;


        OkHttpDownload.getInstance().
                executeRequest(goodsBean.getGoodsimg(), new OkHttpDownload.callBack() {
                    @Override
                    public void onResponse(byte[] imags) {
                      //  Log.d(TAG, "onResponse: imags= "+(imags.length));
                        //goodsBean.setLocal_image(imags);


                        if (goodsBean.getLocal_image()!=null){
                            Log.d(TAG, "onResponse: goodsBean.getLocal_image()!=null");

                        }

                        boolean issave = goodsBean.save();
                        if (issave){
                            Log.d(TAG, "onResponse: 保存成功");


                            String storeId = App.store.getString("storeinfo");

                            //goodsBeanArrayList = (ArrayList<com.example.niu.myapplication.bean.goodsBean>) DataSupport.findAll(goodsBean.class);



                            //Hint.Short(getActivity(),"保存成功");
                        }else {
                        //    Hint.Short(getActivity(),"保存失败");

                            Log.d(TAG, "onResponse: 保存失败");
                        }

                        Message message = new Message();
                        message.what = PANDUAN;
                        message.arg1 = index;
                        handler.sendMessage(message);

                        index++;

                        //Message message = new Message();
                        //handler.sendMessage()


                    }

        });







   }



    @Override
    public void updateVIew(ArrayList<goodsBean>arrayList) {





    }

    public interface OnGoodsItemSelect {

        public void onGoodsSelect(goodsBean goodsBean);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent messageEvent) {


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }
}
