package com.cjh.controller;

import com.cjh.entity.Admin;
import com.cjh.entity.Emp;
import com.cjh.service.EmpService;
import com.cjh.utils.ResultMap;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/list")
    public ResultMap list(@RequestParam(value = "page",defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "limit",defaultValue = "10") Integer limit){

        System.out.println("pageNum:"+pageNum);
        System.out.println("limit:"+limit);

        PageHelper.startPage(pageNum, limit);

        List<Emp> emps = empService.selectAll();

        System.out.println(emps);
        PageInfo<Emp> page = new PageInfo<>(emps);

        return new ResultMap<List<Emp>> (0,"查询所有员工信息",emps,(int)page.getTotal());
    }

    @PostMapping("/updateEmp")
    public ResultMap updateEmp(Emp emp){
        System.out.println("-----------------:"+emp);
        Integer result = empService.updateEmp(emp);
        if(result>0){
            return new ResultMap<String>(0,"修改员工信息","修改成功",result);
        }else{
            return new ResultMap<String>(0,"服务器异常","ERROR",result);
        }

    }

    @PostMapping("/addEmp")
    public ResultMap addEmp(Emp emp){
        System.out.println("-------add----------:"+emp);
        Integer result = empService.addEmp(emp);
        if(result>0){
            return new ResultMap<String>(0,"新增员工","添加成功",result);
        }else{
            return new ResultMap<String>(0,"服务器异常","ERROR",result);
        }

    }

    @PostMapping("/deleteEmp")
    public ResultMap deleteEmp(@RequestParam("empId") Integer empId){
        System.out.println("empId:"+empId);
        Integer result = empService.deleteEmp(empId);
        if(result>0){
            return new ResultMap<String>(0,"删除员工","删除成功",result);
        }else{
            return new ResultMap<String>(0,"服务器异常","ERROR",result);
        }

    }

    @PostMapping("/batchDeletion")
    public ResultMap batchDeletion(@RequestParam("empIds") String empIds){
        System.out.println("empIds:"+empIds);

        String[] empIds2 = empIds.split("-");
        List<Integer> empIds3=new ArrayList<>();

        for(String temp:empIds2){
            empIds3.add(Integer.parseInt(temp));
        }

        Integer result = empService.batchDeletion(empIds3);
        if(result>0){
            return new ResultMap<String>(0,"批量删除员工","删除成功",result);
        }else{
            return new ResultMap<String>(0,"服务器异常","ERROR",result);
        }

    }

}
