package com.xuhu.cloud.controller;

import com.xuhu.cloud.modal.DeptDTO;
import com.xuhu.cloud.utils.exception.BizException;
import com.xuhu.cloud.utils.result.Result;
import com.xuhu.cloud.utils.result.ResultUtil;
import org.apache.commons.lang3.StringUtils;
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
    public Result<DeptDTO> getDept(@PathVariable("id") String id) {
        DeptDTO deptDTO = new DeptDTO();
        deptDTO.setId(id);
        deptDTO.setDeptName("测试部门" + id);
        deptDTO.setSource(port + "");

        if (StringUtils.equals(id, "500")) {
            throw new BizException("5001", "该部门信息异常");
        }

        return ResultUtil.success(deptDTO);
    }

}
