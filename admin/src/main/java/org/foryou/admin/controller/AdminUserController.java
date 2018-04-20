package org.foryou.admin.controller;

import com.github.pagehelper.PageInfo;
import org.foryou.admin.exception.UserException;
import org.foryou.admin.service.AdminUserService;
import org.foryou.admin.vo.ResponseVo;
import org.foryou.admin.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class AdminUserController {

    @Autowired
    private AdminUserService userService;

    @RequestMapping("list")
    public PageInfo<UserVo> list(int page) {
        PageInfo<UserVo> userVos = userService.list(page);
        return userVos;
    }

    @RequestMapping("add")
    public ResponseVo<?> add(UserVo userVo) throws UserException {
        return new ResponseVo<>(ResponseVo.CodeType.SUCCESS, userService.add(userVo));
    }
}
