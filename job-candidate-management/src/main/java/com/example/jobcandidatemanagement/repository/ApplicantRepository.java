package com.example.jobcandidatemanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobcandidatemanagement.entity.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
     /**
      * Returns {@link Applicant} as {@code Optional} based on userId.
      *
      * @param userId an id which uniquely identifies user from others.
      * @return {@code Optional} of {@link Applicant} if found, else
      * will return {@code Optional.empty()} if not found
      */
     Optional<Applicant> findApplicantByUserId(int userId);
}
