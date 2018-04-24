package org.foryou.admin.controller;

import org.foryou.admin.exception.UserException;
import org.foryou.admin.service.AdminUserService;
import org.foryou.admin.vo.ResponseVo;
import org.foryou.admin.vo.UserVo;
import org.foryou.dao.Page;
import org.foryou.dao.Pageable;
import org.foryou.dao.QueryDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class AdminUserController {

    @Autowired
    private AdminUserService userService;

    @RequestMapping("list")
    public Page<UserVo> list(Pageable pageable, QueryDate queryDate) {
        Page<UserVo> userVos = userService.list(pageable, queryDate);
        return userVos;
    }

    @RequestMapping("add")
    public ResponseVo<?> add(UserVo userVo) throws UserException {
        return new ResponseVo<>(ResponseVo.CodeType.SUCCESS, userService.add(userVo));
    }
}
