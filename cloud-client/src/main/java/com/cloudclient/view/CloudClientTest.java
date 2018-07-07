package com.cloudclient.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cloudClient")
public class CloudClientTest {

    @Value("${server.port}")
    private String port;

    @GetMapping("/test")
    public String test(){
        return "cloudClient test--port:"+port;
    }
}
