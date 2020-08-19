package com.guomn.toolbox.demo.Boss;

/**
 * 2个有序数组，找交集
 * @author: 郭梦男
 * @create: 2020-08-15 08:12
 **/
public class Demo2 {
    public static char find(char[] a, char[] b) throws Exception {
        int index = 0;
        while(index <= Math.max(a.length, b.length)){
            if (a[index] != b[index]) {
                return a.length > b.length ? a[index] : b[index];
            }
            // 数组末尾
            if (index == Math.min(a.length, b.length) - 1) {
                return a.length > b.length ? a[index + 1] : b[index + 1];
            }
            index++;
        }
        throw new Exception("not found");
    }

    public static void main(String[] args) {
        char[] a = {'1', '2', '3', '4', '5'};
        char[] b = {'1', '2', '3', '4'};
        char result = 0;
        try {
            result = find(a, b);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("not found");
        }
    }

}
