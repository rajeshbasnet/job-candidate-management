package com.example.jobcandidatemanagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jobcandidatemanagement.dto.ExperienceDto;
import com.example.jobcandidatemanagement.service.ApplicantService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEExperienceService {

    @Autowired
    private ApplicantService applicantService;

    @Test
    @Order(1)
    public void testSaveExperienceFromExperienceAId() {
        int applicantId = 1000;
        int jobCategoryId = 1;
        List<ExperienceDto> experienceDtoList = new ArrayList<>();
        ExperienceDto experienceDto1 = ExperienceDto.builder()
                .organizationName("WorldLink Pvt. Ltd")
                .jobLocation("Kathmandu")
                .jobTitle("Developer")
                .endDate(LocalDate.now())
                .description("Lorem ipsum")
                .build();
        ExperienceDto experienceDto2 = ExperienceDto.builder()
                .organizationName("Classic Tech Nepal")
                .jobLocation("Kathmandu")
                .jobTitle("Developer")
                .endDate(LocalDate.now())
                .description("Lorem ipsum")
                .build();
        experienceDtoList.add(experienceDto1);
        experienceDtoList.add(experienceDto2);
        applicantService.saveExperienceFromApplicantId(applicantId, jobCategoryId, experienceDtoList);

    }

    @Test
    @Order(2)
    public void testGetExperienceFromApplicantId() {
        int applicantId = 1000;
        List<ExperienceDto> experienceDtoList = applicantService.getExperienceFromApplicantId(applicantId);
        System.out.println(experienceDtoList.size());
        Assertions.assertTrue(experienceDtoList.size() > 0);
    }
}
