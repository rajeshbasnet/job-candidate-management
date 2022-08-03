package com.example.jobcandidatemanagement;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jobcandidatemanagement.dto.CompanyDto;
import com.example.jobcandidatemanagement.service.CompanyService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestFCompanyService {

    @Autowired
    private CompanyService companyService;

    @Test
    @Tag("getCompanyFromCompanyId")
    @Order(2)
    public void testGetCompanyFromCompanyId() {
        int companyId = 1;
        CompanyDto companyDto = companyService.getCompanyFromCompanyId(companyId);
        System.out.println(companyDto);
        Assertions.assertNotNull(companyDto);
    }

    @Test
    @Order(1)
    void testSaveCompanyFromUserId() {
        int userId = 101;
        CompanyDto companyDto = new CompanyDto();
        companyDto.setOrgSize("1000");
        companyDto.setDescription("Lorem ipsum");
        Assertions.assertDoesNotThrow(() -> companyService.saveCompanyFromUserId(userId, companyDto));
    }

    @Test
    @Order(3)
    void testGetCompanyFromUserId() {
        int userId = 101;
        CompanyDto companyDto = companyService.getCompanyFromUserId(userId);
        System.out.println(companyDto);
        Assertions.assertNotNull(companyDto);
    }
}