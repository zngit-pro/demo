package org.foryou.admin.controller;

import org.foryou.admin.service.AdminUserService;
import org.foryou.admin.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class AdminUserController {

    @Autowired
    private AdminUserService userService;

    @RequestMapping("list")
    public List<UserVo> list() {
        return userService.list().subList(0,1);
    }
}
