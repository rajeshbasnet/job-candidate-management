package com.example.jobcandidatemanagement.service.impl;

import com.example.jobcandidatemanagement.constant.ApplicationStatus;
import com.example.jobcandidatemanagement.converters.DtoConverter;
import com.example.jobcandidatemanagement.converters.EntityConveter;
import com.example.jobcandidatemanagement.dto.ApplicantDto;
import com.example.jobcandidatemanagement.dto.JobDto;
import com.example.jobcandidatemanagement.entity.JobApplication;
import com.example.jobcandidatemanagement.exception.JobAlreadyAppliedException;
import com.example.jobcandidatemanagement.exception.NotFoundException;
import com.example.jobcandidatemanagement.repository.JobApplicationRepository;
import com.example.jobcandidatemanagement.service.ApplicantService;
import com.example.jobcandidatemanagement.service.JobApplicationService;
import com.example.jobcandidatemanagement.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final ApplicantService applicantService;
    private final JobService jobService;
    private final DtoConverter dtoConverter;
    private final EntityConveter entityConveter;

    @Override
    @Transactional
    public void applyForJobs(int applicantId, int jobId) {

        //todo : should fetch cv while applying
        //todo : print cv in some location
        boolean hasApplied = hasUserAlreadyAppliedForJob(applicantId, jobId);

        if (hasApplied) {
            throw new JobAlreadyAppliedException("You have already applied for this job");
        } else {

            //If user has not applied for the job
            ApplicantDto applicantDto = applicantService.getApplicantFromApplicantId(applicantId);
            JobDto jobDto = jobService.getJobById(jobId);

            if (applicantDto != null && jobDto != null) {
                JobApplication jobApplication = JobApplication.builder()
                        .applicant(dtoConverter.applicantEntityBuilder(applicantDto))
                        .job(dtoConverter.jobEntityBuilder(jobDto))
                        .applicationStatus(ApplicationStatus.NEW)
                        .reivew(null)
                        .build();
                jobApplicationRepository.save(jobApplication);

            } else {
                throw new NotFoundException("Cannot apply for jobs from given id");
            }
        }
    }

    /**
     *
     * Returns all the applicants who have applied for specified job. This
     * method is useful to fetch all the applicant who has applied for the job
     * they have posted.
     *
     * @param jobID unique ID allocated to job
     * @return all the {@link ApplicantDto} who has applied for specified job
     *
     */
    @Override
    public List<ApplicantDto> getAllApplicantsAppliedForJob(int jobID) {
        return jobApplicationRepository.findAllByJobId(jobID)
                .stream()
                .map(JobApplication::getApplicant)
                .map(entityConveter::applicantDtoBuilder)
                .collect(Collectors.toList());
    }


    @Override
    public List<JobDto> getAllJobsForApplicantByApplicationStatus(int applicantId, ApplicationStatus applicationStatus) {
        return jobApplicationRepository.findAllByApplicantIdAndApplicationStatus(applicantId, applicationStatus)
                .stream()
                .map(JobApplication::getJob)
                .map(entityConveter::jobDtoBuilder)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateUserApplicationStatus(int applicantId, int jobId, ApplicationStatus applicationStatus) {
        jobApplicationRepository.findByApplicantIdAndJobId(applicantId, jobId)
                .ifPresentOrElse(jobApplication -> {
                    jobApplication.setApplicationStatus(applicationStatus);
                }, () -> {
                    throw new NotFoundException("Cannot find applied user for jobs");
                });
    }


    @Override
    @Transactional
    public void updateUserApplicationReview(int applicantId, int jobId, String review) {
        jobApplicationRepository.findByApplicantIdAndJobId(applicantId, jobId)
                .ifPresentOrElse(jobApplication -> {
                    jobApplication.setReivew(review);
                }, () -> {
                    throw new NotFoundException("Cannot find applied user for jobs");
                });
    }

    private boolean hasUserAlreadyAppliedForJob(int applicantId, int jobId) {
        return jobApplicationRepository
                .findByApplicantIdAndJobId(applicantId, jobId)
                .isPresent();
    }

}
