package com.example.jobcandidatemanagement.entity;

import java.util.List;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "companies")
public class Company {

    @Id
    @SequenceGenerator(
            name = "company_seq"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_seq"
    )
    private int id;

    private String orgSize;
    private String description;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Job> jobList;

}
