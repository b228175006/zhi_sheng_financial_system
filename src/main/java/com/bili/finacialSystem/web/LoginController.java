package com.bili.finacialSystem.web;

import com.bili.finacialSystem.dto.RestMsg;
import com.bili.finacialSystem.entity.User;
import com.bili.finacialSystem.service.UserService;
import com.bili.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录登出控制器
 * Created by bili on 2017/6/17.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Resource(name = "UserService")
    private UserService userService;

    @RequestMapping(value = "/in",method = RequestMethod.GET)
    @ResponseBody
    public RestMsg login(HttpServletRequest req, HttpServletRequest res){
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            return new RestMsg("请输入用户名和密码",RestMsg.ERROR);
        }
        User user = userService.findByUserNameAndPassword(userName, MD5Util.toMD5(password));
        System.out.println("user = " + user);
        if(user == null){
            return new RestMsg("用户名或密码不正确",RestMsg.ERROR);
        }else {
            HttpSession session = res.getSession();
            session.setAttribute("user", user);
            return new RestMsg("登录成功", RestMsg.SUCCESS);
        }
    }
    @RequestMapping(value="/out",method = RequestMethod.GET)
    public String logout(HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession();
        if (session!=null){
            session = null;
        }
        return "/login.html";
    }
}
