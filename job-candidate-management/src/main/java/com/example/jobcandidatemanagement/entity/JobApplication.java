package com.example.jobcandidatemanagement.entity;

import lombok.*;
import org.springframework.lang.Nullable;
import javax.persistence.*;

import com.example.jobcandidatemanagement.constant.ApplicationStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "job_application")
public class JobApplication {

    @Id
    @SequenceGenerator(
            name = "job_app_seq",
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "job_app_seq"
    )
    private int id;

    @ManyToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    private Job job;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;

    @Nullable
    private String reivew;

}


