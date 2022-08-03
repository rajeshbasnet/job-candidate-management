package com.example.jobcandidatemanagement.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.*;
import javax.persistence.*;

import com.example.jobcandidatemanagement.constant.Availability;
import com.example.jobcandidatemanagement.constant.JobStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "jobs")
public class Job {

    @Id
    @SequenceGenerator(
            name = "job_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "job_seq"
    )
    private int id;

    private String position;
    private int numOfEmployeeRequired;
    private double offeredSalary;

    @Enumerated(EnumType.STRING)
    private Availability availability;

    private String description;

    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private JobCategory jobCategory;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private List<JobApplication> applications;
}
