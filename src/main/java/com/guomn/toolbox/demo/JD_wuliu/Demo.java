package com.guomn.toolbox.demo.JD_wuliu;

import java.util.ArrayList;
import java.util.List;

/**
 给定一行数字，按如下例子的规律，返回下一行
 **
*-----------------
        1
        1 1
        2 1
        1 2 1 1
        1 1 1 2 2 1
        3 1 2 2 1 1
        */
/**
 *
 * @author: 郭梦男
 * @create: 2020-08-08 12:32
 **/
public class Demo {
    public static void main(String[] args) {
        int[] array = {1, 3, 1, 2, 2, 1, 4, 5, 5};
        List<Integer[]> result = new ArrayList<>();
        int lastOne = 0;
        int count = 1;

        for (int number : array) {
            if (lastOne == number) {
                ++count;
                continue;
            } else if(lastOne != 0){
                result.add(new Integer[]{count, lastOne});
                count = 1;
            }
            lastOne = number;
        }
        result.add(new Integer[]{count, lastOne});

        StringBuilder output = new StringBuilder();
        result.stream()
                .map(a -> a[0] + "" + a[1])
                .forEach(output::append);
        System.out.println(output.toString());
    }
}
