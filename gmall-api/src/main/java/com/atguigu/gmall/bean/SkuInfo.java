package com.atguigu.gmall.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SkuInfo implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String spuId;
    @Column
    private String price;
    @Column
    private String skuName;
    @Column
    private String skuDesc;
    @Column
    private String weight;
    @Column
    private String tmId;
    @Column
    private String catalog3Id;
    @Column
    private String sku_defaultImg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpuId() {
        return spuId;
    }

    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuDesc() {
        return skuDesc;
    }

    public void setSkuDesc(String skuDesc) {
        this.skuDesc = skuDesc;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTmId() {
        return tmId;
    }

    public void setTmId(String tmId) {
        this.tmId = tmId;
    }

    public String getCatalog3Id() {
        return catalog3Id;
    }

    public void setCatalog3Id(String catalog3Id) {
        this.catalog3Id = catalog3Id;
    }

    public String getSku_defaultImg() {
        return sku_defaultImg;
    }

    public void setSku_defaultImg(String sku_defaultImg) {
        this.sku_defaultImg = sku_defaultImg;
    }
}
