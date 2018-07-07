package com.configclient.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
//为需要及时更新读取的配置文件
//端口号为config客户端的端口号
//在更新完github中的文件后之后需要先发送post请求
//http://192.168.1.49:11006/actuator/bus-refresh
@RefreshScope
public class ConfigClient {
    @Value("${port}")
    private String port;

    @Value("${name}")
    private String name;

    @Value("${age}")
    private String age;

    @RequestMapping("/getConfig")
    public String test(){
        return "port:"+port+"--name:"+name+"--age:"+age;
    }
}
