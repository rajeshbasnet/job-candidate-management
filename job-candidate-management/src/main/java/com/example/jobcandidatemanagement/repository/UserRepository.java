package com.example.jobcandidatemanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobcandidatemanagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Finds user by email. If user is present returns user in {@code Optional<User>}
     * type else will return {@code Optional.empty()} if no user found.
     *
     * @param email an email specified by User
     * @return an {@code Optional<User>}
     */
    Optional<User> findByEmail(String email);
}
