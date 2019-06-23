package com.xuhu.cloud.web;

import com.xuhu.cloud.entities.Dept;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeptController {

    @GetMapping("/getDept")
    public Object getDept(){
        Dept dept = new Dept();
        dept.setDeptName("test");
        return dept;
    }

}
