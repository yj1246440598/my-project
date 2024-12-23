package com.enjoy;

import com.enjoy.config.Image;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.enjoy.mapper")
public class ApplicationMain implements CommandLineRunner{

    @Autowired
    private Image myConfig;
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(myConfig.getPath());
    }
}
