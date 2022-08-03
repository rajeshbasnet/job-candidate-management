package com.example.jobcandidatemanagement.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExperienceDto {

    private int id;
    private String organizationName;
    private String jobLocation;
    private String jobTitle;
    private LocalDate endDate;
    private String description;
    private ApplicantDto applicantDto;
    private JobCategoryDto jobCategoryDto;

}
