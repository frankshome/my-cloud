package com.xuhu.cloud.controller;

import com.xuhu.cloud.entities.Dept;
import com.xuhu.cloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/dept")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/getDept/{id}")
    public Object getDept(@PathVariable String id){
        return deptService.getDeptById(id);
    }

}
