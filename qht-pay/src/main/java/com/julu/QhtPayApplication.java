package com.julu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.julu.qht.mapper")
public class QhtPayApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(QhtPayApplication.class, args);
    }
    
}
