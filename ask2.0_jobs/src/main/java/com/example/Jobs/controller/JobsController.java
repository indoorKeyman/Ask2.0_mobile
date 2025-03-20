package com.example.Jobs.controller;

import com.example.Jobs.dto.JobsDTO;
import com.example.Jobs.service.JobsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("/jobs")
public class JobsController {

    private final JobsService jobsService;

    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @GetMapping("/list/end")
    public ResponseEntity<List<JobsDTO>> getEndJobs () {

        log.info("Request getEndJobs received");

        List result = jobsService.getEndJobs();

        if (!result.isEmpty()){
            log.info("Response getEndJobs sent: Success");
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/list/recruit")
    public ResponseEntity<List<JobsDTO>> getRecruitJobs () {

        log.info("Request getRecruitJobs received");

        List result = jobsService.getRecruitJobs();

        if (!result.isEmpty()){
            log.info("Response getRecruitJobs sent: Success");
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{jobs_index}")
    public ResponseEntity<JobsDTO> getJobsById ( @PathVariable("jobs_index") Integer jobs_index) {

        log.info("Request getJobsById received");

        JobsDTO result = jobsService.getJobsById(jobs_index);

        if (result != null){
            log.info("Response getJobsById sent: Success");
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/list")
    public ResponseEntity<List<JobsDTO>> getAllJobs () {

        log.info("Request getAllJobs received");

        List result = jobsService.getAllJobs();

        if (!result.isEmpty()){
            log.info("Response getAllJobs sent: Success");
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping("/make_jobs")
    public ResponseEntity<String> makeJobs (
            @RequestBody JobsDTO request
    ) {

        log.info("Request makeJobs received");

        Boolean result = jobsService.makeJobs(
                request.getMember_index(),
                request.getTitle(),
                request.getLocation(),
                request.getLevel(),
                request.getResponsibilities(),
                request.getQualification(),
                request.getPreferences(),
                request.getStart_date(),
                request.getEnd_date()
        );

        if (result){
            log.info("Response makeJobs sent: Success");
        }

        return ResponseEntity.ok(result ? "Successful makeJobs" : "Failed makeJobs" );
    }

    @DeleteMapping("/delete_jobs")
    public ResponseEntity<String> deleteJobs (
            @RequestParam Integer jobs_index
    ) {

        log.info("Request deleteJobs received");

        Boolean result = jobsService.deleteJobs(jobs_index);

        if (result){
            log.info("Response deleteJobs sent: Success");
        }

        return ResponseEntity.ok(result ? "Successful deleteJobs" : "Failed deleteJobs" );
    }

    @PatchMapping("/update_jobs")
    public ResponseEntity<String> updateJobs (
            @RequestParam Integer jobs_index,
            @RequestBody JobsDTO request
    ) {

        log.info("Request updateJobs received");

        Boolean result = jobsService.updateJobs(
                jobs_index,
                request.getTitle(),
                request.getLocation(),
                request.getLevel(),
                request.getResponsibilities(),
                request.getQualification(),
                request.getPreferences(),
                request.getStart_date(),
                request.getEnd_date()
        );

        if (result){
            log.info("Response updateJobs sent: Success");
        }

        return ResponseEntity.ok(result ? "Successful updateJobs" : "Failed updateJobs" );
    }
}
