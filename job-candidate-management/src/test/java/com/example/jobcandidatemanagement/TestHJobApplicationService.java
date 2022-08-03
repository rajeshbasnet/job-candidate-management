package com.example.jobcandidatemanagement;

import java.util.List;

import com.example.jobcandidatemanagement.dto.ApplicantDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jobcandidatemanagement.constant.ApplicationStatus;
import com.example.jobcandidatemanagement.dto.JobDto;
import com.example.jobcandidatemanagement.service.JobApplicationService;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestHJobApplicationService {

    @Autowired
    private JobApplicationService jobApplicationService;

    @Test
    @Order(1)
    public void testApplyForJobs() {
        int applicantId = 1000;
        int jobId = 1;
        jobApplicationService.applyForJobs(applicantId, jobId);
    }

    @Test
    @Order(2)
    public void testGetAllApplicantsAppliedForJob() {
        int jobID = 1;
        List<ApplicantDto> applicantDtoList = jobApplicationService
                .getAllApplicantsAppliedForJob(jobID);
        System.out.println(applicantDtoList);
        Assertions.assertTrue(applicantDtoList.size() > 0);
    }

    @Test
    @Order(3)
    public void testUpdateUserApplicationStatus() {
        int applicantId = 1000;
        int jobId = 1;
        Assertions.assertDoesNotThrow(() -> jobApplicationService.updateUserApplicationStatus(applicantId, jobId, ApplicationStatus.INTERVIEW_SCHEDULED));
    }

    @Test
    @Order(4)
    public void testGetAllJobsForApplicantByApplicationStatus() {
        int applicantId = 1000;
        List<JobDto> jobDtoList = jobApplicationService.getAllJobsForApplicantByApplicationStatus(applicantId, ApplicationStatus.INTERVIEW_SCHEDULED);
        System.out.println(jobDtoList);
        Assertions.assertTrue(jobDtoList.size() > 0);
    }


    @Test
    @Order(5)
    public void testUpdateUserApplicationReview() {
        int applicantId = 1000;
        int jobId = 1;
        String review = "Lorem ipsum";
        Assertions.assertDoesNotThrow(() -> jobApplicationService.updateUserApplicationReview(applicantId, jobId, review));
    }
}
