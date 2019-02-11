package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.*;

import java.util.List;

public interface ManageService {
    public List<BaseCatalog1> getCatalog1();

    public List<BaseCatalog2> getCatalog2(String catalog1Id);

    public List<BaseCatalog3> getCatalog3(String catalog2Id);

    public List<BaseAttrInfo> getAttrList(String catalog3Id);

    public BaseAttrInfo getAttrInfo(String attrId);

    public void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    public void deleteAttrInfoId(String baseAttrInfoId);

    public List<SpuInfo> getSpuInfoList(SpuInfo spuInfo);

    public List<BaseSaleAttr> getBaseSaleAttrList();

    public void savaSpuInfo(SpuInfo spuInfo);

    public void deleteSpuInfoId(String spuInfoId);

    public List<SkuInfo> getskuInfoListBySpu(String spuId);

    public List<SpuImage> spuImageList(String spuId);

    public List<SpuSaleAttr> spuSaleAttrList(String spuId);
}
