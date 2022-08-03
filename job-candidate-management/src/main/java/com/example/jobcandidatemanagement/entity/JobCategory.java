package com.example.jobcandidatemanagement.entity;

import java.util.List;

import lombok.*;
import javax.persistence.*;

import com.example.jobcandidatemanagement.constant.JobCategoryType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "job_category")
public class JobCategory {

    @Id
    @SequenceGenerator(
            name = "cat_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cat_seq"
    )
    private int id;

    @Enumerated(EnumType.STRING)
    private JobCategoryType category;

    @OneToMany(mappedBy = "jobCategory", cascade = CascadeType.ALL)
    private List<Experience> experienceList;

    @OneToMany(mappedBy = "jobCategory", cascade = CascadeType.ALL)
    private List<Job> jobList;
}
