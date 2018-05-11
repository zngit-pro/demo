package org.foryou.admin.service.impl;

import org.foryou.admin.converter.UserConverter;
import org.foryou.admin.exception.UserException;
import org.foryou.admin.jpa.UserRepository;
import org.foryou.admin.mybatis.UserMapper;
import org.foryou.admin.service.UserService;
import org.foryou.admin.vo.UserVo;
import org.foryou.dao.ApiUserEntity;
import org.foryou.dao.Page;
import org.foryou.dao.Pageable;
import org.foryou.dao.QueryDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private UserMapper userMapper;

    @Cacheable(key = "#queryDate.cacheKey.concat(#pageable.page)", value = "exp10s")
    @Override
    public Page<UserVo> list(Pageable pageable, QueryDate queryDate) {
        Page<ApiUserEntity> pageinfo = new Page<>(pageable, userMapper.count(queryDate), userMapper.list(pageable, queryDate));
        return userConverter.getUserVos(pageinfo);
    }

    @Override
    public UserVo add(UserVo userVo) throws UserException {
        ApiUserEntity apiUserEntity = userRepository.findByAccount(userVo.getAccount());
        if (apiUserEntity == null) {
            apiUserEntity = userRepository.save(userConverter.getUserEntity(userVo));
            return userConverter.getUserVo(apiUserEntity);
        }
        throw new UserException("添加用户失败,已存在用户:" + userVo.getAccount());
    }

    @Override
    public void addAll(List<UserVo> userVo) {
        userRepository.saveAll(userConverter.getUserEntitys(userVo));
    }
}
