package com.atguigu.gmall.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SpuSaleAttrValue implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String spuId;
    @Column
    private String saleAttrId;
    @Column
    private String saleAttrValueName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getspuId() {
        return spuId;
    }

    public void setspuId(String spuId) {
        this.spuId = spuId;
    }

    public String getsaleAttrId() {
        return saleAttrId;
    }

    public void setsaleAttrId(String saleAttrId) {
        this.saleAttrId = saleAttrId;
    }

    public String getsaleAttrValueName() {
        return saleAttrValueName;
    }

    public void setsaleAttrValueName(String saleAttrValueName) {
        this.saleAttrValueName = saleAttrValueName;
    }
}
