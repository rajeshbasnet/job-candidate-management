package com.example.jobcandidatemanagement.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.jobcandidatemanagement.constant.JobCategoryType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JobCategoryDto {

    private int id;
    private JobCategoryType category;
    private List<ExperienceDto> experienceDtoList;
    private List<JobDto> jobDtoList;
}
