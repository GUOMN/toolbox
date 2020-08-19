package com.guomn.toolbox.demo.Boss;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 2个有序数组，找交集
 * @author: 郭梦男
 * @create: 2020-08-15 08:12
 **/
public class Demo1 {
    public static Integer[] retainAll(int[] a, int[] b){
        Set<Integer> set = Arrays.stream(a).boxed()
                .collect(Collectors.toSet());
        Arrays.stream(b)
                .forEach(i -> {
                    if (!set.contains(Integer.valueOf(i))){
                        set.remove(Integer.valueOf(i));
                    }
                });
        List<Integer> result =  set.stream()
                .sorted()
                .collect(Collectors.toList());
        Integer[] c = new Integer[result.size()];
        return result.toArray(c);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = { 2, 4, 5, 6};
        Integer[] result = retainAll(a, b);
        for (Integer i : result) {
            System.out.println(i);
        }
    }

}
