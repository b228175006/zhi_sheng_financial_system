package com.bili.finacialSystem.web.filter;


import com.bili.finacialSystem.entity.User;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by bili on 2017/6/18.
 */
@Order(1)
@WebFilter(filterName = "isLoginFilter", urlPatterns = "/main/*")
public class IsLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            res.sendRedirect("/login.html");
        }

    }

    @Override
    public void destroy() {

    }
}
