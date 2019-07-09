package com.xuhu.cloud.service.impl;

import com.xuhu.cloud.entities.Dept;
import com.xuhu.cloud.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Dept getDeptById(String id) {
        String url = "http://cloud-dept-provider/deptProvider/dept/" + id;
        log.info("请求的url={}", url);
        Dept dept = restTemplate.getForObject(url, Dept.class);
        return dept;
    }

}
