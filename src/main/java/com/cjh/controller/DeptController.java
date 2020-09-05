package com.cjh.controller;

import com.cjh.entity.Dept;
import com.cjh.entity.Emp;
import com.cjh.service.DeptService;
import com.cjh.service.EmpService;
import com.cjh.utils.ResultMap;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/allDept")
    public ResultMap allDept(){

        List<Dept> depts = deptService.AllDept();

        return new ResultMap<List<Dept>> (0,"查询所有部门",depts,depts.size());
    }

}
