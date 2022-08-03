package com.example.jobcandidatemanagement.entity;

import java.time.LocalDate;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "education")
public class Education {

    @Id
    @SequenceGenerator(
            name = "edu_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "edu_seq"
    )
    private int id;

    private String degree;
    private String instituteName;
    private String marksSecured;
    private LocalDate graduatedDate;

    @ManyToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    private Applicant applicant;
}
