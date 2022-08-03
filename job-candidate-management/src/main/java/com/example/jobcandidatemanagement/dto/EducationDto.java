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
public class EducationDto {

    private int id;
    private String degree;
    private String insituteName;
    private String marksSecured;
    private LocalDate graduatedDate;
    private ApplicantDto applicantDto;
}
