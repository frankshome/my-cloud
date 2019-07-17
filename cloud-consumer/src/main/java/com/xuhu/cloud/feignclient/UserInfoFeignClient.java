package com.xuhu.cloud.feignclient;

import java.util.List;
import com.xuhu.cloud.modal.UserInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("cloud-provider")
public interface UserInfoFeignClient {

    /**
     * queryUserList
     * @param name
     * @return
     */
    @GetMapping("/userProvider/user/list/{name}")
    List<UserInfoDTO> queryUserList(@PathVariable("name") String name);

}
