package com.alita.mysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-11-07 20:11:51
 */
@SpringBootApplication
@MapperScan("com.alita.mysql.mapper")
public class ApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTest.class, args);
    }

}
