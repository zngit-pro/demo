package org.foryou.admin.service;

import org.foryou.admin.vo.UserVo;

import java.util.List;

public interface AdminUserService {
    List<UserVo> list();

    UserVo add(UserVo userVo);
}
