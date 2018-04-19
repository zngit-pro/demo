package org.foryou.admin.service.impl;

import org.foryou.admin.exception.UserException;
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

    @Override
    public UserVo add(UserVo userVo) throws UserException {
        AdminUserEntity userEntity = userJpa.findByAccount(userVo.getAccount());
        if (userEntity == null) {
            userEntity = userJpa.save(userMapper.getAdminUserEntity(userVo));
            return userMapper.getUserVo(userEntity);
        }
        throw new UserException("添加用户失败,已存在用户:" + userVo.getAccount());
    }
}
