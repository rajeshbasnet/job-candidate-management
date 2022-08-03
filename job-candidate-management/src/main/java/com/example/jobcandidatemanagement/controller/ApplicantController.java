package com.example.jobcandidatemanagement.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.jobcandidatemanagement.dto.ApplicantDto;
import com.example.jobcandidatemanagement.dto.EducationDto;
import com.example.jobcandidatemanagement.dto.ExperienceDto;
import com.example.jobcandidatemanagement.service.ApplicantService;

@RestController
@RequestMapping("/applicants")
@RequiredArgsConstructor
public class ApplicantController {

    private final ApplicantService applicantService;

    @GetMapping("/{id}")
    public ResponseEntity<ApplicantDto> fetchApplicantFromApplicantId(@PathVariable("id") int id) {
        return new ResponseEntity<>(applicantService.getApplicantFromApplicantId(id), HttpStatus.OK);
    }


    @PostMapping("/cv/upload")
    public ResponseEntity<String> uploadCV(@RequestParam("cv") MultipartFile cv, @RequestParam("applicantID") int applicantID) {
        applicantService.uploadCVForApplicant(cv, applicantID);
        return ResponseEntity.status(HttpStatus.OK).body("CV has been successfully uploaded");
    }


    @GetMapping("/{id}/education")
    public ResponseEntity<List<EducationDto>> fetchEducationFromApplicantId(@PathVariable("id") int id) {
        return new ResponseEntity<>(applicantService.getEducationFromApplicantId(id), HttpStatus.OK);
    }


    @GetMapping("{id}/experiences")
    public ResponseEntity<List<ExperienceDto>> fetchExperienceFromApplicantId(@PathVariable("id") int id) {
        return new ResponseEntity<>(applicantService.getExperienceFromApplicantId(id), HttpStatus.OK);
    }

}
