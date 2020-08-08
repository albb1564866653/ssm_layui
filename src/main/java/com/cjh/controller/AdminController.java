package com.cjh.controller;

import com.cjh.entity.Admin;
import com.cjh.utils.ResultMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/login")
    public ResultMap<String> login(Admin admin, HttpSession session){
        System.out.println("admin:"+admin);
        if(admin.getUserName().equals("cjh")&&admin.getPassWord().equals("666455")){
            session.setAttribute("admin_username",admin.getUserName());
            return new ResultMap<String>(0,"SUCCESS");
        }else{
            return new ResultMap<String>(0,"ERROR");
        }
    }

    @GetMapping("/logout")
    public void logout(Admin admin, HttpSession session){
        session.removeAttribute("admin_username");
        session.invalidate();
    }


}
