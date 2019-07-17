package com.xuhu.cloud.manager.user;

import com.xuhu.cloud.entity.user.UserInfo;

import java.util.List;

public interface UserManager {
    List<UserInfo> getAllList();

    List<UserInfo> queryListByName(String name);
}
