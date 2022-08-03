package com.example.jobcandidatemanagement.service.impl;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jobcandidatemanagement.converters.DtoConverter;
import com.example.jobcandidatemanagement.converters.EntityConveter;
import com.example.jobcandidatemanagement.dto.CompanyDto;
import com.example.jobcandidatemanagement.dto.UserDto;
import com.example.jobcandidatemanagement.entity.Company;
import com.example.jobcandidatemanagement.entity.User;
import com.example.jobcandidatemanagement.exception.NotFoundException;
import com.example.jobcandidatemanagement.repository.CompanyRepository;
import com.example.jobcandidatemanagement.service.CompanyService;
import com.example.jobcandidatemanagement.service.UserService;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final DtoConverter dtoConverter;
    private final EntityConveter entityConveter;
    private final UserService userService;


    @Override
    public CompanyDto getCompanyFromCompanyId(int companyId) {
        Optional<Company> companyOpt = companyRepository.findById(companyId);

        if (companyOpt.isPresent()) {
            return entityConveter.companyDtoBuilder(companyOpt.get());
        } else {
            throw new NotFoundException("Cannot find company from given id");
        }
    }

    @Override
    @Transactional
    public void saveCompanyFromUserId(int userId, CompanyDto companyDto) {
        UserDto userDto = userService.getUserFromUserId(userId);
        User user = dtoConverter.userEntityBuilder(userDto);
        Company company = companyRepository.save(dtoConverter.companyEntityBuilder(companyDto));
        company.setUser(user);
    }

    @Override
    public CompanyDto getCompanyFromUserId(int userId) {
        Optional<Company> companyOptional = companyRepository.findCompanyByUserId(userId);

        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            return entityConveter.companyDtoBuilder(company);

        } else {
            throw new NotFoundException("Cannot find company from given user id");
        }
    }


}
