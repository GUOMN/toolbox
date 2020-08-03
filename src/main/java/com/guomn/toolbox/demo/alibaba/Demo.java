package com.guomn.toolbox.demo.alibaba;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 秒杀系统，每天更新1000件货，每人每天最多三件
 * 考虑并发场景
 *
 * @author: 郭梦男
 * @create: 2020-08-03 20:01
 **/
public class Demo {
    private volatile AtomicInteger total = new AtomicInteger(1000);
    ConcurrentHashMap<String, Integer> countPerUser = new ConcurrentHashMap<>();

    /**
     * 下单
     */
    public boolean order(String userId){
        if (total.decrementAndGet() < 0){
            // 缺货
            return false;
        }

        if (countPerUser.containsKey(userId)){
            int cunt = countPerUser.get(userId);
            if (cunt > 3){
                // 超过限制
                return false;
            } else {
                countPerUser.put(userId, ++cunt);
            }
        } else {
            countPerUser.put(userId, 1);
        }
        return true;
    }

    /**
     * 每日定时初始化
     */
    @Scheduled(cron = "0 0 0 */1 * ?")
    private synchronized void initPerDay(){
        total = new AtomicInteger(total.get() + 1000);
        countPerUser.clear();
    }

}
