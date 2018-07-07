package com.hyfei.config;

import com.hyfei.dao.StuMapper;
import org.springframework.context.annotation.Configuration;

/**
 * 必须实现 StudentMapper(自定义),
 */
@Configuration
public class HystrixConfig implements StuMapper {

    @Override
    public String getStudent() {
        return "在调用student系统的getStudent()方法时,出现了异常";
    }
}
