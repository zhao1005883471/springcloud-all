package com.hyfei.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 每0.1秒访问一次集群接口,重复5次还没有成功,启动熔断器
 */
@Configuration
public class FeignConfig {
    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(100,SECONDS.toMillis(1),5 );
    }

}
