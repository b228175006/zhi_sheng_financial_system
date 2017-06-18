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
import java.util.Date;

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
        User user = userService.findByUserNameLike("管理员");
        System.out.println("user = " + user);
    }

    @Test
    public void findById() throws Exception {
        User user = userService.findById("402880f55cba4057015cba40750a0000");
        System.out.println("user = " + user);
    }

    @Test
    public void findByUserNameAndPassword() throws Exception {
        User user = userService.findByUserNameAndPassword("admin", MD5Util.toMD5("888888"));
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

    @Test
    public void addUser(){
        User user = new User();
        user.setUserName("admin");
        user.setUserNikeName("管理员");
        user.setPassword(MD5Util.toMD5("888888"));
        user.setLastLoginTime(new Date());
        userService.save(user);
    }

}