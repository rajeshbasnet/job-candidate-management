package com.example.jobcandidatemanagement.dto;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.example.jobcandidatemanagement.constant.ActiveStatus;
import com.example.jobcandidatemanagement.constant.Role;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserDto {

    private int id;

    private String name;

    @Email(message = "Invalid email format")
    @NotNull(message = "Email field cannot be empty")
    private String email;

    @NotNull(message = "Password field cannot be empty")
    private String password;

    private Role role;

    private ActiveStatus activeStatus;

    private String phoneNumber;

    private String location;
}
