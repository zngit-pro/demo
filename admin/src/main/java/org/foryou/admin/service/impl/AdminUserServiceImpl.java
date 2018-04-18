package org.foryou.admin.service.impl;

import org.foryou.admin.mapper.UserMapper;
import org.foryou.admin.service.AdminUserService;
import org.foryou.admin.vo.UserVo;
import org.foryou.dao.AdminUserEntity;
import org.foryou.jpa.AdminUserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserJpa userJpa;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserVo> list() {
        List<AdminUserEntity> userEntities = userJpa.findAll();
        return userMapper.getUserVos(userEntities);
    }
}
