package com.xuhu.cloud.controller;


import com.xuhu.cloud.utils.exception.BizException;
import com.xuhu.cloud.utils.result.Result;
import com.xuhu.cloud.utils.result.ResultEnum;
import com.xuhu.cloud.utils.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    public Result bizErrorHandler(HttpServletRequest req, BizException e) {
        log.error("cloud-consumer业务异常,reqMethod:{},URI:{},异常信息:{}", req.getMethod(), req.getRequestURI(), e.getErrMsg());
        return ResultUtil.error(e.getErrCode(), e.getErrMsg());
    }

    @ExceptionHandler(value = Throwable.class)
    public Object defaultErrorHandler(HttpServletRequest req, Throwable e) {
        log.error("cloud-consumer内部错误,reqMethod:{},URI:{},异常堆栈:{}", req.getMethod(),
                req.getRequestURI(), ExceptionUtils.getStackTrace(e));
        return ResultUtil.error(ResultEnum.FAIL.getCode(), String.format("内部错误,异常摘要:%s", e.getMessage()));
    }

}
