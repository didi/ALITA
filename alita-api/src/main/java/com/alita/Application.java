package com.alita;

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
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
