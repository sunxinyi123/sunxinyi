package com.example.text2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class Logincontroller {
    @RequestMapping("/user/login")

    public  String login(@RequestParam("username") String username,
                         @RequestParam("password")String password,
                         Model model, HttpSession session){//用于接受 model用于回显数据

        //具体业务
        if(!StringUtils.isEmpty("username")&&"123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";//用于跳转成功后显示main
        }else {
            //告诉用户登录失败
            model.addAttribute("msg","用户或者密码错误!");
            return "index";
        }


    }
}
