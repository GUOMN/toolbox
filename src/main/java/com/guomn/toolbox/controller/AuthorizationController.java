package com.guomn.toolbox.controller;


import com.guomn.toolbox.utils.Output;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class AuthorizationController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // token过期时间15天
    public static final Long TOKEN_EXPIRE = 15 * 24 * 60 * 60L;

    @PostMapping("/getContactToken")
    public Object getContactToken(HttpServletRequest request) {
        String userId = request.getHeader("userId");
        String passwd = request.getHeader("passwd");

        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(passwd)) {
            return Output.error("用户名或密码不正确");
        }

        if (true) {
            String token = UUID.randomUUID().toString();
            redisTemplate.opsForValue().set(token, userId, TOKEN_EXPIRE, TimeUnit.SECONDS);
            Map<String, String> data = new HashMap<>();
            data.put("token", token);
            data.put("userId", userId);
            return Output.success(data);
        } else {
            return Output.error("登陆发生错误");
        }
    }



    @GetMapping("/testAuth")
    public Object testAuth(HttpServletRequest request) {
        return Output.success("token校验通过");
    }
}
