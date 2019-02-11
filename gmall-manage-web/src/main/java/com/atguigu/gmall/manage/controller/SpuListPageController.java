package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.manage.util.ManageUploadUtil;
import com.atguigu.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
public class SpuListPageController {

    @Reference
    ManageService manageService;


    // 根据三级分类id显示数据
    @RequestMapping("spuList")
    @ResponseBody
    public List<SpuInfo> getSpuInfoList(@RequestParam Map<String,String> map){
        String catalog3Id = map.get("catalog3Id");
        SpuInfo spuInfo = new SpuInfo();
        spuInfo.setCatalog3Id(catalog3Id);
       List<SpuInfo> spuInfoList = manageService.getSpuInfoList(spuInfo);
        return spuInfoList;
    }

    // 查询销售属性信息baseSaleAttrList
    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<BaseSaleAttr> baseSaleAttrList(){
        List<BaseSaleAttr> baseSaleAttrList = manageService.getBaseSaleAttrList();
        return baseSaleAttrList;
    }
    // 保存spu
    @RequestMapping("saveSpu")
    @ResponseBody
    public String saveSpu(SpuInfo spuInfo){
        manageService.savaSpuInfo(spuInfo);
        return "success";
    }
    // 图片上传返回地址
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){

        // 调用上传工具
       String imgUrl = ManageUploadUtil.imgUpolad(multipartFile);
        return imgUrl;
    }
    // 删除
    @RequestMapping("deleteSpuInfoId")
    @ResponseBody
    public String deleteSpuInfoId(SpuInfo spuInfo){

       manageService.deleteSpuInfoId(spuInfo.getId());
        return "success";
    }
    // 根据spu获取sku 列表
    @RequestMapping("skuInfoListBySpu")
    @ResponseBody
    public List<SkuInfo> getskuInfoListBySpu(String spuId){
        List<SkuInfo> skuInfos = manageService.getskuInfoListBySpu(spuId);
        return  skuInfos;
    }
    // sku保存
    @RequestMapping("saveSku")
    @ResponseBody
    public String saveSku(SkuInfo skuInfo){

        return  "success";
    }
    // 根据spuid获取spu属性列表详情
    @RequestMapping("spuSaleAttrList")
    @ResponseBody
    public List<SpuSaleAttr> spuSaleAttrList(String spuId){
        List<SpuSaleAttr> spuSaleAttrs = manageService.spuSaleAttrList(spuId);
        return spuSaleAttrs;
    }

}
