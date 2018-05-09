package com.guomn.toolbox.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.guomn.toolbox.alicom.dysms.api.SmsDemo;
import com.guomn.toolbox.mapper.SmsLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.guomn.toolbox.pojo.*;

@RestController
@Slf4j
public class DySmsController {
    @Autowired
    private SmsLogMapper smsLogMapper;

    @GetMapping("/sendSms")
    public String sendSms(@Validated String toMobile, String message) {

        SmsLog dblog = new SmsLog();
        dblog.setLogContant(message);
        dblog.setToMobile(Long.valueOf(toMobile));
        try{
            SendSmsResponse result = SmsDemo.sendSms(toMobile, message);
            dblog.setSendStatus((byte) 1);
            dblog.setLogContant(dblog.getLogContant() + "==>resopnse:" +result.getMessage());
            log.info(result.getMessage());

            smsLogMapper.insert(dblog);
            return result.getMessage();
        }catch (ClientException e){
            dblog.setSendStatus((byte) 0);
            dblog.setLogContant(dblog.getLogContant() + e.getMessage());
            smsLogMapper.insert(dblog);
            return e.getMessage();
        }



    }

}
