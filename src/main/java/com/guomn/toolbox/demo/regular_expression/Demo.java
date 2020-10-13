package com.guomn.toolbox.demo.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: 郭梦男
 * @create: 2020-10-10 18:11
 **/
public class Demo {
    public static void main(String[] args) {
        String content = "https://psolutioncos-1254389369.cos.ap-guangzhou.myqcloud.com/pSolution/cbb8c860b5524126ad45593a42f39a06/input32.zip";

        String pattern = "^https://(.*).cos.(.*).myqcloud.com(.*)$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(content);
        m.find();
        String bucket = m.group(1);
        String region = m.group(2);
        String key = m.group(3);

        System.out.println(bucket);
        System.out.println(region);
        System.out.println(key);
    }

}
