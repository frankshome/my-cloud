package com.xuhu.cloud.manager.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xuhu.cloud.entity.user.UserInfo;
import com.xuhu.cloud.manager.user.UserManager;
import com.xuhu.cloud.mapper.user.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getAllList(){
        return Optional.ofNullable(userInfoMapper.selectList(null)).orElse(Collections.emptyList());
    }

    @Override
    public List<UserInfo> queryListByName(String name) {
        return Optional.ofNullable(userInfoMapper.selectList(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getUserName, name).orderByDesc(UserInfo::getAge))).orElse(Collections.emptyList());
    }




}
