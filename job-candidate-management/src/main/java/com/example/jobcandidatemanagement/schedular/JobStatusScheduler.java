package com.example.jobcandidatemanagement.schedular;

import java.time.LocalDateTime;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.jobcandidatemanagement.service.JobService;

@Component
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class JobStatusScheduler {

    private final JobService jobService;

    /**
     * Updates the status of job based on the conditions. This scheduler is managed using
     * cron expression. This scheduler will run every day at 1 o'clock and checks for
     * all jobs which are needed to be activated using {@code activateJobs()}
     *
     */
    @Scheduled(cron = "${activate.job.status.cron}")
    public void scheduleActivateJobStatus() {
        LocalDateTime localDateTime = LocalDateTime.now();
        //todo : log message when this scheduler is activated
        jobService.activateJobs();
    }

    /**
     * Updates the status of job based on the conditions. This scheduler is managed using
     * cron expression. This scheduler will run every day at 11 o'clock and checks for
     * all jobs which are needed to be activated using {@code activateJobs()}
     *
     */
    @Scheduled(cron = "${deactivate.job.status.cron}")
    public void scheduleDeactivateJobStatus() {
        LocalDateTime localDateTime = LocalDateTime.now();
        //todo : log message when this scheduler is activated
        jobService.deactivateJobs();
    }

}
