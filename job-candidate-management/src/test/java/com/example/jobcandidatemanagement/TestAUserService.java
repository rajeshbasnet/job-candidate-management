package com.example.jobcandidatemanagement;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jobcandidatemanagement.constant.ActiveStatus;
import com.example.jobcandidatemanagement.constant.Role;
import com.example.jobcandidatemanagement.dto.UserDto;
import com.example.jobcandidatemanagement.service.UserService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestAUserService {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

    }

    @Test
    @Order(1)
    void testSaveUserFromUserService() {
        UserDto userDto = UserDto.builder()
                .name("Rajesh")
                .email("test@gmail.com")
                .password("test")
                .role(Role.APPLICANT)
                .activeStatus(ActiveStatus.ACTIVE)
                .phoneNumber("9842826455")
                .location("Kathmandu")
                .build();

        UserDto responseUserDto = userService.saveUser(userDto);
        Assertions.assertNotNull(responseUserDto);
    }


    @Test
    @Order(2)
    void testSaveUserAsCompanyFromUserService() {
        UserDto userDto = UserDto.builder()
                .name("Rajesh")
                .email("rajesh@gmail.com")
                .password("test")
                .role(Role.COMPANY)
                .activeStatus(ActiveStatus.ACTIVE)
                .phoneNumber("9842826455")
                .location("Kathmandu")
                .build();

        UserDto responseUserDto = userService.saveUser(userDto);
        Assertions.assertNotNull(responseUserDto);
    }

    @Test
    @Order(3)
    void testGetUserFromUserId() {
        int userId = 100;
        UserDto userDto = userService.getUserFromUserId(userId);
        System.out.println(userDto);
        Assertions.assertNotNull(userDto);
    }

}
