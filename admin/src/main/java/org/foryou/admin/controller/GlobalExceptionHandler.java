package org.foryou.admin.controller;

import org.foryou.admin.exception.AdminException;
import org.foryou.admin.vo.ResponseVo;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AdminException.class)
    @ResponseBody
    public ResponseVo<?> AdminExceptionHandler(AdminException e) {
        return new ResponseVo<>(ResponseVo.CodeType.FAIL, e.getMessage(), null);
    }

    /**
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResponseVo<?> bindExceptionHandler(BindException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            String error = "参数:[" + fieldError.getField() + "]" + fieldError.getDefaultMessage();
            return new ResponseVo<>(ResponseVo.CodeType.PARAM_ERROR, error, null);
        }
        return new ResponseVo<>(ResponseVo.CodeType.PARAM_ERROR, e.getMessage(), e.getLocalizedMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseVo<?> baseErrorHandler(Exception e) {
        return new ResponseVo<>(ResponseVo.CodeType.SYSTEM_ERROR, e.getMessage(), null);
    }


}
