package com.example.jobcandidatemanagement.exception;

public class JobAlreadyAppliedException extends RuntimeException{
    public JobAlreadyAppliedException(String message) {
        super(message);
    }
}
