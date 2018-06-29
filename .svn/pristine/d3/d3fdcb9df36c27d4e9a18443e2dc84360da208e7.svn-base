package com.example.niu.myapplication.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.util.List;

/**
 * 订单
 * Created by wanglei on 18-5-19.
 */

public class ordersBean extends DataSupport implements Serializable{
    private int id;
    /**
     * 是否同步
     */
    private String isauto;
    private int goodsPic;

    private String goodsName;
    private double price;
    private String goodsId;
    private String unit;
    private int number;
    private String changeType;
    private String goodsimg;
    private String userid;
    /**
     * 优惠券优惠金额
     */
    private String  coupon_minus;
    /**
     *   会员卡优惠
     */
    private String  card_minus;
    /**
     * 优惠总金额
     */
    private String  minus_amount;
    /**
     * 订单号
     */
    private String   trade_no;
    /**
     * 是否支付
     */
    private String   ispay;
    /**
     * 支付方式（）
     */
    private String   payment_id;
//    /**
//     * 实付金额
//     */
//    private String   shifuprice;
//    /**
//     * 应付金额
//     */
//    private String   yingfuprice;
    /**
     * 会员
     */
    private String   huiyuan;
    /**
     * 订单总金额
     */
    private String   total_amount;
    /**
     * 支付金额
     */
    private String   amount;
    /**
     *会员卡id
     */
    private String   card_id;
    /**
     * 优惠券id
     */
    private String   coupon_id;
    private String   user_remarks;
    private String   seller_remarks;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUser_remarks() {
        return user_remarks;
    }

    public void setUser_remarks(String user_remarks) {
        this.user_remarks = user_remarks;
    }

    public String getSeller_remarks() {
        return seller_remarks;
    }

    public void setSeller_remarks(String seller_remarks) {
        this.seller_remarks = seller_remarks;
    }

    private List<orderIteminfo> orderIteminfo;

    public List<orderIteminfo> getOrderIteminfo() {
        return orderIteminfo;
    }

    public void setOrderIteminfo(List<orderIteminfo> orderIteminfo) {
        this.orderIteminfo = orderIteminfo;
    }

    public String getIsauto() {
        return isauto;
    }

    public void setIsauto(String isauto) {
        this.isauto = isauto;
    }

    public String getCoupon_minus() {
        return coupon_minus;
    }

    public void setCoupon_minus(String coupon_minus) {
        this.coupon_minus = coupon_minus;
    }

    public String getCard_minus() {
        return card_minus;
    }

    public void setCard_minus(String card_minus) {
        this.card_minus = card_minus;
    }

    public String getMinus_amount() {
        return minus_amount;
    }

    public void setMinus_amount(String minus_amount) {
        this.minus_amount = minus_amount;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getIspay() {
        return ispay;
    }

    public void setIspay(String ispay) {
        this.ispay = ispay;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getHuiyuan() {
        return huiyuan;
    }

    public void setHuiyuan(String huiyuan) {
        this.huiyuan = huiyuan;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(String coupon_id) {
        this.coupon_id = coupon_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ordersBean(String goodsimg, String goodsName,
                      double price, int number, String goodsId , String unit) {
        this.goodsName = goodsName;
        this.goodsimg = goodsimg;
        this.price = price;
        this.goodsId = goodsId;
        this.unit = unit;
        this.number = number;
    }

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "goodsBean{" +
                "goodsPic=" + goodsPic +
                ", goodsName='" + goodsName + '\'' +
                ", price='" + price + '\'' +
                ", goodsimg='" + goodsimg + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", number=" + number +
                '}';
    }

    public int getGoodsPic() {
        return goodsPic;
    }

    public ordersBean(String goodsimg, String goodsName, double price, int number, String goodsId ) {
        this.goodsimg = goodsimg;
        this.goodsName = goodsName;
        this.price = price;
        this.goodsId = goodsId;
        this.number = number;
    }

    public ordersBean(String goodsimg, String goodsName, double price) {
        this.goodsimg = goodsimg;
        this.goodsName = goodsName;
        this.price = price;
    }

    public ordersBean() {
    }

    public ordersBean(String goodsimg, String goodsName, double price, int number) {
        this.goodsimg = goodsimg;
        this.goodsName = goodsName;
        this.price = price;
        this.number = number;
    }

    public void setGoodsPic(int goodsPic) {
        this.goodsPic = goodsPic;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }
}
