package com.guomn.toolbox.demo.Boss;

import wiremock.org.eclipse.jetty.util.ConcurrentHashSet;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: 郭梦男
 * @create: 2020-08-15 09:06
 **/
public class Demo4 {
    // 被砍价用户 - 砍价次数
    Map<String, AtomicInteger> countOfUser = new ConcurrentHashMap<>();
    // userID -userID(被砍价用户-好友)
    Map<String, Set<String>> userRecord = new ConcurrentHashMap<>();

    public void countOn(String userId, String currentUserId){
        if (!countOfUser.containsKey(userId)){
            countOfUser.put(currentUserId, new AtomicInteger(0));
            userRecord.put(currentUserId, new ConcurrentHashSet<>());
        }
        if (countOfUser.get(userId).get() >= 10) {
            throw new RuntimeException("已经获得商品");
        }
        Set<String> set = userRecord.get(userId);
        if (set.contains(currentUserId)) {
            throw new RuntimeException("已经砍过价了");
        } else {
            set.add(currentUserId);
            countOfUser.getOrDefault(userId, new AtomicInteger(0)).incrementAndGet();
        }
    }
}
