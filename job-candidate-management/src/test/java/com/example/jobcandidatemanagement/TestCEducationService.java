package com.example.jobcandidatemanagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jobcandidatemanagement.dto.EducationDto;
import com.example.jobcandidatemanagement.service.ApplicantService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCEducationService {

    @Autowired
    private ApplicantService applicantService;

    @Test
    @Order(1)
    public void testSaveEducationFromApplicantId() {
        int applicantId = 1000;
        List<EducationDto> educationDtoList = new ArrayList<>();
        EducationDto educationDto = EducationDto.builder()
                .degree("SLC")
                .insituteName("Nepal Police School")
                .marksSecured("4.0 GPA")
                .graduatedDate(LocalDate.now())
                .build();
        EducationDto educationDto1 = EducationDto.builder()
                .degree("+2")
                .insituteName("Trinity Int'l College")
                .marksSecured("4.0 GPA")
                .graduatedDate(LocalDate.now())
                .build();
        educationDtoList.add(educationDto);
        educationDtoList.add(educationDto1);
        applicantService.saveEducationFromApplicantId(applicantId, educationDtoList);
    }

    @Test
    @Order(2)
    public void testGetEducationFromApplicantId() {
        int applicantId = 1000;
        List<EducationDto> educationDtoList = applicantService.getEducationFromApplicantId(applicantId);
        System.out.println(educationDtoList.size());
        Assertions.assertTrue(educationDtoList.size() > 0);
    }
}
