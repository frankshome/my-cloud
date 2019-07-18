package com.xuhu.cloud.utils.result;

public final class ResultUtil {

    private ResultUtil() {
    }

    public static <T> Result<T> success(){
        Result<T> result = new Result<>();
        return result;
    }

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>(data);
        return result;
    }

    public static <T> Result<T> error(String code, String errMsg){
        Result<T> result = new Result<>(ResultEnum.FAIL, code, errMsg);
        return result;
    }
}
