package com.example.jobcandidatemanagement;

import java.time.LocalDate;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jobcandidatemanagement.constant.Gender;
import com.example.jobcandidatemanagement.dto.ApplicantDto;
import com.example.jobcandidatemanagement.service.ApplicantService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestBApplicantService {

    @Autowired
    private ApplicantService applicantService;

    @Test
    @Order(1)
    void testSaveApplicantFromUserId() {
        int userId = 100;
        ApplicantDto applicantDto = new ApplicantDto();
        applicantDto.setGender(Gender.FEMALE);
        applicantDto.setDateOfBirth(LocalDate.of(2022, 10, 20));

        Assertions.assertDoesNotThrow(() -> applicantService.saveApplicantFromUserId(userId, applicantDto));
    }

    @Test
    @Order(2)
    void testGetApplicantFromUserId() {
        int userId = 100;
        ApplicantDto applicantDto = applicantService.getApplicantFromUserId(userId);
        System.out.println(applicantDto);
        Assertions.assertNotNull(applicantDto);
    }

    @Test
    @Order(3)
    void testGetApplicantFromApplicantId() {
        int applicantId = 1000;
        ApplicantDto applicantDto = applicantService.getApplicantFromApplicantId(applicantId);
        System.out.println(applicantDto);
        Assertions.assertNotNull(applicantDto);
    }
}
