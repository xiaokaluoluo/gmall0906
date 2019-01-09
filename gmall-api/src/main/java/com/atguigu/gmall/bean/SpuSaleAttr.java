package com.atguigu.gmall.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SpuSaleAttr implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String spuId;
    @Column
    private String sale_attrId;
    @Column
    private String saleAttrName;

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

    public String getSale_attrId() {
        return sale_attrId;
    }

    public void setSale_attrId(String sale_attrId) {
        this.sale_attrId = sale_attrId;
    }

    public String getSaleAttrName() {
        return saleAttrName;
    }

    public void setSaleAttrName(String saleAttrName) {
        this.saleAttrName = saleAttrName;
    }
}
