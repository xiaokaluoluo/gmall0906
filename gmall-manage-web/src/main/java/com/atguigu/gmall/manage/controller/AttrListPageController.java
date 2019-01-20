package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
public class AttrListPageController {
    @Reference
    ManageService manageService;

    @RequestMapping("attrListPage")
    public String attrListPage() {
        return "attrListPage";
    }

    // 获得一级分类
    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<BaseCatalog1> getCatalog1() {
        List<BaseCatalog1> catalog1List = manageService.getCatalog1();
        return catalog1List;
    }
    // 获得二级分类
    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<BaseCatalog2> getCatalog2(@RequestParam Map<String, String> map){
        String catalog1Id = map.get("catalog1Id");
        List<BaseCatalog2> catalog2List = manageService.getCatalog2(catalog1Id);
        return catalog2List;
    }
    // 获得三级分类
    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<BaseCatalog3> getCatalog3(@RequestParam Map<String, String> map){
        String catalog2Id = map.get("catalog2Id");
        List<BaseCatalog3> catalog3List = manageService.getCatalog3(catalog2Id);
        return catalog3List;
    }
    // 获得属性列表
    @RequestMapping("getAttrList")
    @ResponseBody
    public List<BaseAttrInfo> getAttrList(@RequestParam Map<String, String> map){
        String catalog3Id = map.get("catalog3Id");
        List<BaseAttrInfo> attrList = manageService.getAttrList(catalog3Id);
        return attrList;
    }
    // 获取属性值
    @RequestMapping(value = "getAttrValueList",method = RequestMethod.POST)
    @ResponseBody
    public List<BaseAttrValue> getAttrValue(@RequestParam Map<String,String> map){
        String attrId = map.get("attrId");
      BaseAttrInfo attrInfo = manageService.getAttrInfo(attrId);
      return attrInfo.getAttrValues();
    }
    // 保存属性值
    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(BaseAttrInfo baseAttrInfo){
        manageService.saveAttrInfo(baseAttrInfo);
        return "success";
    }
    // 删除
    @RequestMapping("deleteAttrInfoId")
    @ResponseBody
    public String deleteAttrInfoId(BaseAttrInfo baseAttrInfo){

        manageService.deleteAttrInfoId(baseAttrInfo.getId());
        return "success";
    }
}
