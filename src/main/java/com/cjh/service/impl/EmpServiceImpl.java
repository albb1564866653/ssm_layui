package com.cjh.service.impl;

import com.cjh.dao.EmpMapper;
import com.cjh.entity.Emp;
import com.cjh.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;


    @Override
    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }

    @Override
    public Integer updateEmp(Emp emp) {
        return empMapper.updateEmp(emp);
    }

    @Override
    public Integer addEmp(Emp emp) {
        return empMapper.addEmp(emp);
    }

    @Override
    public Integer deleteEmp(Integer empId) {
        return empMapper.deleteEmp(empId);
    }

    @Override
    public Integer batchDeletion(List<Integer> empIds) {
        return empMapper.batchDeletion(empIds);
    }
}
