package com.xuhu.cloud.controller;

import com.xuhu.cloud.entities.Dept;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/deptProvider")
@RestController
public class DeptProvider {

    @Value("${port}")
    private Integer port;

    @GetMapping("/dept/{id}")
    public Dept getDept(@PathVariable("id") String id) {
        Dept dept = new Dept();
        dept.setId(id);
        dept.setDeptName("测试部门" + id);
        dept.setSource(port + "");

        return dept;
    }

}
