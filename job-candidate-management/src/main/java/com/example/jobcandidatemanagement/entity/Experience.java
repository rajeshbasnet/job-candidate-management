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
@Table(name = "experience")
public class Experience {

    @Id
    @SequenceGenerator(
            name = "exp_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exp_seq"
    )
    private int id;

    private String organizationName;
    private String jobLocation;
    private String jobTitle;
    private LocalDate endDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private JobCategory jobCategory;
}
