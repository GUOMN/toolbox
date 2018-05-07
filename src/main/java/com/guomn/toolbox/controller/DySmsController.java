package com.guomn.toolbox.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.guomn.toolbox.alicom.dysms.api.SmsDemo;
import com.guomn.toolbox.mapper.SmsLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.guomn.toolbox.pojo.*;

@RestController

public class DySmsController {
    @Autowired
    private SmsLogMapper smsLogMapper;

    @GetMapping("/sendSms")
    public String sendSms(@Validated String toMobile, String message) {
        try{
            SendSmsResponse result = SmsDemo.sendSms(toMobile, message);
            smsLogMapper.insert(new SmsLog());
        }catch (ClientException e){
            return e.getMessage();

        }

        return "success";
    }

}
