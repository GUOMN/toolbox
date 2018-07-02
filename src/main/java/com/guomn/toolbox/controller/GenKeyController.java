package com.guomn.toolbox.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.guomn.toolbox.alicom.dysms.api.SmsDemo;
import com.guomn.toolbox.mapper.SmsLogMapper;
import com.guomn.toolbox.pojo.SmsLog;
import com.guomn.toolbox.utils.KeyGenNew;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GenKeyController {

    @GetMapping("/getKey")
    public String sendSms(@Validated String name) {
        return KeyGenNew.key(name,(byte) 14);
    }

}
