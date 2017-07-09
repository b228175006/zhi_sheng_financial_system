package com.bili.finacialSystem.User.service;

import com.bili.finacialSystem.User.entity.User;
import com.bili.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

/**
 * Created by bili on 2017/6/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {
    @Resource(name="UserService")
    private UserRepository userRepository;
    @Test
    public void findByUserNameLike() throws Exception {
        User user = userRepository.findByUserNameLike("管理员");
        System.out.println("user = " + user);
    }

    @Test
    public void findById() throws Exception {
        User user = userRepository.findById("402880f55cba4057015cba40750a0000");
        System.out.println("user = " + user);
    }

    @Test
    public void findByUserNameAndPassword() throws Exception {
        User user = userRepository.findByUserNameAndPassword("admin", MD5Util.toMD5("888888"));
        System.out.println("user = " + user);
    }

    @Test
    public void delUser(){
        try {
            userRepository.delUser("123");
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
        userRepository.save(user);
    }

}