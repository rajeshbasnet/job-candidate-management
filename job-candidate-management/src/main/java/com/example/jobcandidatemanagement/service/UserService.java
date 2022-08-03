package com.example.jobcandidatemanagement.service;

import com.example.jobcandidatemanagement.dto.UserDto;
import com.example.jobcandidatemanagement.exception.EmailAlreadyExistsException;

public interface UserService {
    UserDto getUserFromUserId(int userId);

    UserDto saveUser(UserDto userDto) throws EmailAlreadyExistsException;

}
