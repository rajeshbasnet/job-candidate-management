package com.example.jobcandidatemanagement.dto;

import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CompanyDto extends UserDto {

    private int id;
    private String orgSize;
    private String description;
    private List<JobDto> jobDtoList;

}
