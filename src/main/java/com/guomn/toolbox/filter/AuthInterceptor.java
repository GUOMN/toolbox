package com.guomn.toolbox.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;


@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public static final Long TOKEN_EXPIRE = 15 * 24 * 60 * 60L;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String token = httpServletRequest.getHeader("token");
        String userID = httpServletRequest.getHeader("userID");


        // 参数校验
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(userID)) {
            log.info("auth failure：{}","token is empty!");
            return false;
         }

        boolean authResult = authContactToken(token, userID);
        if (!authResult) {
            log.info("auth failure：userID:{},token:{}", userID, token);
            return false;
        } else {
            return true;
        }

    }


    public boolean authContactToken(String token, String inputUserID) {

        boolean result = false;
        if (!redisTemplate.expire(token, TOKEN_EXPIRE, TimeUnit.SECONDS)) {
            return result;
        }

        if (!redisTemplate.hasKey(token)) {
            return result;
        }

        String userID = redisTemplate.opsForValue().get(token);
        if(inputUserID.equals(userID)){
            // 更新过期时间
            redisTemplate.opsForValue().set(token, userID, TOKEN_EXPIRE, TimeUnit.SECONDS);
            result = true;
        }
        return result;
    }
}
