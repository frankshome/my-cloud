package com.xuhu.cloud.utils.result;

import lombok.Getter;

import java.io.Serializable;


@Getter
public final class Result<T> implements Serializable {

    private String status;
    private String code;
    private String errMsg;
    private T data;

    public Result() {
        this.status = ResultEnum.SUCCESS.name();
    }

    public Result(T data) {
        this.status = ResultEnum.SUCCESS.name();
        this.data = data;
    }

    public Result(ResultEnum status, String code, String errMsg) {
        this.status = status.name();
        this.code = code;
        this.errMsg = errMsg;
    }

    public void setStatus(ResultEnum status) {
        this.status = status.name();
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public void setData(T data) {
        this.data = data;
    }
}
