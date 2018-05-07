package com.guomn.toolbox;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToolboxApplicationTests {

    @Test
    public void contextLoads() {
        String accessKeyId = "${sms.accessKeyId}";
        String accessKeySecret = "${sms.accessKeySecret}";
        System.out.println(accessKeyId);
        System.out.println(accessKeySecret);
    }

}
