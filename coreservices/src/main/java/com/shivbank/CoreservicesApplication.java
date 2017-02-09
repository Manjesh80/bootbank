package com.shivbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class CoreservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreservicesApplication.class, args);
    }

    @Bean
    public StartupRunner scheduleRunner() {
        return new StartupRunner();
    }

    @Bean
    public WarmupRunner warmUpRunner() {
        return new WarmupRunner();
    }

}
