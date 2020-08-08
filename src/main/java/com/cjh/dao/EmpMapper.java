package com.cjh.dao;

import com.cjh.entity.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpMapper {
   List<Emp> selectAll();

   Integer updateEmp(Emp emp);

   Integer addEmp(Emp emp);

   Integer deleteEmp(Integer empId);

   Integer batchDeletion(List<Integer> empIds);
}
