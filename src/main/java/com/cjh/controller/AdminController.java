package com.cjh.controller;

import com.cjh.entity.Admin;
import com.cjh.service.AdminService;
import com.cjh.utils.Md5Encode;
import com.cjh.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResultMap<String> login(Admin admin, HttpSession session,@RequestParam("code") String code){

        String codeInt = (String) session.getAttribute("codeInt");
        //密码加密
        String encodePwd = Md5Encode.md5Encode(admin.getPassWord().getBytes());
        admin.setPassWord(encodePwd);
        System.out.println("admin-----------------"+admin);
        //密码加密后再进行数据库查询
        Admin selectAdmin = adminService.selectAdmin(admin);

        if(selectAdmin==null){
            return new ResultMap<String>(0,"ERROR");
        }
        if(!code.equals(codeInt)){
            return new ResultMap<String>(0,"CODE_ERROR");
        }

        session.setAttribute("admin_username",admin.getUserName());
        return new ResultMap<String>(0,"SUCCESS");


    }

    @GetMapping("/logout")
    public void logout(Admin admin, HttpSession session){
        session.removeAttribute("admin_username");
        session.invalidate();
    }


}
