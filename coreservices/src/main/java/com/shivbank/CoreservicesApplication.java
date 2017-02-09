package com.shivbank;

import com.shivbank.coreservicestarter.dbcount.DbCountRunner;
import com.shivbank.coreservicestarter.dbcount.EnableDbCounting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Collection;

@SpringBootApplication
@EnableScheduling
//@EnableDbCounting
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

   /* @Bean
    public DbCountRunner dbCountRunner(Collection<CrudRepository> repositories) {
        return new DbCountRunner(repositories) {
            @Override
            public void run(String... args) throws Exception {
                logger.info("Manually Declared DbCountRunner");
            }
        };
    }*/
}
