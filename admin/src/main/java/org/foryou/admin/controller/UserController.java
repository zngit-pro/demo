package org.foryou.admin.controller;

import org.foryou.admin.exception.UserException;
import org.foryou.admin.service.UserService;
import org.foryou.admin.vo.ResponseVo;
import org.foryou.admin.vo.UserVo;
import org.foryou.dao.Pageable;
import org.foryou.dao.QueryDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public ResponseVo<?> list(Pageable pageable, QueryDate queryDate) {
        return new ResponseVo<>(ResponseVo.CodeType.SUCCESS, userService.list(pageable, queryDate));
    }

    @RequestMapping("add")
    public ResponseVo<?> add(UserVo userVo) throws UserException {
        return new ResponseVo<>(ResponseVo.CodeType.SUCCESS, userService.add(userVo));
    }
}
