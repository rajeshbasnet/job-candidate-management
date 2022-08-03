package com.example.jobcandidatemanagement.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.jobcandidatemanagement.dto.*;
import com.example.jobcandidatemanagement.entity.*;



@Component
public class DtoConverter {

    public User userEntityBuilder(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .location(userDto.getLocation())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .activeStatus(userDto.getActiveStatus())
                .role(userDto.getRole())
                .build();
    }

    public List<User> userEntityList(List<UserDto> list) {
        return list.stream().map(this::userEntityBuilder).collect(Collectors.toList());
    }

    public Experience experienceEntityBuilder(ExperienceDto experienceDto) {
        return Experience.builder()
                .id(experienceDto.getId())
                .organizationName(experienceDto.getOrganizationName())
                .jobLocation(experienceDto.getJobLocation())
                .jobTitle(experienceDto.getJobTitle())
                .endDate(experienceDto.getEndDate())
                .description(experienceDto.getDescription())
                .build();

    }

    public List<Experience> experienceEntityList(List<ExperienceDto> list) {
        return list.stream().map(this::experienceEntityBuilder).collect(Collectors.toList());
    }

    public Education educationEntityBuilder(EducationDto educationDto) {
        return Education.builder()
                .id(educationDto.getId())
                .degree(educationDto.getDegree())
                .instituteName(educationDto.getInsituteName())
                .marksSecured(educationDto.getMarksSecured())
                .graduatedDate(educationDto.getGraduatedDate())
                .build();
    }

    public List<Education> educationEntityList(List<EducationDto> list) {
        return list.stream().map(this::educationEntityBuilder).collect(Collectors.toList());
    }

    public Company companyEntityBuilder(CompanyDto companyDto) {
        return Company.builder()
                .id(companyDto.getId())
                .orgSize(companyDto.getOrgSize())
                .description(companyDto.getDescription())
                .build();

    }

    public List<Company> companyEntityList(List<CompanyDto> list) {
        return list.stream()
                .map(this::companyEntityBuilder)
                .collect(Collectors.toList());
    }

    public JobCategory categoryEntityBuilder(JobCategoryDto jobCategoryDto) {
        return JobCategory.builder()
                .id(jobCategoryDto.getId())
                .category(jobCategoryDto.getCategory())
                .build();
    }

    public List<JobCategory> categoryEntityList(List<JobCategoryDto> list) {
        return list.stream()
                .map(this::categoryEntityBuilder)
                .collect(Collectors.toList());
    }


    public Applicant applicantEntityBuilder(ApplicantDto applicantDto) {
        return Applicant.builder()
                .id(applicantDto.getId())
                .gender(applicantDto.getGender())
                .dateOfBirth(applicantDto.getDateOfBirth())
                .build();
    }

    public List<Applicant> applicantEntityDtoList(List<ApplicantDto> list) {
        return list.stream()
                .map(this::applicantEntityBuilder)
                .collect(Collectors.toList());
    }

    public Job jobEntityBuilder(JobDto jobDto) {
        return Job.builder()
                .id(jobDto.getId())
                .position(jobDto.getPosition())
                .numOfEmployeeRequired(jobDto.getNumOfEmployeeRequired())
                .offeredSalary(jobDto.getOfferedSalary())
                .availability(jobDto.getAvailability())
                .description(jobDto.getDescription())
                .jobStatus(jobDto.getJobStatus())
                .startDate(jobDto.getStartDate())
                .endDate(jobDto.getEndDate())
                .build();
    }

    public List<Job> jobEntityList(List<JobDto> list) {
        return list.stream()
                .map(this::jobEntityBuilder)
                .collect(Collectors.toList());
    }

    public JobApplication jobApplicationEntityBuilder(JobApplicationDto jobApplicationDto) {
        return JobApplication.builder()
                .id(jobApplicationDto.getId())
                .applicationStatus(jobApplicationDto.getApplicationStatus())
                .build();
    }

    public List<JobApplication> jobApplicationEntityList(List<JobApplicationDto> list) {
        return list.stream()
                .map(this::jobApplicationEntityBuilder)
                .collect(Collectors.toList());
    }
}
