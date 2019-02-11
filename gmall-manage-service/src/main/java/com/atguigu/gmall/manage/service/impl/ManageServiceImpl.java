package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.manage.mapper.*;
import com.atguigu.gmall.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;

@Service()
public class ManageServiceImpl implements ManageService {
    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;
    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;
    @Autowired
    BaseCatalog1Mapper baseCatalog1Mapper;
    @Autowired
    BaseCatalog2Mapper baseCatalog2Mapper;
    @Autowired
    BaseCatalog3Mapper baseCatalog3Mapper;
    @Autowired
    SpuInfoMapper spuInfoMapper;
    @Autowired
    BaseSaleAttrMapper baseSaleAttrMapper;
    @Autowired
    SpuSaleAttrMapper spusaleAttrMapper;
    @Autowired
    SpuSaleAttrValueMapper spuSaleAttrValueMapper;
    @Autowired
    SpuImageMapper spuImageMapper;
    @Autowired
    SkuInfoMapper skuInfoMapper;
    @Override
    public List<BaseCatalog1> getCatalog1() {
        List<BaseCatalog1> baseCatalog1List = baseCatalog1Mapper.selectAll();
        return baseCatalog1List;
    }

    @Override
    public List<BaseCatalog2> getCatalog2(String catalog1Id) {
        BaseCatalog2 baseCatalog2 = new BaseCatalog2();
        baseCatalog2.setCatalog1Id(catalog1Id);
        List<BaseCatalog2> baseCatalog2List = baseCatalog2Mapper.select(baseCatalog2);
        return baseCatalog2List;
    }

    @Override
    public List<BaseCatalog3> getCatalog3(String catalog2Id) {
        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setCatalog2Id(catalog2Id);
        List<BaseCatalog3> baseCatalog3List = baseCatalog3Mapper.select(baseCatalog3);
        return baseCatalog3List;
    }

    @Override
    public List<BaseAttrInfo> getAttrList(String catalog3Id) {
        BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
        baseAttrInfo.setCatalog3Id(catalog3Id);

        List<BaseAttrInfo> baseAttrInfoList = baseAttrInfoMapper.select(baseAttrInfo);
        for (BaseAttrInfo attrInfo : baseAttrInfoList) {
            List<BaseAttrValue> baseAttrValues = new ArrayList<>();

            BaseAttrValue baseAttrValue = new BaseAttrValue();
            baseAttrValue.setAttrId(attrInfo.getId());

            baseAttrValues = baseAttrValueMapper.select(baseAttrValue);
            attrInfo.setAttrValues(baseAttrValues);
        }

        return baseAttrInfoList;
    }

    @Override
    public BaseAttrInfo getAttrInfo(String id) {
        // 查询基本信息
        BaseAttrInfo baseAttrInfo = baseAttrInfoMapper.selectByPrimaryKey(id);
        // 查询属性值
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(baseAttrInfo.getId());
        List<BaseAttrValue> baseAttrValues = baseAttrValueMapper.select(baseAttrValue);
        baseAttrInfo.setAttrValues(baseAttrValues);
        return baseAttrInfo;
    }

    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        //如果有主键就进更新，如果没有就插入
        if (baseAttrInfo.getId() != null && baseAttrInfo.getId().length() > 0) {
            baseAttrInfoMapper.updateByPrimaryKey(baseAttrInfo);
        } else {
            //防止主键被赋上一个空字符串
            if (baseAttrInfo.getId().length() == 0) {
                baseAttrInfo.setId(null);
            }
            baseAttrInfoMapper.insertSelective(baseAttrInfo);
        }
        //把原属性值全部清空
        BaseAttrValue baseAttrValue4Del = new BaseAttrValue();
        baseAttrValue4Del.setAttrId(baseAttrInfo.getId());
        baseAttrValueMapper.delete(baseAttrValue4Del);

