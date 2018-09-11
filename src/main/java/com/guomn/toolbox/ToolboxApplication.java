package com.guomn.toolbox;

import com.guomn.toolbox.alicom.acm.ACMProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.neo.mapper")
@EnableConfigurationProperties
public class ToolboxApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ToolboxApplication.class);
    }

    public static void main(String[] args) {
        ACMProperties.init();

        SpringApplication.run(ToolboxApplication.class, args);
    }
}
