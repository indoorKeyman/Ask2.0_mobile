package com.example.Jobs.service;

import com.example.Jobs.dto.JobApplicationsDTO;
import com.example.Jobs.repository.JobApplicationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class JobApplicationsService {

    private final JobApplicationsRepository jobApplicationsRepository;

    public List<JobApplicationsDTO> getAllJobsApplications(){
        return jobApplicationsRepository.getAllJobsApplications();
    }

    public List<JobApplicationsDTO> getPendingJobApplications(){
        return jobApplicationsRepository.getPendingJobApplications();
    }

    public List<JobApplicationsDTO> getApprovedJobApplications(){
        return jobApplicationsRepository.getApprovedJobApplications();
    }

    public List<JobApplicationsDTO> getRejectedJobApplications(){
        return jobApplicationsRepository.getRejectedJobApplications();
    }

    public List<JobApplicationsDTO> getByIdJobApplications(Integer members_index){

        Map<String, Object> params = new HashMap<>();
        params.put("members_index", members_index);

        return jobApplicationsRepository.getByIdJobApplications(params);
    }

    public Boolean makeJobApplications(
            Integer jobs_index,
            Integer members_index,
            String self_introduction
    ){

        Map<String, Object> params = new HashMap<>();
        params.put("jobs_index", jobs_index);
        params.put("members_index", members_index);
        params.put("self_introduction", self_introduction);

        return jobApplicationsRepository.makeJobApplications(params) > 0 ? true : false;
    }

    public Boolean updateJobApplications(
            Integer application_index,
            String self_introduction
    ){
        Map<String, Object> params = new HashMap<>();
        params.put("application_index", application_index);
        params.put("self_introduction", self_introduction);

        return jobApplicationsRepository.updateJobApplications(params) > 0 ? true : false;
    }

}
