package com.oukele.myspringbootproject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.oukele.myspringbootproject.dao")//扫描接口
public class MySpringbootProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringbootProjectApplication.class, args);
    }

}

