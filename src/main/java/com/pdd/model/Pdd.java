package com.pdd.model;

import java.util.Date;

public class Pdd {
    private Integer id;

    private Long goodsId;

    private String goodsName;

    private String hdThumbUrl;

    private Date hdThumbDate;

    private String hdUrl;

    private Date hdDate;

    private Long mallId;

    private Double priceInfo;

    private Integer sales;

    private String typen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getHdThumbUrl() {
        return hdThumbUrl;
    }

    public void setHdThumbUrl(String hdThumbUrl) {
        this.hdThumbUrl = hdThumbUrl;
    }

    public Date getHdThumbDate() {
        return hdThumbDate;
    }

    public void setHdThumbDate(Date hdThumbDate) {
        this.hdThumbDate = hdThumbDate;
    }

    public String getHdUrl() {
        return hdUrl;
    }

    public void setHdUrl(String hdUrl) {
        this.hdUrl = hdUrl;
    }

    public Date getHdDate() {
        return hdDate;
    }

    public void setHdDate(Date hdDate) {
        this.hdDate = hdDate;
    }

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public Double getPriceInfo() {
        return priceInfo;
    }

    public void setPriceInfo(Double priceInfo) {
        this.priceInfo = priceInfo;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getTypen() {
        return typen;
    }

    public void setTypen(String typen) {
        this.typen = typen;
    }
}