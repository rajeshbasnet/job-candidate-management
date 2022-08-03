package com.example.jobcandidatemanagement.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.*;
import javax.persistence.*;

import com.example.jobcandidatemanagement.constant.Gender;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "applicants")
public class Applicant {

    @Id
    @SequenceGenerator(
            name = "applicant_seq",
            sequenceName = "applicant_seq",
            initialValue = 1000,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "applicant_seq"
    )
    private int id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate dateOfBirth;

    private String cvURI;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL)
    private List<Education> educationList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Experience> experienceList;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL)
    private List<JobApplication> applications;
}
