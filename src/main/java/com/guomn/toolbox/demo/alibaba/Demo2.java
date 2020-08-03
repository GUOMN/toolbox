package com.guomn.toolbox.demo.alibaba;

import org.apache.commons.collections.map.HashedMap;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 数组求并集
 * @author: 郭梦男
 * @create: 2020-08-03 20:27
 **/
public class Demo2 {

    public static List<Integer> merge(int[]... arrays){
        Map<Integer, AtomicInteger> map = new HashedMap();
        for (int[] array: arrays) {
            for (int i : array) {
                map.getOrDefault(i, new AtomicInteger(1)).incrementAndGet();
            }
        }
        return map.entrySet().stream()
                .filter(entry -> entry.getValue().get() == arrays.length)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3}; // 444
        int[] b = {2, 3};
        int[] c = {2};
        System.out.println(merge(a, b, c));
    }
}
