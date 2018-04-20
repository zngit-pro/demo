package org.foryou.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.foryou.admin.converter.UserConverter;
import org.foryou.admin.exception.UserException;
import org.foryou.admin.jpa.AdminUserJpa;
import org.foryou.admin.mybatis.UserMapper;
import org.foryou.admin.service.AdminUserService;
import org.foryou.admin.vo.UserVo;
import org.foryou.dao.AdminUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserJpa userJpa;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private UserMapper userMapper;
    private int size = 10;

    @Override
    public PageInfo<UserVo> list(int page) {
        PageHelper.startPage(page, size);
        PageInfo<AdminUserEntity> pageInfo =new PageInfo<>(userMapper.list(page));
        return userConverter.getUserVos(pageInfo);
    }

    @Override
    public UserVo add(UserVo userVo) throws UserException {
        AdminUserEntity userEntity = userJpa.findByAccount(userVo.getAccount());
        if (userEntity == null) {
            userEntity = userJpa.save(userConverter.getAdminUserEntity(userVo));
            return userConverter.getUserVo(userEntity);
        }
        throw new UserException("添加用户失败,已存在用户:" + userVo.getAccount());
    }


    @Override
    public void addAll(List<UserVo> userVo) {
        userJpa.saveAll(userConverter.getAdminUserEntitys(userVo));
    }
}
