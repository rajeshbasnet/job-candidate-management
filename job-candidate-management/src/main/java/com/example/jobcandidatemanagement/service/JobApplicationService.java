package com.example.jobcandidatemanagement.service;

import com.example.jobcandidatemanagement.constant.ApplicationStatus;
import com.example.jobcandidatemanagement.dto.ApplicantDto;
import com.example.jobcandidatemanagement.dto.JobDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JobApplicationService {

    void applyForJobs(int applicantId, int jobId);

    List<ApplicantDto> getAllApplicantsAppliedForJob(int jobID);

    List<JobDto> getAllJobsForApplicantByApplicationStatus(int applicantId, ApplicationStatus applicationStatus);

    void updateUserApplicationStatus(int applicantId, int jobId, ApplicationStatus applicationStatus);

    void updateUserApplicationReview(int applicantId, int jobId, String review);
}
