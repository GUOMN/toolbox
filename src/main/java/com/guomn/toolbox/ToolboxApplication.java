package com.guomn.toolbox;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.neo.mapper")
public class ToolboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolboxApplication.class, args);
    }
}
