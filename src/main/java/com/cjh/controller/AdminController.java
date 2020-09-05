package com.cjh.controller;

import com.cjh.entity.Admin;
import com.cjh.utils.ResultMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/login")
    public ResultMap<String> login(Admin admin, HttpSession session,@RequestParam("code") String code){

        String codeInt = (String) session.getAttribute("codeInt");
        System.out.println("admin:"+admin+"---code："+code+"---codeInt："+codeInt);
        if(admin.getUserName().equals("cjh")&&admin.getPassWord().equals("666455")&&code.equals(codeInt)){
            session.setAttribute("admin_username",admin.getUserName());
            return new ResultMap<String>(0,"SUCCESS");
        }else{

            if((!admin.getUserName().equals("cjh"))){
                return new ResultMap<String>(0,"USER_ERROR");

            }else if((!admin.getPassWord().equals("666455"))){
                return new ResultMap<String>(0,"PASSWORD_ERROR");

            }
            return new ResultMap<String>(0,"CODE_ERROR");
        }

    }

    @GetMapping("/logout")
    public void logout(Admin admin, HttpSession session){
        session.removeAttribute("admin_username");
        session.invalidate();
    }


}
