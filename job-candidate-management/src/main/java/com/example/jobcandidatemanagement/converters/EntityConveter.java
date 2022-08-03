package com.example.jobcandidatemanagement.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.jobcandidatemanagement.dto.*;
import com.example.jobcandidatemanagement.entity.*;



@Component
public class EntityConveter {
    
    public UserDto userDtoBuilder(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .location(user.getLocation())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .activeStatus(user.getActiveStatus())
                .role(user.getRole())
                .build();
    }

    public List<UserDto> userDtoList(List<User> list) {
        return list.stream().map(this::userDtoBuilder).collect(Collectors.toList());
    }

    public ExperienceDto experienceDtoBuilder(Experience experience) {
        return ExperienceDto.builder()
                .id(experience.getId())
                .organizationName(experience.getOrganizationName())
                .jobLocation(experience.getJobLocation())
                .jobTitle(experience.getJobTitle())
                .endDate(experience.getEndDate())
                .description(experience.getDescription())
                .build();

    }

    public List<ExperienceDto> experienceDtoList(List<Experience> list) {
        return list.stream().map(this::experienceDtoBuilder).collect(Collectors.toList());
    }

    public EducationDto educationDtoBuilder(Education education) {
        return EducationDto.builder()
                .id(education.getId())
                .degree(education.getDegree())
                .insituteName(education.getInstituteName())
                .marksSecured(education.getMarksSecured())
                .graduatedDate(education.getGraduatedDate())
                .build();
    }

    public List<EducationDto> educationDtoList(List<Education> list) {
        return list.stream().map(this::educationDtoBuilder).collect(Collectors.toList());
    }

    public CompanyDto companyDtoBuilder(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setOrgSize(company.getOrgSize());
        companyDto.setDescription(company.getDescription());
        return companyDto;
    }

    public List<CompanyDto> companyDtoList(List<Company> list) {
        return list.stream()
                .map(this::companyDtoBuilder)
                .collect(Collectors.toList());
    }

    public JobCategoryDto categoryDtoBuilder(JobCategory jobCategory) {
        return JobCategoryDto.builder()
                .id(jobCategory.getId())
                .category(jobCategory.getCategory())
                .build();
    }

    public List<JobCategoryDto> categoryList(List<JobCategory> list) {
        return list.stream()
                .map(this::categoryDtoBuilder)
                .collect(Collectors.toList());
    }


    public ApplicantDto applicantDtoBuilder(Applicant applicant) {
        ApplicantDto applicantDto = new ApplicantDto();
        applicantDto.setId(applicant.getId());
        applicantDto.setGender(applicant.getGender());
        applicantDto.setDateOfBirth(applicant.getDateOfBirth());
        return applicantDto;
    }

    public List<ApplicantDto> applicantDtoList(List<Applicant> list) {
        return list.stream()
                .map(this::applicantDtoBuilder)
                .collect(Collectors.toList());
    }

    public JobDto jobDtoBuilder(Job job) {
        return JobDto.builder()
                .id(job.getId())
                .position(job.getPosition())
                .numOfEmployeeRequired(job.getNumOfEmployeeRequired())
                .offeredSalary(job.getOfferedSalary())
                .availability(job.getAvailability())
                .description(job.getDescription())
                .jobStatus(job.getJobStatus())
                .startDate(job.getStartDate())
                .endDate(job.getEndDate())
                .build();
    }

    public List<JobDto> jobDtoList(List<Job> list) {
        return list.stream()
                .map(this::jobDtoBuilder)
                .collect(Collectors.toList());
    }

    public JobApplicationDto jobApplicationDtoBuilder(JobApplication jobApplication) {
        return JobApplicationDto.builder()
                .id(jobApplication.getId())
                .applicationStatus(jobApplication.getApplicationStatus())
                .build();
    }

    public List<JobApplicationDto> jobApplicationDtoList(List<JobApplication> list) {
        return list.stream()
                .map(this::jobApplicationDtoBuilder)
                .collect(Collectors.toList());
    }

}
