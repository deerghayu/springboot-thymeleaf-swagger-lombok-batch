package com.example.thymeleaf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class ThymeleafApplication {

    private Logger LOG = LoggerFactory.getLogger(ThymeleafApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafApplication.class, args);
    }

    //Spring Scheduler Demo method, starts after 3 secs of app startup and repeats in every 2 secs
    //annotate with @EnableScheduling and you are done.
    @Scheduled(initialDelay = 3000, fixedDelay = 2000)
    public void takeAction(){
        LOG.info("Running a Scheduled task....");
    }

}
