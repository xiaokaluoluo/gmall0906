package com.atguigu.gmall.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SpuSize implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String spuId;
    @Column
    private String spuSize;
    @Column
    private String isEnabled;

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

    public String getSpuSize() {
        return spuSize;
    }

    public void setSpuSize(String spuSize) {
        this.spuSize = spuSize;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }
}