        //重新插入属性
        if (baseAttrInfo.getAttrValues() != null && baseAttrInfo.getAttrValues().size() > 0) {
            for (BaseAttrValue attrValue : baseAttrInfo.getAttrValues()) {
                //防止主键被赋上一个空字符串
                if (attrValue.getId() != null && attrValue.getId().length() == 0) {
                    attrValue.setId(null);
                }
                attrValue.setAttrId(baseAttrInfo.getId());
                baseAttrValueMapper.insertSelective(attrValue);
            }
        }
    }

    @Override
    public void deleteAttrInfoId(String baseAttrInfoId) {

        if (baseAttrInfoId != null && baseAttrInfoId.length() > 0) {
            baseAttrInfoMapper.deleteByPrimaryKey(baseAttrInfoId);
            BaseAttrValue baseAttrValue = new BaseAttrValue();
            baseAttrValue.setAttrId(baseAttrInfoId);
            baseAttrValueMapper.delete(baseAttrValue);
        }
    }

    @Override
    public List<SpuInfo> getSpuInfoList(SpuInfo spuInfo) {
        List<SpuInfo> spuInfoList = spuInfoMapper.select(spuInfo);
        return spuInfoList;

    }

    @Override
    public List<BaseSaleAttr> getBaseSaleAttrList() {
        List<BaseSaleAttr> baseSaleAttrs = baseSaleAttrMapper.selectAll();
        return baseSaleAttrs;
    }

    @Override
    public void savaSpuInfo(SpuInfo spuInfo) {
        //保存主表 通过主键判断修改还是新增
        if (spuInfo.getId() == null || spuInfo.getId().length() == 0) {
            spuInfo.setId(null);
            spuInfoMapper.insertSelective(spuInfo);
        } else {
            spuInfoMapper.updateByPrimaryKey(spuInfo);
        }

        // 报损图片信息

        List<SpuImage> spuImageList = spuInfo.getSpuImageList();
        if (spuImageList != null){
            for (SpuImage spuImage : spuImageList){
                if (spuImage.getId() != null && spuImage.getId().length() == 0){
                        spuImage.setId(null);
                }
                spuImage.setSpuId(spuInfo.getId());
                spuImageMapper.insertSelective(spuImage);
            }
        }

        // 保存销售属性信息
        List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();
        if (spuSaleAttrList != null) {
            for (SpuSaleAttr spusaleAttr : spuSaleAttrList) {
                if (spusaleAttr.getId() != null && spusaleAttr.getId().length() == 0) {
                    spusaleAttr.setId(null);
                }
                spusaleAttr.setSpuId(spuInfo.getId());
                spusaleAttrMapper.insertSelective(spusaleAttr);
                List<SpuSaleAttrValue> spuSaleAttrValueList = spusaleAttr.getSpuSaleAttrValueList();
                for (SpuSaleAttrValue spusaleAttrValue : spuSaleAttrValueList) {
                    if (spusaleAttrValue.getId() != null && spusaleAttrValue.getId().length() == 0) {
                        spusaleAttrValue.setId(null);
                    }
                    spusaleAttrValue.setspuId(spuInfo.getId());
                    spuSaleAttrValueMapper.insertSelective(spusaleAttrValue);
                }
            }
        }
    }
    // 根据spuid删除spu
    @Override
    public void deleteSpuInfoId(String spuInfoId) {
        if (spuInfoId != null && spuInfoId.length() > 0) {
            spuInfoMapper.deleteByPrimaryKey(spuInfoId);
           SpuSaleAttr spuSaleAttr = new SpuSaleAttr();
           spuSaleAttr.setSpuId(spuInfoId);
            spusaleAttrMapper.delete(spuSaleAttr);
            SpuSaleAttrValue spuSaleAttrValue = new SpuSaleAttrValue();
            spuSaleAttrValue.setspuId(spuInfoId);
            spuSaleAttrValueMapper.delete(spuSaleAttrValue);
            SpuImage spuImage = new SpuImage();
            spuImage.setSpuId(spuInfoId);
            spuImageMapper.delete(spuImage);
        }
    }

    @Override
    public List<SkuInfo> getskuInfoListBySpu(String spuId) {
        SkuInfo skuInfo = new SkuInfo();
        skuInfo.setSpuId(spuId);
        List<SkuInfo> skuInfos = skuInfoMapper.select(skuInfo);
        return skuInfos;
    }

    @Override
    public List<SpuImage> spuImageList(String spuId) {
        SpuImage spuImage = new SpuImage();
        spuImage.setSpuId(spuId);
        List<SpuImage> spuImages = spuImageMapper.select(spuImage);
        return spuImages;
    }

    @Override
    public List<SpuSaleAttr> spuSaleAttrList(String spuId) {
        SpuSaleAttr spuSaleAttr = new SpuSaleAttr();
        spuSaleAttr.setSpuId(spuId);
        List<SpuSaleAttr> spuSaleAttrs = spusaleAttrMapper.select(spuSaleAttr);
        for (SpuSaleAttr saleAttr : spuSaleAttrs){
            SpuSaleAttrValue spuSaleAttrValue = new SpuSaleAttrValue();
            spuSaleAttrValue.setspuId(spuId);
            spuSaleAttrValue.setsaleAttrId(saleAttr.getSaleAttrId());
            List<SpuSaleAttrValue> spuSaleAttrValues = spuSaleAttrValueMapper.select(spuSaleAttrValue);
            saleAttr.setSpuSaleAttrValueList(spuSaleAttrValues);
        }
        return spuSaleAttrs;
    }
}
