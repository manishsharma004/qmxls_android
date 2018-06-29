package com.example.niu.myapplication.fragment.right;

import com.example.niu.myapplication.bean.goodsBean;

import java.util.ArrayList;

/**
 * Created by wanglei on 18-5-20.
 */

public class MessageEvent {


    private ArrayList<goodsBean>goodsBeanArrayList;
    private goodsBean goodsBean;
    //传递int类型参数
    private int typeInt;
    //传递boolean类型
    private boolean typeBoolean;
    private double totalMoney;
    public MessageEvent(String type) {
        this.type = type;
    }

    private String clientinfo;
    //传递支付码
    private String authCode;
    //区别支付
    private String isPay;
    //优惠券
    private String youhuiquan;
    //优惠金额
    private String cheap_money;
    //优惠类型
    private String youhuitype;
//现金收款
    private String shifu_pay;
    //找零
    private String zhaoling_pay;

    private String uservip;
    private String min_amount_use;

    public String getMin_amount_use() {
        return min_amount_use;
    }

    public void setMin_amount_use(String min_amount_use) {
        this.min_amount_use = min_amount_use;
    }

    public String getYouhuitype() {
        return youhuitype;
    }

    public void setYouhuitype(String youhuitype) {
        this.youhuitype = youhuitype;
    }

    public String getUservip() {
        return uservip;
    }

    public void setUservip(String uservip) {
        this.uservip = uservip;
    }

    public String getShifu_pay() {
        return shifu_pay;
    }

    public void setShifu_pay(String shifu_pay) {
        this.shifu_pay = shifu_pay;
    }

    public String getZhaoling_pay() {
        return zhaoling_pay;
    }

    public void setZhaoling_pay(String zhaoling_pay) {
        this.zhaoling_pay = zhaoling_pay;
    }

    public String getCheap_money() {
        return cheap_money;
    }

    public void setCheap_money(String cheap_money) {
        this.cheap_money = cheap_money;
    }

    public String getYouhuiquan() {
        return youhuiquan;
    }

    public void setYouhuiquan(String youhuiquan) {
        this.youhuiquan = youhuiquan;
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public boolean isTypeBoolean() {
        return typeBoolean;
    }

    public void setTypeBoolean(boolean typeBoolean) {
        this.typeBoolean = typeBoolean;
    }

    public String getClientinfo() {
        return clientinfo;
    }

    public void setClientinfo(String clientinfo) {
        this.clientinfo = clientinfo;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<goodsBean> getGoodsBeanArrayList() {
        return goodsBeanArrayList;
    }

    public void setGoodsBeanArrayList(ArrayList<goodsBean> goodsBeanArrayList) {
        this.goodsBeanArrayList = goodsBeanArrayList;
    }

    public com.example.niu.myapplication.bean.goodsBean getGoodsBean() {
        return goodsBean;
    }

    public void setGoodsBean(com.example.niu.myapplication.bean.goodsBean goodsBean) {
        this.goodsBean = goodsBean;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getTypeInt() {
        return typeInt;
    }

    public void setTypeInt(int typeInt) {
        this.typeInt = typeInt;
    }
}
