package com.guomn.toolbox.controller.guester;

import com.guomn.toolbox.utils.KeyGenNew;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GenKeyController {

    @GetMapping("/getKey")
    public String sendSms(@Validated String name) {
        String out = KeyGenNew.key(name, (byte) 18);
	    return out;
    }

}
