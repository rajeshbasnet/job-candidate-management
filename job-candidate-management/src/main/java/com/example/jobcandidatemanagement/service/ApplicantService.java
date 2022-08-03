package com.example.jobcandidatemanagement.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.jobcandidatemanagement.dto.ApplicantDto;
import com.example.jobcandidatemanagement.dto.EducationDto;
import com.example.jobcandidatemanagement.dto.ExperienceDto;
import org.springframework.web.multipart.MultipartFile;

public interface ApplicantService {

    ApplicantDto getApplicantFromApplicantId(int applicantId);

    void saveApplicantFromUserId(int userId, ApplicantDto applicantDto);

    void uploadCVForApplicant(MultipartFile cv, int applicantId);

    ApplicantDto getApplicantFromUserId(int userId);

    void saveEducationFromApplicantId(int applicantId, List<EducationDto> educationDtoList);

    List<EducationDto> getEducationFromApplicantId(int applicantId);

    void saveExperienceFromApplicantId(int applicantId, int jobCategoryId, List<ExperienceDto> experienceDtoList);

    List<ExperienceDto> getExperienceFromApplicantId(int applicantId);
}
