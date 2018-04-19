package org.foryou.admin.controller;

import org.foryou.admin.exception.AdminException;
import org.foryou.admin.vo.ResponseVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AdminException.class)
    @ResponseBody
    public ResponseVo<?> AdminExceptionHandler(AdminException e) {
        return new ResponseVo<>(ResponseVo.CodeType.FAIL, e.getMessage(), null);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseVo<?> baseErrorHandler(Exception e) {
        return new ResponseVo<>(ResponseVo.CodeType.SYSTEM_ERROR, e.getMessage(), null);
    }
}
