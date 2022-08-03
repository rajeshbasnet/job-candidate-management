package com.example.jobcandidatemanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobcandidatemanagement.entity.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

     /**
      * Finds the {@link Company} based on userId and returns it as
      * {@code Optional} if found.
      *
      * @param userId an id which uniquely identifies user from others
      * @return an {@code Optional<Company>} if found as per parameters else
      * will return {@code Optional.empty()}
      */
     Optional<Company> findCompanyByUserId(int userId);
}
