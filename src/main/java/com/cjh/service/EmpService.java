package com.cjh.service;

import com.cjh.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> selectAll();

    Integer updateEmp(Emp emp);

    Integer addEmp(Emp emp);

    Integer deleteEmp(Integer empId);

    Integer batchDeletion(List<Integer> empIds);
}
