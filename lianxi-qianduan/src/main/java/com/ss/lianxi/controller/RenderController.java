package com.ss.lianxi.controller;

import com.ss.lianxi.business.entity.User;
import com.ss.lianxi.business.service.SysUserService;
import com.ss.lianxi.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class RenderController {
    @Autowired
    private SysUserService userService;

    @GetMapping(value = {"", "/index"})
    public ModelAndView home() {
        return ResultUtil.view("index");
    }
    @GetMapping(value = {"/register"})
    public ModelAndView register() {
        return ResultUtil.view("register");
    }
    @GetMapping(value = {"/success"})
    public ModelAndView success() {
        return ResultUtil.view("success");
    }



    @PostMapping(value = "/zhuce")
    public ModelAndView zhuce(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        User user1 = userService.insert(user);
        if (user1 != null){
            return ResultUtil.redirect("index");
        }else
            return ResultUtil.view("register");
    }

    @PostMapping(value = "/login")
    public ModelAndView longin(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean b = userService.findUser(username, password);
        if (b){
            return ResultUtil.view("index");
        }else
            return ResultUtil.redirect("success");
    }

}
