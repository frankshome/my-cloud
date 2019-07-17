package com.xuhu.cloud.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.xuhu.cloud.mapper")
public class MyBatisPlusConfig {

}
