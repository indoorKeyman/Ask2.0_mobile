package com.example.Jobs.service;


import com.example.Jobs.dto.JobsDTO;
import com.example.Jobs.repository.JobsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class JobsService {


    private final JobsRepository jobsRepository;

    public List<JobsDTO> getEndJobs(){
        return jobsRepository.getEndJobs();
    }

    public List<JobsDTO> getRecruitJobs(){
        return jobsRepository.getRecruitJobs();
    }

    public JobsDTO getJobsById(Integer jobs_index){
        return jobsRepository.getJobsById(jobs_index);
    }

    public List<JobsDTO> getAllJobs(){
        return jobsRepository.getAllJobs();
    }

    public Boolean makeJobs(
            Integer member_index,
            String title,
            String location,
            String level,
            String responsibilities,
            String qualification,
            String preferences,
            Date start_date,
            Date end_date
    ){
        Map<String, Object> params = new HashMap<>();
        params.put("member_index", member_index);
        params.put("title", title);
        params.put("location", location);
        params.put("level", level);
        params.put("responsibilities", responsibilities);
        params.put("qualification", qualification);
        params.put("preferences", preferences);
        params.put("start_date", start_date);
        params.put("end_date", end_date);

        return jobsRepository.makeJobs(params) > 0 ? true : false;
    }

    public Boolean deleteJobs(Integer jobs_index){

        Map<String, Object> params = new HashMap<>();
        params.put("jobs_index", jobs_index);

        return jobsRepository.deleteJobs(params) > 0 ? true : false;
    }

    public Boolean updateJobs(
            Integer jobs_index,
            String title,
            String location,
            String level,
            String responsibilities,
            String qualification,
            String preferences,
            Date start_date,
            Date end_date
    ){
        Map<String, Object> params = new HashMap<>();
        params.put("jobs_index", jobs_index);
        params.put("title", title);
        params.put("location", location);
        params.put("level", level);
        params.put("responsibilities", responsibilities);
        params.put("qualification", qualification);
        params.put("preferences", preferences);
        params.put("start_date", start_date);
        params.put("end_date", end_date);

        return jobsRepository.updateJobs(params) > 0 ? true : false;
    }
}
