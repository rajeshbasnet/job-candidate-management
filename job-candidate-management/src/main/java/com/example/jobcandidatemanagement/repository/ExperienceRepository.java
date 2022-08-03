package com.example.jobcandidatemanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobcandidatemanagement.entity.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

    /**
     * Returns a {@code List} of {@link Experience} as {@code Optional} based
     * on applicantId passed as an arguments but if there is no experience
     * found, will return {@code Optional.empty()}
     *
     * @param applicantId an id which uniquely identifies {@link Experience}
     * @return a {@code Optional<Lis<Experience>>}
     */
    Optional<List<Experience>> findAllByApplicantId(int applicantId);
}
