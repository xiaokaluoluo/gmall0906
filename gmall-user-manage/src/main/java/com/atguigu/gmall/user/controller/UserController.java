package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("userList")
    @ResponseBody
    public ResponseEntity<List<UserInfo>> userList() {
        List<UserInfo> userinfoListAll = userService.getUserinfoListAll();
        return ResponseEntity.ok(userinfoListAll);
    }
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ResponseEntity<Void> add(UserInfo userInfo){
        userService.addUser(userInfo);
        System.out.println("userInfo=" + userInfo);
        return  ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public ResponseEntity<Void> update(UserInfo userInfo){
        userService.updateUser(userInfo.getId(),userInfo);
        return  ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(UserInfo userInfo){
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<UserInfo> getUserInfo(UserInfo userInfoQuery){
        return  ResponseEntity.ok().body(new UserInfo());
    }
}
