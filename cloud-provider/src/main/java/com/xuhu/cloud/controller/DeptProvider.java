package com.xuhu.cloud.controller;

import com.xuhu.cloud.modal.DeptDTO;
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
    public DeptDTO getDept(@PathVariable("id") String id) {
        DeptDTO deptDTO = new DeptDTO();
        deptDTO.setId(id);
        deptDTO.setDeptName("测试部门" + id);
        deptDTO.setSource(port + "");

        return deptDTO;
    }

}
