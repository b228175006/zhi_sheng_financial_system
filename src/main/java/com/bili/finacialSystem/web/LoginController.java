package com.bili.finacialSystem.web;

import com.bili.finacialSystem.entity.User;
import com.bili.finacialSystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录登出控制器
 * Created by bili on 2017/6/17.
 */
@Controller
public class LoginController {
    @Resource(name = "UserService")
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(HttpServletRequest req,HttpServletRequest res){
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        User user = userService.findByUserNameAndPassword(userName,password);
        if(user == null){

        }
    }

}
