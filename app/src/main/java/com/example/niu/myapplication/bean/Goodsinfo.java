package com.example.niu.myapplication.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2018/5/18.
 */
@Table(name="goodsinfo")
public class Goodsinfo {
    @Column(name = "_ID", isId = true, autoGen = true)
    String _id;
    @Column(name = "GOODS_NAME")
    String goods_name;
    @Column(name = "GOODS_IMG")
    String goods_img;
    @Column(name = "GOODS_NUMBER")
    String goods_number;
    /**
     * 类型
     */
    @Column(name = "GOODS_TYPE")
    String goods_type;
    /**
     * 价格
     */
    @Column(name = "GOODS_BRAND")
    String goods_brand;
    /**
     * 库存
     */
    @Column(name = "GOODS_PRICE")
    String goods_price;
    /**
     * 库存
     */
    @Column(name = "GOODS_STOCK")
    String goods_stock;
    /**
     * 销量
     */
    @Column(name = "GOODS_SALES")
    String goods_sales;
    /**
     * 单位
     */
    @Column(name = "UNIT")
    String  unit;

    /**
     * 优惠券
     */
    @Column(name = "COUPON")
    String	coupon;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }



    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public String getGoods_brand() {
        return goods_brand;
    }

    public void setGoods_brand(String goods_brand) {
        this.goods_brand = goods_brand;
    }

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_stock() {
        return goods_stock;
    }

    public void setGoods_stock(String goods_stock) {
        this.goods_stock = goods_stock;
    }

    public String getGoods_sales() {
        return goods_sales;
    }

    public void setGoods_sales(String goods_sales) {
        this.goods_sales = goods_sales;
    }

    public String getGoods_number() {
        return goods_number;
    }

    public void setGoods_number(String goods_number) {
        this.goods_number = goods_number;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }
}
