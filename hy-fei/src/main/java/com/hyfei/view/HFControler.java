package com.hyfei.view;

import com.hyfei.service.HFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hf")
public class HFControler {

    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String name;

    @Autowired
    HFService hfService;

    @RequestMapping("/test")
    public String test(){
        return "负载-熔断--port:"+port+"--name:"+name;
    }

    @RequestMapping("test2")
    public String test2(){
        return hfService.getStu();
    }
}
