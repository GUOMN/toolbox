package com.guomn.toolbox.controller.guester;

import com.guomn.toolbox.mapper.SmsLogMapper;
import com.guomn.toolbox.pojo.SmsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HealthychkController {

    @Autowired
    private SmsLogMapper smsLogMapper;


    @GetMapping("/healthchk")
    public String helloworld() {
        return "helloworld";
    }

}
