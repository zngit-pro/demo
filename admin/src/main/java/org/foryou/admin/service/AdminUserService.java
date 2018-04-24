package org.foryou.admin.service;

import org.foryou.admin.exception.UserException;
import org.foryou.admin.vo.UserVo;
import org.foryou.dao.Page;
import org.foryou.dao.Pageable;
import org.foryou.dao.QueryDate;

import java.util.List;

public interface AdminUserService {
    Page<UserVo> list(Pageable pageable, QueryDate queryDate);

    UserVo add(UserVo userVo) throws UserException;

    void addAll(List<UserVo> userVo);
}
