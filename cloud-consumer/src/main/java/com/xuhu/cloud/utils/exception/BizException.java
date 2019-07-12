package com.xuhu.cloud.utils.exception;

import com.xuhu.cloud.utils.result.ResultEnum;

public class BizException extends RuntimeException {

    private String errCode;
    private String errMsg;

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    public BizException(String errMsg) {
        this.errCode = ResultEnum.FAIL.getCode();
        this.errMsg = errMsg;
    }


    public BizException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
