package com.example.jobcandidatemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import com.example.jobcandidatemanagement.constant.ApplicationStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JobApplicationDto {
    private int id;
    private ApplicationStatus applicationStatus;
    private ApplicantDto applicantDto;
    private JobDto jobDto;

    @Nullable
    private String review;
}
