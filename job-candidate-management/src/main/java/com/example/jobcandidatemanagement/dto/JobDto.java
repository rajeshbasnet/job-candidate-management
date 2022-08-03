package com.example.jobcandidatemanagement.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.jobcandidatemanagement.constant.Availability;
import com.example.jobcandidatemanagement.constant.JobStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JobDto {

    private int id;
    private String position;
    private int numOfEmployeeRequired;
    private double offeredSalary;
    private Availability availability;
    private String description;
    private JobStatus jobStatus;
    private LocalDate startDate;
    private LocalDate endDate;
    private CompanyDto companyDto;
    private JobCategoryDto jobCategoryDto;
    private List<JobApplicationDto> applicationDtoList;
}
