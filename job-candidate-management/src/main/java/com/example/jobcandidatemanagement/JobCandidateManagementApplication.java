package com.example.jobcandidatemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JobCandidateManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobCandidateManagementApplication.class, args);
    }
}
