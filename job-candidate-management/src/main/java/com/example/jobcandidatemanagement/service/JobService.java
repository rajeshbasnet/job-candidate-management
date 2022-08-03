package com.example.jobcandidatemanagement.service;

import java.util.List;

import com.example.jobcandidatemanagement.constant.JobStatus;
import com.example.jobcandidatemanagement.dto.JobCategoryDto;
import com.example.jobcandidatemanagement.dto.JobDto;
import org.springframework.transaction.annotation.Transactional;

public interface JobService {
    JobDto getJobById(int id);

    void saveJobsForCompany(int companyId, int categoryId, List<JobDto> jobDto);

    List<JobDto> getAllJobsByStatusOfCompany(int companyId, JobStatus jobStatus);

    List<JobDto> getAllActiveJobs();

    void updateJobStatusForJob(int jobId, JobStatus jobStatus);

    JobCategoryDto saveJobCategory(JobCategoryDto jobCategoryDto);

    JobCategoryDto getJobCategoryFromId(int id);

    void deactivateJobs();

    void activateJobs();
}
