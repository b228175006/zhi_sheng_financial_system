package com.bili.finacialSystem.service;

import com.bili.finacialSystem.entity.User;
import com.bili.utils.MD5Util;
import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

import java.security.MessageDigest;

import static org.junit.Assert.*;

/**
 * Created by bili on 2017/6/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {
    @Resource(name="UserService")
    private UserService userService;
    @Test
    public void findByUserNameLike() throws Exception {
        User user = userService.findByUserNameLike("admin");
        System.out.println("user = " + user);
    }

    @Test
    public void findById() throws Exception {
        User user = userService.findById("id");
        System.out.println("user = " + user);
    }

    @Test
    public void findByUserNameAndPassword() throws Exception {
        User user = userService.findByUserNameAndPassword("admin", MD5Util.toMD5("ZhiShengSXY"));
        System.out.println("user = " + user);
    }

    @Test
    public void delUser(){
        try {
            userService.delUser("123");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}