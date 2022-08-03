package com.example.jobcandidatemanagement.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.*;

import com.example.jobcandidatemanagement.constant.Gender;
import org.springframework.lang.Nullable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApplicantDto extends UserDto{

    private int id;
    private Gender gender;
    private LocalDate dateOfBirth;

    @Nullable
    private String cvURI;

    private List<EducationDto> educationDtoList;
    private List<ExperienceDto> experienceDtoList;
    private List<JobApplicationDto> jobApplicationDtoList;

}
