package com.cjh.dao;

import com.cjh.entity.Dept;
import com.cjh.entity.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptMapper {
   List<Dept> AllDept();


}
