package com.example.jobcandidatemanagement.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.jobcandidatemanagement.converters.DtoConverter;
import com.example.jobcandidatemanagement.converters.EntityConveter;
import com.example.jobcandidatemanagement.dto.*;
import com.example.jobcandidatemanagement.entity.*;
import com.example.jobcandidatemanagement.exception.NotFoundException;
import com.example.jobcandidatemanagement.repository.ApplicantRepository;
import com.example.jobcandidatemanagement.repository.EducationRepository;
import com.example.jobcandidatemanagement.repository.ExperienceRepository;
import com.example.jobcandidatemanagement.service.ApplicantService;
import com.example.jobcandidatemanagement.service.UserService;
import com.example.jobcandidatemanagement.service.JobService;

@Service
@RequiredArgsConstructor
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final EducationRepository educationRepository;
    private final ExperienceRepository experienceRepository;
    private final DtoConverter dtoConverter;
    private final EntityConveter entityConveter;
    private final UserService userService;
    private final JobService jobService;

    @Override
    public ApplicantDto getApplicantFromApplicantId(int applicantId) {
        Optional<Applicant> applicantOpt = applicantRepository.findById(applicantId);

        if (applicantOpt.isPresent()) {
            Applicant applicant = applicantOpt.get();
            return entityConveter.applicantDtoBuilder(applicant);
        } else {
            throw new NotFoundException("User's applicant cannot be found");
        }
    }

    @Override
    @Transactional
    public void saveApplicantFromUserId(int userId, ApplicantDto applicantDto) {
        UserDto userDto = userService.getUserFromUserId(userId);
        // Applicant will later save cv uri
        applicantDto.setCvURI(null);
        Applicant applicant = applicantRepository.save(dtoConverter.applicantEntityBuilder(applicantDto));
        User user = dtoConverter.userEntityBuilder(userDto);
        applicant.setUser(user);
    }

    /**
     * Uploads file as cv into the destined folder location and store file location path
     * in database.
     *
     * @param cv a {@code MultipartFile}
     * @param applicantID id of an applicant
     * @throws NotFoundException If repository cannot find applicant from applicantID.
     * @throws RuntimeException If any error occurs while manipulating with file.
     *
     */
    @Override
    @Transactional
    public void uploadCVForApplicant(MultipartFile cv, int applicantID) {

        applicantRepository.findById(applicantID)
                .ifPresentOrElse(applicant -> {
                    try {
                        Path fileLocation = Paths.get(Paths.get("src\\main\\resources\\static").toAbsolutePath().normalize() + File.separator + cv.getOriginalFilename());
                        Files.copy(cv.getInputStream(), fileLocation, StandardCopyOption.REPLACE_EXISTING);
                        applicant.setCvURI(fileLocation.toString());
                    } catch (IOException exception) {
                        throw new RuntimeException(exception.getMessage());
                    }
                }, () -> {
                    throw new NotFoundException("Cannot find applicant from given id.");
                });
    }


    @Override
    public ApplicantDto getApplicantFromUserId(int userId) {
        Optional<Applicant> applicantOptional = applicantRepository.findApplicantByUserId(userId);

        if (applicantOptional.isPresent()) {
            return entityConveter.applicantDtoBuilder(applicantOptional.get());

        } else {
            throw new NotFoundException("Cannot find applicant from given user id");
        }
    }


    @Override
    @Transactional
    public void saveEducationFromApplicantId(int applicantId, List<EducationDto> educationDtoList) {
        ApplicantDto applicantDto = getApplicantFromApplicantId(applicantId);
        System.out.println(applicantDto);
        Applicant applicant = dtoConverter.applicantEntityBuilder(applicantDto);
        List<Education> educationList = dtoConverter.educationEntityList(educationDtoList);
        educationRepository.saveAll(educationList)
                .forEach(education -> education.setApplicant(applicant));
    }

    @Override
    public List<EducationDto> getEducationFromApplicantId(int applicantId) {
        Optional<List<Education>> educationListOptional = educationRepository.findAllByApplicantId(applicantId);

        if (educationListOptional.isPresent()) {
            return entityConveter.educationDtoList(educationListOptional.get());
        } else {
            throw new NotFoundException("Cannot find education from given app");
        }
    }

    @Override
    @Transactional
    public void saveExperienceFromApplicantId(int applicantId, int jobCategoryId, List<ExperienceDto> experienceDtoList) {
        ApplicantDto applicantDto = getApplicantFromApplicantId(applicantId);
        Applicant applicant = dtoConverter.applicantEntityBuilder(applicantDto);

        JobCategoryDto jobCategoryDto = jobService.getJobCategoryFromId(jobCategoryId);
        JobCategory jobCategory = dtoConverter.categoryEntityBuilder(jobCategoryDto);

        List<Experience> experienceList = dtoConverter.experienceEntityList(experienceDtoList);
        experienceRepository.saveAll(experienceList)
                .forEach(experience -> {
                    experience.setApplicant(applicant);
                    experience.setJobCategory(jobCategory);
                });
    }

    @Override
    public List<ExperienceDto> getExperienceFromApplicantId(int applicantId) {
        Optional<List<Experience>> experienceListOptional = experienceRepository.findAllByApplicantId(applicantId);

        if (experienceListOptional.isPresent()) {
            return entityConveter.experienceDtoList(experienceListOptional.get());
        } else {
            throw new NotFoundException("Cannot find experience of given applicant");
        }
    }
}
