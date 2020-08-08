package com.cjh.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class Interceptor {

    @PostMapping("/check")
    public String check(HttpSession session){
        String admin_username = (String) session.getAttribute("admin_username");
        System.out.println("拦截请求......（判断session是否为空：）."+admin_username);
        if(admin_username==null){
            return "NULL";
        }else{
            return admin_username;
        }
    }
}
