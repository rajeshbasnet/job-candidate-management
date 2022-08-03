package com.example.jobcandidatemanagement.controller;

import com.example.jobcandidatemanagement.dto.CompanyDto;
import com.example.jobcandidatemanagement.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> fetchCompanyFromCompanyId(@PathVariable("id") int id) {
        return new ResponseEntity<>(companyService.getCompanyFromCompanyId(id), HttpStatus.OK);
    }

}
