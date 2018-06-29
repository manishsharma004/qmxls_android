package com.example.niu.myapplication.bean;

import org.litepal.crud.DataSupport;
import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * 订单列表
 * Created by niu on 2018/5/18.
 */

public class orderIteminfo extends DataSupport {
    private int id;
    /**
     * 商品id
     */
    private String data_id;
    /**
     * 实体id
     */
    private String entity_id;
    /**
     * 实体条码
     */
    private String product_no;
    /**
     * 实体名称
     */
    private String name;
    /**
     * 实体图片
     */
    private String image;
    /**
     * 实体单价
     */
    private String price;
    /**
     * 数量
     */
    private String qty;
    /**
     * 规格
     */
    private String spec;
    /**
     * 优惠金额
     */
    private String minus;
    /**
     * 描述
     */
    private String messages;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_id() {
        return data_id;
    }

    public void setData_id(String data_id) {
        this.data_id = data_id;
    }

    public String getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id;
    }

    public String getProduct_no() {
        return product_no;
    }

    public void setProduct_no(String product_no) {
        this.product_no = product_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getMinus() {
        return minus;
    }

    public void setMinus(String minus) {
        this.minus = minus;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
