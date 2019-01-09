package com.atguigu.gmall.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SpuVersion implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String spu_id;
    @Column
    private String spu_version;
    @Column
    private String is_enabled;

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

    public String getSpu_version() {
        return spu_version;
    }

    public void setSpu_version(String spu_version) {
        this.spu_version = spu_version;
    }

    public String getIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(String is_enabled) {
        this.is_enabled = is_enabled;
    }
}
