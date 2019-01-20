package com.atguigu.gmall.manage.controller;

import com.atguigu.gmall.bean.SpuInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SpuListPageController {
    @RequestMapping("spuList")
    public String spuList(){
        return "spuList";
    }
}
