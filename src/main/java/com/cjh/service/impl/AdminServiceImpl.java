package com.cjh.service.impl;

import com.cjh.dao.AdminMapper;
import com.cjh.entity.Admin;
import com.cjh.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin selectAdmin(Admin admin) {
        return adminMapper.selectAdmin(admin);
    }
}
