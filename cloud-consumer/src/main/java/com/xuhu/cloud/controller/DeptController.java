package com.xuhu.cloud.controller;

import com.xuhu.cloud.entities.Dept;
import com.xuhu.cloud.service.DeptService;
import com.xuhu.cloud.utils.exception.BizException;
import com.xuhu.cloud.utils.result.Result;
import com.xuhu.cloud.utils.result.ResultUtil;
import org.apache.commons.lang.StringUtils;
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
    public Result<Dept> getDept(@PathVariable String id){
        if (StringUtils.equals(id, "2001")) {
            throw new BizException("2001", "当前id数据不存在");
        }
        return ResultUtil.success(deptService.getDeptById(id));
    }

}
