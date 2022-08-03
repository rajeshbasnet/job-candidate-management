package com.example.jobcandidatemanagement.service;

import com.example.jobcandidatemanagement.dto.CompanyDto;

public interface CompanyService {
    CompanyDto getCompanyFromCompanyId(int companyId);

    void saveCompanyFromUserId(int userId, CompanyDto companyDto);

    CompanyDto getCompanyFromUserId(int userId);
}
