package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    @Autowired
        UserService userService;
    @Test
    public void getUserinfoListAll() throws Exception {
        List<UserInfo> userinfoLis = userService.getUserinfoListAll();
        for (UserInfo userInfo:userinfoLis
             ) {
            System.out.println("UserInfo" + userInfo);
        }
    }
}