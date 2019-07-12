package com.xuhu.cloud.utils.result;

public enum ResultEnum {
    SUCCESS("1000", "成功"),
    FAIL("2000", "失败");

    private String code;
    private String msg;


    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
