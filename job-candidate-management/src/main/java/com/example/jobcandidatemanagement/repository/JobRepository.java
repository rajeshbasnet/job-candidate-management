package com.example.jobcandidatemanagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.jobcandidatemanagement.constant.JobStatus;;
import com.example.jobcandidatemanagement.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    /**
     * Returns all jobs by companyId and JobStatus based on the parameters passed.
     *
     * @param companyId an id which uniquely identifies company
     * @param jobStatus status of a job e.g. ACTIVE, INACTIVE
     * @return a {@code List} of {@link Job}
     */
    List<Job> findAllByCompanyIdAndJobStatus(int companyId, JobStatus jobStatus);

    /**
     * Returns database and search as per the requirements passed in parameter.
     *
     * @param jobStatus a status of a job
     * @return a {@code List} of {@link Job}
     */
    List<Job> findAllByJobStatus(JobStatus jobStatus);

    @Modifying
    @Query("update Job j set j.jobStatus = com.example.jobcandidatemanagement.constant.JobStatus.INACTIVE where j.jobStatus = :jobStatus and j.startDate <= :localDate")
    void activateAllJobsByJobStatusAndStartDateLessThanEqual(@Param("jobStatus") JobStatus jobStatus, @Param("localDate") LocalDate localDate);

    @Modifying
    @Query("update Job j set j.jobStatus = com.example.jobcandidatemanagement.constant.JobStatus.ACTIVE where j.jobStatus = :jobStatus and j.endDate <= :localDate")
    void deactivateAllJobsByJobStatusAndEndDateLessThanEqual(@Param("jobStatus") JobStatus jobStatus, @Param("localDate") LocalDate localDate);

}
