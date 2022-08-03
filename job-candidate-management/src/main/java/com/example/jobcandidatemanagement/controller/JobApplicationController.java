package com.example.jobcandidatemanagement.controller;

import com.example.jobcandidatemanagement.constant.ApplicationStatus;
import com.example.jobcandidatemanagement.dto.ApplicantDto;
import com.example.jobcandidatemanagement.dto.JobDto;
import com.example.jobcandidatemanagement.service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class JobApplicationController {

    public final JobApplicationService jobApplicationService;

    @PostMapping(value = "/jobs/{jobID}/apply")
    public void applyForJobs(@PathVariable("jobID") String jobID, @RequestParam("userID") String userID, @RequestParam("cv") MultipartFile file) {
        //todo : call to service method
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<List<ApplicantDto>> fetchAllApplicantsAppliedForJob(@PathVariable("id") int id) {
        return new ResponseEntity<>(jobApplicationService.getAllApplicantsAppliedForJob(id), HttpStatus.OK);
    }

    @GetMapping("/applications/{status}/applicant/{id}")
    public ResponseEntity<List<JobDto>> fetchAllJobsForApplicantByApplicationStatus(@PathVariable("status") ApplicationStatus applicationStatus, @PathVariable("id") int id) {
        return new ResponseEntity<>(jobApplicationService.getAllJobsForApplicantByApplicationStatus(id, applicationStatus), HttpStatus.OK);
    }
}
