package com.example.jobcandidatemanagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import com.example.jobcandidatemanagement.constant.JobCategoryType;
import com.example.jobcandidatemanagement.dto.JobCategoryDto;
import com.example.jobcandidatemanagement.service.JobService;

@Service
@SpringBootTest
public class TestDCategory {

    @Autowired
    private JobService jobService;

    @Test
    @Order(1)
    public void testSaveJobCategory() {
        JobCategoryDto jobCategoryDto = JobCategoryDto.builder()
                .category(JobCategoryType.TEACHING)
                .build();
        Assertions.assertDoesNotThrow(() -> {
            JobCategoryDto responseDto = jobService.saveJobCategory(jobCategoryDto);
            System.out.println(responseDto);
        });
    }

    @Test
    @Order(2)
    public void testGetJobCategory() {
        int id = 1;
        JobCategoryDto jobCategoryDto = jobService.getJobCategoryFromId(id);
        System.out.println(jobCategoryDto);
    }
}
