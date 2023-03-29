package com.godofball.medtrack;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/godofball/medtrack/mapper")
public class MedTrackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedTrackApplication.class, args);
    }

}
