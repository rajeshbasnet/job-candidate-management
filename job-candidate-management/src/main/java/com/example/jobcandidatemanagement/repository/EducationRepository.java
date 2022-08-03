package com.example.jobcandidatemanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobcandidatemanagement.entity.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {
    /**
     * Returns a {@code List} of {@link Education} as {@code Optional} based on
     * applicantId. If no education found, will return {@code Optional.empty()}
     *
     * @param applicantId an id which uniquely identifies applicant from others.
     * @return {@code Optional<List>} of {@link Education}
     */
    Optional<List<Education>> findAllByApplicantId(int applicantId);
}
