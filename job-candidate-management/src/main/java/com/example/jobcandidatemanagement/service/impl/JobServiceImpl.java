package com.example.jobcandidatemanagement.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.jobcandidatemanagement.repository.JobCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jobcandidatemanagement.constant.JobStatus;
import com.example.jobcandidatemanagement.converters.DtoConverter;
import com.example.jobcandidatemanagement.converters.EntityConveter;
import com.example.jobcandidatemanagement.dto.CompanyDto;
import com.example.jobcandidatemanagement.dto.JobCategoryDto;
import com.example.jobcandidatemanagement.dto.JobDto;
import com.example.jobcandidatemanagement.entity.Company;
import com.example.jobcandidatemanagement.entity.Job;
import com.example.jobcandidatemanagement.entity.JobCategory;
import com.example.jobcandidatemanagement.exception.NotFoundException;
import com.example.jobcandidatemanagement.repository.JobRepository;
import com.example.jobcandidatemanagement.service.CompanyService;
import com.example.jobcandidatemanagement.service.JobService;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final DtoConverter dtoConverter;
    private final EntityConveter entityConveter;
    private final CompanyService companyService;
    private final JobCategoryRepository jobCategoryRepository;


    /**
     * Returns a {@link JobDto} from given id {@code int}. If
     * job is not found, then an exception is thrown.
     *
     * @param id jobID uniquely specified to job
     * @return a {@link JobDto}
     * @throws NotFoundException if repository cannot find job
     * from specified id.
     */
    @Override
    public JobDto getJobById(int id) {
        Optional<Job> job = jobRepository.findById(id);

        if (job.isPresent()) {
            return entityConveter.jobDtoBuilder(job.get());
        } else {
            throw new NotFoundException("Cannot find job from given id.");
        }
    }


    /**
     * Used to save jobs
     *
     * @param companyID id uniquely specified for {@link Company}
     * @param categoryID id uniquely specified for {@link JobCategory}
     * @param jobDto a {@link JobDto}
     */
    @Override
    @Transactional
    public void saveJobsForCompany(int companyID, int categoryID, List<JobDto> jobDto) {
        CompanyDto companyDto = companyService.getCompanyFromCompanyId(companyID);
        Company company = dtoConverter.companyEntityBuilder(companyDto);

        JobCategoryDto categoryDto = getJobCategoryFromId(categoryID);
        JobCategory category = dtoConverter.categoryEntityBuilder(categoryDto);

        jobDto.forEach(dto -> dto.setJobStatus(JobStatus.INACTIVE));
        List<Job> jobs = dtoConverter.jobEntityList(jobDto);

        jobRepository.saveAll(jobs)
                .forEach(job -> {
                    job.setCompany(company);
                    job.setJobCategory(category);
                });
    }

    @Override
    public List<JobDto> getAllJobsByStatusOfCompany(int companyId, JobStatus jobStatus) {
        return jobRepository.findAllByCompanyIdAndJobStatus(companyId, jobStatus)
                .stream()
                .map(entityConveter::jobDtoBuilder)
                .collect(Collectors.toList());
    }


    @Override
    public List<JobDto> getAllActiveJobs() {
        return jobRepository.findAllByJobStatus(JobStatus.ACTIVE)
                .stream()
                .map(entityConveter::jobDtoBuilder)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateJobStatusForJob(int jobId, JobStatus jobStatus) {
        jobRepository.findById(jobId)
                .ifPresentOrElse((job) -> {
                    job.setJobStatus(jobStatus);
                }, () -> {
                    throw new NotFoundException("Cannot find job from given id");
                });
    }

    @Override
    public JobCategoryDto saveJobCategory(JobCategoryDto jobCategoryDto) {
        JobCategory jobCategory = dtoConverter.categoryEntityBuilder(jobCategoryDto);
        JobCategory responseCategory = jobCategoryRepository.save(jobCategory);
        return entityConveter.categoryDtoBuilder(responseCategory);
    }

    @Override
    public JobCategoryDto getJobCategoryFromId(int id) {
        Optional<JobCategory> jobCategoryOpt = jobCategoryRepository.findById(id);

        if (jobCategoryOpt.isPresent()) {
            return entityConveter.categoryDtoBuilder(jobCategoryOpt.get());
        } else {
            throw new NotFoundException("Cannot find the category of job from given id");
        }
    }

    @Override
    @Transactional
    public void deactivateJobs() {
        jobRepository.activateAllJobsByJobStatusAndStartDateLessThanEqual(JobStatus.ACTIVE, LocalDate.now());
    }

    @Override
    @Transactional
    public void activateJobs() {
        jobRepository.deactivateAllJobsByJobStatusAndEndDateLessThanEqual(JobStatus.INACTIVE, LocalDate.now());
    }

}
