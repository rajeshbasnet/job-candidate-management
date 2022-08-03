package com.example.jobcandidatemanagement.entity;

import lombok.*;
import javax.persistence.*;

import com.example.jobcandidatemanagement.constant.ActiveStatus;
import com.example.jobcandidatemanagement.constant.Role;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(
            name = "user_seq",
            sequenceName = "user_seq",
            initialValue = 100
    )
    private int id;

    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private ActiveStatus activeStatus;

    private String phoneNumber;
    private String location;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Applicant applicant;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Company company;
}
