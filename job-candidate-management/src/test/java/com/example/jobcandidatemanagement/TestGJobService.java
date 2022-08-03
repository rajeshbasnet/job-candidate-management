package com.example.jobcandidatemanagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.jobcandidatemanagement.entity.Job;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jobcandidatemanagement.constant.Availability;
import com.example.jobcandidatemanagement.constant.JobStatus;
import com.example.jobcandidatemanagement.dto.JobDto;
import com.example.jobcandidatemanagement.service.JobService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestGJobService {

    @Autowired
    private JobService jobService;

    @Test
    @Order(1)
    public void testSaveJobsForCompany() {
        int companyId = 1;
        int categoryId = 1;

        List<JobDto> jobDtoList = new ArrayList<>();
        jobDtoList.add(JobDto.builder()
                .position("Senior Developer")
                .numOfEmployeeRequired(50)
                .offeredSalary(60000)
                .availability(Availability.FULL_TIME)
                .description("Lorme ispum")
                .startDate(LocalDate.now())
                .endDate(LocalDate.of(2022, 7, 29))
                .build());
        jobDtoList.add(JobDto.builder()
                .position("Mid-Level Laravel Developer")
                .numOfEmployeeRequired(50)
                .offeredSalary(40000)
                .availability(Availability.FULL_TIME)
                .description("Lorem ipsum")
                .startDate(LocalDate.now())
                .endDate(LocalDate.of(2022, 7, 29))
                .build());
        jobDtoList.add(JobDto.builder()
                .position("Internship")
                .numOfEmployeeRequired(50)
                .offeredSalary(5000)
                .availability(Availability.FULL_TIME)
                .description("Lorem ipsum")
                .startDate(LocalDate.now())
                .endDate(LocalDate.of(2022, 7, 29))
                .build());
        jobDtoList.add(JobDto.builder()
                .position("Junior Developer")
                .numOfEmployeeRequired(1)
                .offeredSalary(20000)
                .availability(Availability.PART_TIME)
                .description("Lorem ipsum")
                .startDate(LocalDate.of(2022, 7, 29))
                .endDate(LocalDate.of(2022, 7, 31))
                .build());

        Assertions.assertDoesNotThrow(() -> jobService.saveJobsForCompany(companyId, categoryId, jobDtoList));
    }


    @Test
    @Order(2)
    public void testUpdateJobStatusForJob() {
        int jobId = 2;
        Assertions.assertDoesNotThrow(() -> jobService.updateJobStatusForJob(jobId, JobStatus.ACTIVE));
    }

    @Test
    @Order(3)
    public void testGetAllActiveJobs() {
        List<JobDto> jobDtoList = jobService.getAllActiveJobs();
        System.out.println(jobDtoList);
        Assertions.assertTrue(jobDtoList.size() > 0);
    }

    @Test
    @Order(4)
    public void testActivateJobs() {
        jobService.activateJobs();
    }

    @Test
    @Order(5)
    public void testDeactivateJobs() {
        jobService.deactivateJobs();
    }


    @Test
    @Order(5)
    public void testGetAllJobsByStatusOfCompany() {
        int companyId = 1;
        List<JobDto> jobList = jobService.getAllJobsByStatusOfCompany(companyId, JobStatus.INACTIVE);
        System.out.println(jobList);
        Assertions.assertTrue(jobList.size() > 0);
    }
}
