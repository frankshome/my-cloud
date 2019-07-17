package com.xuhu.cloud.controller;

import com.xuhu.cloud.entity.user.UserInfo;
import com.xuhu.cloud.manager.user.UserManager;
import com.xuhu.cloud.modal.UserInfoDTO;
import com.xuhu.cloud.utils.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RequestMapping("/userProvider")
@RestController
public class UserProvider {

    @Autowired
    private UserManager userManager;

    @GetMapping("/user/list/{name}")
    public List<UserInfoDTO> queryUserList(@PathVariable("name") String name) {
        List<UserInfo> list = userManager.queryListByName(name);
        List<UserInfoDTO> dtoList = list.stream().map(e -> convertWith(e, UserInfoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    private <T, E> E convertWith(T sourceObj, Class<E> targetClz) {
        E targetObj = null;
        try {
            targetObj = targetClz.newInstance();
            BeanUtils.copyProperties(sourceObj, targetObj);
        } catch (Exception e) {
            log.error("类型转换异常,原对象class:{},目标对象class:{},异常:{}", sourceObj.getClass(), targetClz, ExceptionUtils.getStackTrace(e));
            throw new BizException(String.format("类型转换异常%s->%s", sourceObj.getClass().getSimpleName(), targetClz.getSimpleName()));
        }
        return targetObj;
    }

}
