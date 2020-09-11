package com.cjh.dao;

import com.cjh.entity.Admin;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

   Admin selectAdmin(Admin admin);

}
