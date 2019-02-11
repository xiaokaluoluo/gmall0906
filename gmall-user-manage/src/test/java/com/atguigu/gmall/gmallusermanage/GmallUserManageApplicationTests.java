package com.atguigu.gmall.gmallusermanage;

import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.bean.UserAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallUserManageApplicationTests {
    @Autowired
    UserService userService;
    @Test
    public void contextLoads() {
        List<UserAddress> userAddressList = userService.getUserAddressList("1");
        for (UserAddress userAddress:userAddressList
             ) {
            System.err.println("userAddress=" + userAddress);
        }
    }

}

