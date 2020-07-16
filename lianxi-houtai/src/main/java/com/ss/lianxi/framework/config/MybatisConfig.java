package com.ss.lianxi.framework.config;

import org.springframework.stereotype.Component;
import tk.mybatis.spring.annotation.MapperScan;


@Component
@MapperScan("com.ss.lianxi.persistence.mapper")
public class MybatisConfig {
}
