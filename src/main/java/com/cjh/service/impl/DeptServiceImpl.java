package com.cjh.service.impl;

import com.cjh.dao.DeptMapper;
import com.cjh.dao.EmpMapper;
import com.cjh.entity.Dept;
import com.cjh.entity.Emp;
import com.cjh.service.DeptService;
import com.cjh.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;


    @Override
    public List<Dept> AllDept() {
        return deptMapper.AllDept();
    }
}
