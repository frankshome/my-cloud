package com.xuhu.cloud.controller;

import java.util.List;
import com.xuhu.cloud.entities.Dept;
import com.xuhu.cloud.entity.user.UserInfo;
import com.xuhu.cloud.manager.user.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/userProvider")
@RestController
public class UserProvider {

    @Autowired
    private UserManager userManager;

    @GetMapping("/user/{name}")
    public List<UserInfo> getDept(@PathVariable("name") String name) {
        return userManager.queryListByName(name);
    }


}
