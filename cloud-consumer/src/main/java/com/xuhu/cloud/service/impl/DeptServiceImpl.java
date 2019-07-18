package com.xuhu.cloud.service.impl;

import com.xuhu.cloud.modal.DeptDTO;
import com.xuhu.cloud.service.DeptService;
import com.xuhu.cloud.utils.result.Result;
import com.xuhu.cloud.utils.result.ResultCheckUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @Cacheable(value = "dept", key = "#id")
    public DeptDTO getDeptById(String id) {
        String url = "http://cloud-provider/deptProvider/dept/" + id;
        log.info("请求的url={}", url);

        Result<DeptDTO> result = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<Result<DeptDTO>>() {
                }).getBody();

        return ResultCheckUtil.checkNotFail(result);
    }

}
