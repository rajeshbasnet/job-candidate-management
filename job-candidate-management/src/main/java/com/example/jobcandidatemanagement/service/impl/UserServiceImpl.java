package com.example.jobcandidatemanagement.service.impl;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jobcandidatemanagement.converters.DtoConverter;
import com.example.jobcandidatemanagement.converters.EntityConveter;
import com.example.jobcandidatemanagement.dto.UserDto;
import com.example.jobcandidatemanagement.entity.User;
import com.example.jobcandidatemanagement.exception.EmailAlreadyExistsException;
import com.example.jobcandidatemanagement.exception.NotFoundException;
import com.example.jobcandidatemanagement.repository.UserRepository;
import com.example.jobcandidatemanagement.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DtoConverter dtoConverter;
    private final EntityConveter entityConveter;

    @Override
    public UserDto getUserFromUserId(int userId) {
        Optional<User> userOpt = userRepository.findById(userId);

        if (userOpt.isPresent()) {
            return entityConveter.userDtoBuilder(userOpt.get());
        } else {
            throw new NotFoundException("User cannot be found from given user id");
        }
    }

    @Override
    @Transactional
    public UserDto saveUser(UserDto userDto) {
        if (isEmailAlreadyRegistered(userDto.getEmail())) {
            throw new EmailAlreadyExistsException("Email is already registered!");
        } else {
            User user = dtoConverter.userEntityBuilder(userDto);

            //TODO: Hash password
            user.setPassword(userDto.getPassword());
            return entityConveter.userDtoBuilder(userRepository.save(user));
        }
    }


    private boolean isEmailAlreadyRegistered(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

}
