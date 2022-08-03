package com.example.jobcandidatemanagement.controller;

import com.example.jobcandidatemanagement.dto.JobDto;
import com.example.jobcandidatemanagement.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping("/jobs/{id}")
    public ResponseEntity<JobDto> getJobById(@PathVariable("id") int id) {
        return new ResponseEntity<JobDto>(jobService.getJobById(id), HttpStatus.OK);
    }

    public void applyForJobsUsingCV() {

    }
}
