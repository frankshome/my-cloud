package com.xuhu.cloud.controller;

import java.util.List;
import com.xuhu.cloud.feignclient.UserInfoFeignClient;
import com.xuhu.cloud.modal.UserInfoDTO;
import com.xuhu.cloud.utils.result.Result;
import com.xuhu.cloud.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserInfoFeignClient userInfoFeignClient;

    @GetMapping("/list/{name}")
    public Result<List<UserInfoDTO>> getDept(@PathVariable String name){
        return ResultUtil.success(userInfoFeignClient.queryUserList(name));
    }

}
