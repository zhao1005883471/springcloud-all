package com.hyfei.service;

import com.hyfei.dao.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HFService {
    @Autowired
    StuMapper stuMapper;

    public String getStu(){
        return stuMapper.getStudent();
    }
}
