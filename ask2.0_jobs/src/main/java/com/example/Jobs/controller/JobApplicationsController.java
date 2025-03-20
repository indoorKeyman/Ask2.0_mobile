package com.example.Jobs.controller;


import com.example.Jobs.dto.JobApplicationsDTO;
import com.example.Jobs.dto.JobsDTO;
import com.example.Jobs.service.JobApplicationsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("/jobs")
public class JobApplicationsController {

    private final JobApplicationsService jobApplicationsService;

    public JobApplicationsController(JobApplicationsService jobApplicationsService) {
        this.jobApplicationsService = jobApplicationsService;
    }

    @GetMapping("/application_all_list")
    public ResponseEntity<List<JobsDTO>> getAllJobsApplications () {

        log.info("Request getAllJobsApplications received");

        List result = jobApplicationsService.getAllJobsApplications();

        if (!result.isEmpty()){
            log.info("Response getAllJobsApplications sent: Success");
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/application_pending_list")
    public ResponseEntity<List<JobsDTO>> getPendingJobApplications () {

        log.info("Request getPendingJobApplications received");

        List result = jobApplicationsService.getPendingJobApplications();

        if (!result.isEmpty()){
            log.info("Response getPendingJobApplications sent: Success");
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/application_approved_list")
    public ResponseEntity<List<JobsDTO>> getApprovedJobApplications () {

        log.info("Request getApprovedJobApplications received");

        List result = jobApplicationsService.getApprovedJobApplications();

        if (!result.isEmpty()){
            log.info("Response getApprovedJobApplications sent: Success");
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/application_rejected_list")
    public ResponseEntity<List<JobsDTO>> getRejectedJobApplications () {

        log.info("Request getRejectedJobApplications received");

        List result = jobApplicationsService.getRejectedJobApplications();

        if (!result.isEmpty()){
            log.info("Response getRejectedJobApplications sent: Success");
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/application_list_id")
    public ResponseEntity<List<JobsDTO>> getByIdJobApplications (
            @RequestParam Integer members_index
    ) {

        log.info("Request getByIdJobApplications received");

        List result = jobApplicationsService.getByIdJobApplications(members_index);

        if (!result.isEmpty()){
            log.info("Response getByIdJobApplications sent: Success");
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping("/make_jobapplications")
    public ResponseEntity<String> makeJobApplications (
            @RequestBody JobApplicationsDTO request
    ) {

        log.info("Request makeJobApplications received");

        Boolean result = jobApplicationsService.makeJobApplications(
                request.getJobs_index(),
                request.getMembers_index(),
                request.getSelf_introduction()
        );

        if (result){
            log.info("Response makeJobApplications sent: Success");
        }

        return ResponseEntity.ok(result ? "Successful makeJobApplications" : "Failed makeJobApplications" );
    }

    @PatchMapping("/update_jobapplications")
    public ResponseEntity<String> updateJobApplications (
            @RequestParam Integer application_index,
            @RequestBody JobApplicationsDTO request
    ) {

        log.info("Request updateJobApplications received");

        Boolean result = jobApplicationsService.updateJobApplications(
                application_index,
                request.getSelf_introduction()
        );

        if (result){
            log.info("Response updateJobApplications sent: Success");
        }

        return ResponseEntity.ok(result ? "Successful updateJobApplications" : "Failed updateJobApplications" );
    }


}
