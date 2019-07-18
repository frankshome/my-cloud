package com.xuhu.cloud.utils.result;

import com.xuhu.cloud.utils.exception.BizException;

import java.util.Optional;

public final class ResultCheckUtil {
    private ResultCheckUtil(){

    }

    public static <T> T checkNotFail(Result<T> resp) {
        if (!ResultEnum.SUCCESS.name().equals(resp.getStatus())) {
            throw new BizException(String.format("errCode:%s,errMsg:%s", resp.getCode(), resp.getErrMsg()));
        } else {
            return resp.getData();
        }
    }

    public static <T> T checkNotFailAndNotNull(Result<T> resp) {
        return Optional.of(checkNotFail(resp)).orElseThrow(()
                -> new BizException(String.format("errCode:%s,errMsg:%s", resp.getCode(), resp.getErrMsg())));
    }

}
