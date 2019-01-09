package com.atguigu.gmall.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SpuSaleAttrValue implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String spu_id;
    @Column
    private String sale_attr_id;
    @Column
    private String sale_attr_value_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(String spu_id) {
        this.spu_id = spu_id;
    }

    public String getSale_attr_id() {
        return sale_attr_id;
    }

    public void setSale_attr_id(String sale_attr_id) {
        this.sale_attr_id = sale_attr_id;
    }

    public String getSale_attr_value_name() {
        return sale_attr_value_name;
    }

    public void setSale_attr_value_name(String sale_attr_value_name) {
        this.sale_attr_value_name = sale_attr_value_name;
    }
}
