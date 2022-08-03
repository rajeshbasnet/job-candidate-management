package com.example.jobcandidatemanagement.repository;

import com.example.jobcandidatemanagement.constant.ApplicationStatus;
import com.example.jobcandidatemanagement.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {

    /**
     * Returns an {@link Optional<JobApplication>} containing job applicants
     * based on jobId and applicantId, if any instance of {@link JobApplication}
     * is not found, will return {@code Optional.empty()}.
     *
     * @param applicantId an id which uniquely identifies applicant from other applicants
     * @param jobId an id which uniquely identifies job from other jobs
     * @return {@code Optional<JobApplication>}
     */
    Optional<JobApplication> findByApplicantIdAndJobId(int applicantId, int jobId);

    /**
     * Returns all {@link JobApplication} based on applicantId and Application Status.
     *
     * @param applicantId an id which uniquely identifies applicant from other applicants.
     * @param applicationStatus status of an application e.g. NEW, INTERVIEW_SCHEDULED, SCREENING etc.
     * @return a {@code List} of {@link JobApplication}
     */
    List<JobApplication> findAllByApplicantIdAndApplicationStatus(int applicantId, ApplicationStatus applicationStatus);

    /**
     * Returns all the {@link JobApplication} based on jobID.
     *
     * @param jobID an id which uniquely identifies job
     * @return {@code List} of {@link JobApplication}
     */
    List<JobApplication> findAllByJobId(int jobID);

}
