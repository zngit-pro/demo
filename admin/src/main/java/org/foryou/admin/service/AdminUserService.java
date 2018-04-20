package org.foryou.admin.service;

import com.github.pagehelper.PageInfo;
import org.foryou.admin.exception.UserException;
import org.foryou.admin.vo.UserVo;

import java.util.List;

public interface AdminUserService {
    PageInfo<UserVo> list(int page);

    UserVo add(UserVo userVo) throws UserException;

    void addAll(List<UserVo> userVo);
}
